<template>
  <div>
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Love+Ya+Like+A+Sister"
    />
    <h2>Edit This Card</h2>
    <div>
      <edit-flashcard-form
        :question="flashcard.question"
        :cardId="flashcard.flashCardId"
        :answer="flashcard.answer"
        :keywords="flashcard.keywords"
      />
    </div>
    <div
      class="flashcardDisplay"
      id="cardFront"
      v-show="this.showFront"
      @click="flipCard"
    >
      <h4 class="cardHead">Front</h4>
      <h1 class="cardText">{{ this.flashcard.question }}</h1>
    </div>
    <div
      class="flashcardDisplay"
      id="cardBack"
      v-show="!this.showFront"
      @click="flipCard"
    >
      <h4 class="cardHead">Back</h4>
      <h1 class="cardText">{{ this.flashcard.answer }}</h1>
    </div>
    <div>
      <button v-show="!showDelConfirm" v-on:click="toggleDelConfirm">
        Delete This Card
      </button>
      <div v-show="showDelConfirm">
        <h2>Are you sure you want to delete this card?</h2>
        <div>
          <button v-on:click="deleteThisCard">Yes</button>
          <button v-on:click="toggleDelConfirm">No</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FlashcardService from "@/services/FlashcardService";
import EditFlashcardForm from "@/components/EditFlashcardForm";
export default {
  name: "modifyThisCard",
  components: {
    EditFlashcardForm,
  },
  data() {
    return {
      flashcard: {
        flashCardId: this.$route.params.id,
        question: "",
        answer: "",
        keywords: [],
      },
      showFront: true,
      showDelConfirm: false,
    };
  },
  created() {
    let thisCard = this.$store.state.flashcards.find((card) => {
      return card.flashCardId == this.$route.params.id;
    });
    this.flashcard.question = thisCard.question;
    this.flashcard.answer = thisCard.answer;
    this.flashcard.keywords = thisCard.keywords;
  },
  methods: {
    flipCard() {
      this.showFront = !this.showFront;
    },
    toggleDelConfirm() {
      this.showDelConfirm = !this.showDelConfirm;
    },
    deleteThisCard() {
      FlashcardService.deleteCard(this.flashcard.flashCardId).then(
        (response) => {
          if (response.status === 200 || response.status === 204) {
            this.$router.push("/myflashcards");
          }
        }
      );
    },
  },
};
</script>

<style>
.flashcardDisplay {
  border: 2px solid black;
  border-radius: 10px;
  width: 650px;
  height: 300px;
  margin: 0 auto;
  background-image: url("../images/noteCard.jpg");
  background-size: cover;
}
.cardText {
  margin: 0 auto;
  font-size: 70px;
  color: navy;
  font-family: "Love Ya Like A Sister", sans-serif;
}
.keywordTable {
  margin: 0 auto;
  color: white;
  font-family: "Love Ya Like A Sister", sans-serif;
}
.cardHead {
  font-size: 30px;
  color: black;
  font-family: "Love Ya Like A Sister", sans-serif;
}
</style>