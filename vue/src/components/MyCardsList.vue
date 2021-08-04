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
        const cards = FlashcardService.getMyCards(this.$store.state.user.id).then((response) =>{
            return response.data;
        });
        this.$store.commit("SET_FLASHCARDS", cards);
        console.log('Working');
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