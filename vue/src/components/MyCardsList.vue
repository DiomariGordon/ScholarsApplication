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
export default {
    name: 'my-cards',
    data() {
        return {
            myCards: this.$store.flashcards
        }
    }
}
</script>

<style>

</style>