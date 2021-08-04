<template>
  <div>
      <table>
          <th>My Flashcards</th>
          <tr v-for="card in myCards" v-bind:key="card.id">
              <td>{{card.question}}</td>
          </tr>
      </table>
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
        return {
            myCards: this.$store.state.flashcards
        }
    }
}
</script>

<style>

</style>