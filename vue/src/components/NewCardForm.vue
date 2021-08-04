<template>
  <div>
    <table></table>
    <button
      v-on:click="
        toggleForm();
        clearForm();
      "
      v-text="showForm ? 'Cancel' : 'CREATE NEW CARD'"
    ></button>
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
      <input placeholder="Enter keyword" type="text" v-model="keywordToAdd" />
      <button @click.prevent="addNewKeyword">+Keyword</button>
      <div>
        <h4 v-show="this.flashcard.keywords.length === 0">
          At least 1 keyword required
        </h4>
        <button
          v-show="this.flashcard.keywords.length !== 0"
          v-on:click.prevent="addNewFlashcard"
        >
          Finished
        </button>
      </div>
      <table v-show="this.flashcard.keywords.length !== 0">
        <th>Keywords</th>
        <tr v-for="keyword in this.flashcard.keywords" v-bind:key="keyword.id">
          <td>{{ keyword }}</td>
        </tr>
      </table>
    </form>
  </div>
</template>

<script>
import FlashcardService from "@/services/FlashcardService";
export default {
  name: "new-card-form",
  components: {},
  data() {
    return {
      flashcard: {
        userId: this.$store.state.user.id,
        question: "",
        answer: "",
        keywords: [],
      },
      keywordToAdd: "",
      showForm: false,
    };
  },
  methods: {
    addNewFlashcard() {
      this.addNewKeyword();
      FlashcardService.addCard(this.flashcard).then((response) => {
        if (response.status === 201) {
          this.$router.push("/editFlashcard");
        }
      });
      this.clearForm();
      this.toggleForm();
    },
    addNewKeyword() {
      if (this.keywordToAdd != "" && !this.flashcard.keywords.includes(this.keywordToAdd)) {
        this.flashcard.keywords.push(this.keywordToAdd);
        this.keywordToAdd = "";
      }
    },
    toggleForm() {
      this.showForm = !this.showForm;
    },
    clearForm() {
      this.flashcard.question = "";
      this.flashcard.answer = "";
      this.flashcard.keywords = [];
    },
  },
};
</script>

<style>
</style>