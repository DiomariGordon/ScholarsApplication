<template>
  <div>
      <table>
          <th>My Decks</th>
          <tr v-for="deck in myDecks" v-bind:key="deck.id">
              <td>{{deck}}</td>
          </tr>
      </table>
  </div>
</template>

<script>
import DeckService from '@/services/DeckService'
export default {
    name: "my-decks-list",
    components: {},
    created() {
        DeckService.getMyDecks(this.$store.state.user.id).then((response) =>{
            const decks = response.data;
            this.$store.commit("SET_DECKS", decks);
            return decks;
        });
       
    },
    data() {
        return {
            myDecks: this.$store.state.decks
        }
    }
}
</script>

<style>

</style>