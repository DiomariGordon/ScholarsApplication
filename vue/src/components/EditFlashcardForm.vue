<template>
  <div>
    <button
      v-show="showForm && editedFlashcard.keywords.length != 0"
      v-on:click.prevent="editCard"
    >
      Submit
    </button>
    <button
      v-on:click.prevent="toggleForm"
      v-text="showForm ? 'Cancel' : 'Edit this Card'"
    ></button>
    <form v-if="showForm">
      <input
        required
        type="text"
        id="editFront"
        v-model="editedFlashcard.question"
      />
      <input
        required
        type="text"
        id="editBack"
        v-model="editedFlashcard.answer"
      />
      <input type="text" placeholder="Add Keywords" v-model="keywordToAdd" />
      <button v-on:click.prevent="addKeyword()">+Keyword</button>
      <h4 v-show="editedFlashcard.keywords.length === 0">
        At least 1 keyword required
      </h4>
      <table v-show="editedFlashcard.keywords.length != 0" class="keywordTable">
        <th>Keywords</th>
        <tr v-for="keyword in editedFlashcard.keywords" v-bind:key="keyword.id">
          <td>{{ keyword }}</td>
        </tr>
      </table>
      <button
        v-on:click.prevent="resetKeywords"
        v-show="editedFlashcard.keywords.length != 0"
      >
        Clear Keywords
      </button>
    </form>
  </div>
</template>

<script>
export default {
  name: "edit-flashcard-form",
  props: ["cardId", "question", "answer", "keywords"],
  data() {
    return {
      editedFlashcard: {
        flashcardId: this.cardId,
        userId: this.$store.state.user.id,
        question: this.question,
        answer: this.answer,
        keywords: this.keywords,
      },
      keywordToAdd: "",
      showForm: false,
    };
  },
  methods: {
    toggleForm() {
      this.showForm = !this.showForm;
    },
    resetKeywords() {
      this.editedFlashcard.keywords = [];
    },
    addKeyword() {
      if (
        this.keywordToAdd != "" &&
        !this.editedFlashcard.keywords.includes(this.keywordToAdd.toLocaleLowerCase())
      ) {
        this.editedFlashcard.keywords.push(this.keywordToAdd.toLocaleLowerCase());
        this.keywordToAdd = "";
      }
    },
    editCard() {
      if (
        this.editedFlashcard.question != "" &&
        this.editedFlashcard.answer != ""
      ) {
        console.log("success");
        this.toggleForm();
      }
    },
  },
};
</script>

<style>
</style>