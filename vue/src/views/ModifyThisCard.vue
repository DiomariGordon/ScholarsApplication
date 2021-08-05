<template>
  <div>
    <h2>Edit This Card</h2>
    <div>
      <input
        type="text"
        v-show="this.showFront"
        v-model="this.flashcard.question"
      />
      <input
        type="text"
        v-show="!this.showFront"
        v-model="this.flashcard.answer"
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
      <button v-on:click="deleteThisCard">Delete This Card</button>
    </div>
    <table class="keywordTable">
      <th>Keywords</th>
      <tr v-for="keyword in this.flashcard.keywords" v-bind:key="keyword.id">
        <td>{{ keyword }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import FlashcardService from '@/services/FlashcardService'
export default {
  name: "modifyThisCard",
  data() {
    return {
      flashcard: {
        flashCardId: this.$route.params.id,
        question: "",
        answer: "",
        keywords: [],
      },
      showFront: true,
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
    deleteThisCard() {
      FlashcardService.deleteCard(this.flashcard.flashCardId).then((response) =>{
        if(response.status === 200 || response.status === 204) {
          this.$router.push("/myflashcards");
        }
      });
    }
  },
};
</script>

<style>
.flashcardDisplay {
  border: 2px solid black;
  border-radius: 10px;
  width: 450px;
  height: 150px;
  margin: 0 auto;
  background-image: url("../images/noteCard.jpg");
  background-size: cover;
}
.cardText {
  margin: 0 auto;
  font-size: 50px;
}
.keywordTable {
  margin: 0 auto;
  color: black;
}
.cardHead {
    color: black;
}
</style>