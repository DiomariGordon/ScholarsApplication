<template>
  <div>
    <div v-show="!cardsCorrect.includes(currentCard.flashCardId) && !cardsIncorrect.includes(currentCard.flashCardId)">
      <button v-on:click.prevent="markRight">Mark Correct</button>
      <button v-on:click.prevent="markWrong">Mark Incorrect</button>
    </div>
    <div
      v-bind:class="{right: cardsCorrect.includes(currentCard.flashCardId), wrong: cardsIncorrect.includes(currentCard.flashCardId)}"
      class="flashcardDisplay"
      id="cardFront"
      v-show="this.showFront"
      @click="flipCard"
    >
      <h4 class="cardHead">Front</h4>
      <h1 class="cardText">{{ currentCard.question }}</h1>
    </div>
    <div
      v-bind:class="{right: cardsCorrect.includes(currentCard.flashCardId), wrong: cardsIncorrect.includes(currentCard.flashCardId)}"
      class="flashcardDisplay"
      id="cardBack"
      v-show="!this.showFront"
      @click="flipCard"
    >
      <h4 class="cardHead">Back</h4>
      <h1 class="cardText">{{ currentCard.answer }}</h1>
    </div>
    <button v-show="previousIndex >= 0" v-on:click.prevent="previousCard">
      &lt;&lt;Previous Card
    </button>
    <button
      v-show="nextIndex < this.flashcards.length"
      v-on:click.prevent="nextCard"
    >
      Next Card&gt;&gt;
    </button>
  </div>
</template>

<script>
import DeckService from "@/services/DeckService";
export default {
  data() {
    return {
      showFront: true,
      flashcards: [],
      currentCard: {},
      studySessionInfo: {
        deckId: this.$route.params.deckId,
        userId: this.$store.state.user.id,
        numberAttempted: 0,
        totalRight: 0,
      },
      cardsCorrect: [],
      cardsIncorrect: []
    };
  },

  created() {
    DeckService.getDeckCards(this.$route.params.deckId).then((response) => {
      this.flashcards = response.data;
      this.currentCard = this.flashcards[this.$route.params.cardIndex];
      console.log("getting cards");
    });
  },
  computed: {
    nextIndex() {
      return parseInt(this.$route.params.cardIndex) + 1;
    },
    previousIndex() {
      return parseInt(this.$route.params.cardIndex) - 1;
    },
  },
  methods: {
    markRight() {
      this.studySessionInfo.numberAttempted++;
      this.studySessionInfo.totalRight++;
      this.cardsCorrect.push(this.currentCard.flashCardId);
    },
    markWrong() {
      this.studySessionInfo.numberAttempted++;
      this.cardsIncorrect.push(this.currentCard.flashCardId);
    },
    flipCard() {
      this.showFront = !this.showFront;
    },
    nextCard() {
      this.currentCard = this.flashcards[this.nextIndex];
      this.showFront = true;
      this.$router.push(
        `/session/${this.$route.params.deckId}/${this.nextIndex}`
      );
    },
    previousCard() {
      this.currentCard = this.flashcards[this.previousIndex];
      this.showFront = true;
      this.$router.push(
        `/session/${this.$route.params.deckId}/${this.previousIndex}`
      );
    },
  },
};
</script>

<style>
.right {
    background-image: none;
    background-color: limegreen;
}
.wrong {
    background-image: none;
    background-color: red;
}
</style>