<template>
  <div>
      <button v-show="!showForm" v-on:click="toggleForm">Create New Card</button>
      <form v-if="showForm">
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
      placeholder="Enter keyword"
      type="text"
      v-model="keywordToAdd"
      />
      <button @click.prevent="addNewKeyword">+Keyword</button>
      <div>
          <h4 v-show="this.flashcard.keywords.length === 0">At least 1 keyword required</h4>
          <input v-show="this.flashcard.keywords.length !== 0" type="submit" v-on:submit.prevent="addNewFlashcard" />
      </div>
      </form>
  </div>
</template>

<script>
import FlashcardService from '@/services/FlashcardService'
export default {
    name: "create-flashcard",
    components: {},
    data() {
        return {
            flashcard: {
                userId: this.$store.state.user.id,
                question: '',
                answer: '',
                keywords: []
            },
            keywordToAdd: '',
            showForm: false
        }
    },
    methods: {
        addNewFlashcard() {
            this.addNewKeyword();
            FlashcardService.addCard(this.flashcard).then((response) =>{
                if(response.status === 201) {
                    this.$router.push('/editFlashcard');
                }
            });
            this.toggleForm();
            

        },
        addNewKeyword() {
            if(this.keywordToAdd != '') {
            this.flashcard.keywords.push(this.keywordToAdd);
            this.keywordToAdd = '';
            }
        },
        toggleForm() {
            this.showForm = !this.showForm;
        }
    }
}
</script>

<style>

</style>