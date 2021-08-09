<template>
  <div>
    <div v-for="deck in myDecks" v-bind:key="deck.id">
      <router-link class="deckList" :to="{ path: `/deck/${deck.deckId}` }">{{
        deck.name
      }}</router-link>
    </div>
  </div>
</template>

<script>
import DeckService from "@/services/DeckService";
export default {
  name: "my-decks-list",
  components: {},
  created() {
    DeckService.getMyDecks(this.$store.state.user.id).then((response) => {
      const decks = response.data;
      this.$store.commit("SET_DECKS", decks);
      return decks;
    });
  },
  data() {
    return {
      myDecks: this.$store.state.decks,
    };
  },
};
</script>

<style>
.deckList {
    text-decoration: none;
    color: white;
    font-size: 30px;
}
</style>