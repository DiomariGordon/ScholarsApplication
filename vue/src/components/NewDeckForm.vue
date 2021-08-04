<template>
  <div>
      <!-- <form v-if="showForm"> -->
        <form>
      <input
        placeholder="DeckName"
        type="text"
        v-model="deck.name"
        required
      />

      <button @click.prevent="addNewDeck">Submit</button>
      </form>
  </div>
</template>

<script>
export default {
    name: "new-deck-form",
    components: {},
    data() {
    return {
      deck: {
        userId: this.$store.state.user.id,
        deckName: ""

      },
      //showForm: false
    };

    },
    methods: {
   
    addNewDeck() {
    //   if (this.keywordToAdd != "" && !this.flashcard.keywords.includes(this.keywordToAdd)) {
    //     this.flashcard.keywords.push(this.keywordToAdd);
    //     this.keywordToAdd = "";
    //   }
    }
    }
}
</script>

<style>

</style>