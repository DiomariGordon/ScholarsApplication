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

}
}
</script>

<style>

</style>