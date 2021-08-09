<template>
  <div>
    <!-- <div class="mainContainer"> -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Love+Ya+Like+A+Sister">
    <h2>My Flashcards</h2>
    <div>
        <input type="text" placeholder="Search by Keywords" v-model="keywordToAdd">
        <button v-on:click.prevent="addSearchKeyword">+Keyword</button>
        <button v-on:click.prevent="clearFilters">Reset Search Parameters</button>
    </div>
    <div class="miniCardContainer">
      <router-link
        class="miniCard"
        :to="{ path: `/myFlashcards/${card.flashCardId}` }"
        v-for="card in this.filteredList"
        v-bind:key="card.id"
      >
        {{ card.question }}
      </router-link>
    </div>
    <table class="keywordTable" v-show="this.filters.length != 0">
        <th>Search Parameters</th>
        <tr v-for="param in this.filters" v-bind:key="param.id">
            <td>{{param}}</td>
        </tr>
    </table>
    </div>
  <!-- </div> -->
</template>

<script>
import FlashcardService from "@/services/FlashcardService";
export default {
  name: "my-cards-list",
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
        keywordToAdd: ''

    };
  },
  computed: {
      filteredList() {
          let newList = this.$store.state.flashcards;
          if(this.filters.length != 0) {
              for(let i = 0; i < this.filters.length; i++) {
              newList = newList.filter((card) =>{return card.keywords.includes(this.filters[i]);});
              }

                  }
          return newList;
      }
  },
  methods: {
      addSearchKeyword() {
          if(this.keywordToAdd != '' && !this.filters.includes(this.keywordToAdd.toLocaleLowerCase())) {
              this.filters.push(this.keywordToAdd.toLocaleLowerCase());
              this.keywordToAdd = '';
          }
      },
      clearFilters() {
          this.filters = [];
      }
  }
};
</script>

<style>
 .miniCard {
  margin: 7px;
  padding: 10px;
  border: 1px solid black;
  border-radius: 3px;
  background-image: url("../images/noteCard.jpg");
  background-size: contain;
  color: navy;
  font-family: "Monoton", sans-serif;
  text-decoration: none;
  font-size: 20px;
  font-family: "Love Ya Like A Sister", sans-serif;
}
.miniCardContainer {
  display: flex;
  flex-wrap: wrap;
  border: 3px solid antiquewhite;
  border-radius: 20px;
  width: 75vw;
  margin: 0 auto;
}

/*this is change*/

/* .mainContainer {
 display: grid;
 grid-template-columns: 300px 1fr 250px;
 grid-template-rows: 100px 1fr 1fr;
 gap: 15px;
  grid-template-areas:
 "header header header"
 "miniCardContainer miniCardContainer miniCardContainer"
 "miniCardContainer miniCardContainer miniCardContainer";

}
.miniCardContainer{
 grid-area: miniCardContainer;
}

.miniCardContainer {
 display: flex;
 justify-content: space-around;
}

.miniCardContainer {
 flex-direction: column;
} */

</style>