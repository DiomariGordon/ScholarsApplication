<template>
  <div>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Love+Ya+Like+A+Sister">
    <h2>Click Cards to Add to Deck</h2>
    <div>
      <input class='field'
        type="text"
        placeholder="Search by Keywords"
        v-model="keywordToAdd"
      />
      <button class='btn' v-on:click.prevent="addSearchKeyword">+Keyword</button>
      <button class='btn' v-on:click.prevent="clearFilters">Reset Search Parameters</button>
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
    <button class='btn' v-on:click="addAll">Select All</button>
    <button class='btn' v-on:click="removeAll">Deselect All</button>
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
  background-image: none;
  background-color: limegreen;
}
.btn{
        display:inline-block;
        padding:0.7em 1.7em;
        margin:0 0.3em 0.3em 0;
        border-radius:0.25rem;
        box-sizing: border-box;
        text-decoration:none;
        font-family: "Love Ya Like A Sister", sans-serif;
        /* font-family:'Roboto',sans-serif; */
        font-weight:400;
        color:#FFFFFF;
        background-color:#3369ff;
        box-shadow:inset 0 -0.6em 1em -0.35em rgba(0,0,0,0.17),inset 0 0.6em 2em -0.3em rgba(255,255,255,0.15),inset 0 0 0em 0.05em rgba(255,255,255,0.12);
        text-align:center;
        position:relative;
    }

    .field{
        display:inline-block;
        height: 30px;
        width: 300px;
        background-color: white;
        display: inline-block;
        border-radius: 5px;
    
    }

</style>