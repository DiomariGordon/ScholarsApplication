<template>
  <div>
      <!-- <form v-if="showForm"> -->
        <form>
      <input
        placeholder="Deck Name"
        type="text"
        v-model="deck.name"
        required
      />

      <input
        placeholder="Deck Description"
        type="text"
        v-model="deck.description"
        required
      />

      <button @click.prevent="addNewDeck">Submit</button>
      </form>
  </div>
</template>

<script>
import DeckService from "@/services/DeckService";
export default {
    name: "new-deck-form",
    components: {    },
    data() {
    return {
      deck: {
        userId: this.$store.state.user.id,
        deckName: "",
        deckDescription: ""

      },
      deckCreated: false

      //showForm: false
    };

    },
    methods: {
   
    addNewDeck() {

      DeckService.addDeck(this.deck).then((response) =>{
           this.deckCreated = response.data;
        });

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