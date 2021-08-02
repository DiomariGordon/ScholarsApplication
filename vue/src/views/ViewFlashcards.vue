<template>
  <div>
      <button>Create flashcard</button>
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
  </div>
</template>

<script>
export default {
    name: "create-flashcard",
    components: {},
    data() {
        return {
            flashcard: {
                flashcard_id: this.$store.state.user.user_id,
                question: '',
                answer: ''
            }
        }
    },
    methods: {
        addNewFlashcard() {
            const flashcardID = this.$route.params.flashcard_id;
            this.flashcard.flashcardID = flashcardID;
            this.$store.commit("ADD_FLASHCARD", this.flashcard);
            this.$router.push( {name: 'editflashcard'})
        }
    }

}
</script>

<style>

</style>