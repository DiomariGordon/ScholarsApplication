<template>
  <div>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Love+Ya+Like+A+Sister">
      <!-- <form v-if="showForm"> -->
        <form>
      <input class='field'
        placeholder="Deck Name"
        type="text"
        v-model="deck.name"
        required
      />

      <input class='field'
        placeholder="Deck Description"
        type="text"
        v-model="deck.description"
        required
      />

      <button class='btn' @click.prevent="addNewDeck">Submit</button>

      <div v-show="deckCreated">{{deck.name}} created successfully</div>
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
        name: "",
        description: ""

      },
      deckCreated: false

      //showForm: false
    };

    },
    methods: {
   
    addNewDeck() {
      this.deckCreated = false;
      DeckService.addDeck(this.deck).then((response) =>{
           this.deckCreated = response.data;
           console.log( this.deckCreated);
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