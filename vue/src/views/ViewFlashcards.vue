<template>
  <div>
      <button @click="addNewFlashcard">Create flashcard</button>
      <form></form>
      <input
      placeholder="Question"
      type="text"
      v-model="flashcard.question"
      required
      />
      <input
      placeholder="Answer"
      type="text"
      v-model="flashcard.answer"
      required
      />
      <input
      placeholder="Enter keywords seperated by '/'"
      type="text"
      size="30"
      v-model="flashcard.keywords"
      required
      />
  </div>
</template>

<script>
export default {
    name: "create-flashcard",
    components: {},
    data() {
        return {
            flashcard: {
                creatorID: this.$store.state.user.id,
                question: '',
                answer: '',
                keywords: ''
            }
        }
    },
    methods: {
        addNewFlashcard() {
            this.$store.commit("ADD_FLASHCARD", this.flashcard);
            this.$router.push( {name: 'home'});
        }
    }

}
</script>

<style>

</style>