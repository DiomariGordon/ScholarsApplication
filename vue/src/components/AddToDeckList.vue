<template>
  <div>
    <h2>Click Cards to Add to Deck</h2>
    <div>
      <input
        type="text"
        placeholder="Search by Keywords"
        v-model="keywordToAdd"
      />
      <button v-on:click.prevent="addSearchKeyword">+Keyword</button>
      <button v-on:click.prevent="clearFilters">Reset Search Parameters</button>
    </div>
    <div class="miniCardContainer">
      <span
        v-on:click="addCardToDeck(card.flashCardId)"
        class="miniCard"
        v-bind:class="{ inDeck: newDeck.includes(card.flashCardId) }"
        v-on:click.prevent=""
        v-for="card in this.filteredList"
        v-bind:key="card.id"
      >
        {{ card.question }} &lt;=&gt; {{ card.answer }}
      </span>
    </div>
    <button v-on:click="addAll">Select All</button>
    <button v-on:click="removeAll">Deselect All</button>
    <table class="keywordTable" v-show="this.filters.length != 0">
      <th>Search Parameters</th>
      <tr v-for="param in this.filters" v-bind:key="param.id">
        <td>{{ param }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import FlashcardService from "@/services/FlashcardService";
export default {
  name: "add-to-deck-list",
  components: {},
  created() {
    FlashcardService.getMyCards(this.$store.state.user.id).then((response) => {
      const cards = response.data;
      this.$store.commit("SET_FLASHCARDS", cards);
      return cards;
    });
  },
  data() {
    return {
      filters: [],
      keywordToAdd: "",
      newDeck: [],
    };
  },
  computed: {
    filteredList() {
      let newList = this.$store.state.flashcards;
      if (this.filters.length != 0) {
        for (let i = 0; i < this.filters.length; i++) {
          newList = newList.filter((card) => {
            return card.keywords.includes(this.filters[i]);
          });
        }
      }
      return newList;
    },
  },
  methods: {
    addCardToDeck(cardId) {
      if (!this.newDeck.includes(cardId)) {
        this.newDeck.push(cardId);
      } else {
        this.newDeck = this.newDeck.filter((card) => {
          return card != cardId;
        });
      }
    },
    addAll() {
      for (let i = 0; i < this.filteredList.length; i++) {
        if (!this.newDeck.includes(this.filteredList[i].flashCardId)) {
          this.newDeck.push(this.filteredList[i].flashCardId);
        }
      }
    },
    removeAll() {
      for (let i = 0; i < this.filteredList.length; i++) {
        if (this.newDeck.includes(this.filteredList[i].flashCardId)) {
          this.newDeck = this.newDeck.filter((card) => {
            return card != this.filteredList[i].flashCardId;
          });
        }
      }
    },
    addSearchKeyword() {
      if (
        this.keywordToAdd != "" &&
        !this.filters.includes(this.keywordToAdd.toLocaleLowerCase())
      ) {
        this.filters.push(this.keywordToAdd.toLocaleLowerCase());
        this.keywordToAdd = "";
      }
    },
    clearFilters() {
      this.filters = [];
    },
  },
};
</script>

<style>
.inDeck {
  background-color: darkgoldenrod;
}
</style>