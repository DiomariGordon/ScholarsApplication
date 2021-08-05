<template>
  <div>
      <h2>My Flashcards</h2>
      <router-link class="cardList" :to="{path: `/myFlashcards/${card.flashCardId}`}" v-for="card in this.$store.state.flashcards" v-bind:key="card.id">
          {{card.question}}
      </router-link>
  </div>
</template>

<script>
import FlashcardService from '@/services/FlashcardService'
export default {
    name: "my-cards-list",
    components: {},
    created() {
        FlashcardService.getMyCards(this.$store.state.user.id).then((response) =>{
            const cards = response.data;
            this.$store.commit("SET_FLASHCARDS", cards);
            return cards;
        });
       
    },
    data() {
        return { }
    }
}
</script>

<style>
.cardList {
    display: block;
    padding: 3px;
    border: 1px solid black;
    border-radius: 25px;
    width: 10vw;
    margin: 0 auto;
    
}

</style>