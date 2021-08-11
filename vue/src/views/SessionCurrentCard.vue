<template>
  <div>
    <div v-show="!sessionFinished">
      <div
        v-show="
          !cardsCorrect.includes(currentCard.flashCardId) &&
          !cardsIncorrect.includes(currentCard.flashCardId)
        "
      >
        <h2 style="display: block">Mark your progress</h2>
        <button class='btn' v-on:click.prevent="markRight">Mark Correct</button>
        <button class='btn' v-on:click.prevent="markWrong">Mark Incorrect</button>
      </div>
      <div
        v-show="
          cardsCorrect.includes(currentCard.flashCardId) ||
          cardsIncorrect.includes(currentCard.flashCardId)
        "
      >
        <h2
          class="markMsg"
          v-text="
            cardsCorrect.includes(currentCard.flashCardId)
              ? 'Great job!'
              : 'Keep practicing'
          "
        ></h2>
      </div>
      <div
        v-bind:class="{
          right: cardsCorrect.includes(currentCard.flashCardId),
          wrong: cardsIncorrect.includes(currentCard.flashCardId),
        }"
        class="flashcardDisplay"
        id="cardFront"
        v-show="this.showFront"
        @click="flipCard"
      >
        <h4 class="cardHead">Front</h4>
        <h1 class="cardText">{{ currentCard.question }}</h1>
      </div>
      <div
        v-bind:class="{
          right: cardsCorrect.includes(currentCard.flashCardId),
          wrong: cardsIncorrect.includes(currentCard.flashCardId),
        }"
        class="flashcardDisplay"
        id="cardBack"
        v-show="!this.showFront"
        @click="flipCard"
      >
        <h4 class="cardHead">Back</h4>
        <h1 class="cardText">{{ currentCard.answer }}</h1>
      </div>
      <button class='btn' v-show="previousIndex >= 0" v-on:click.prevent="previousCard">
        &lt;&lt;Previous Card
      </button>
      <button 
        class='btn'
        v-show="nextIndex < this.flashcards.length"
        v-on:click.prevent="nextCard"
      >
        Next Card&gt;&gt;
      </button>
      <div>
        <button
          class='btn'
          v-on:click.prevent="finish"
          v-show="studySessionInfo.attemptedQuiz != 0"
        >
          Finish Study Session
        </button>
      </div>
    </div>
    <div v-show="sessionFinished">
      <h1 v-show="percentageCorrect == 1">Incredible!</h1>
      <h1 v-show="percentageCorrect >= 0.85 && percentageCorrect < 1">
        Well Done!
      </h1>
      <h1 v-show="percentageCorrect >= 0.7 && percentageCorrect < 0.85">
        Not bad
      </h1>
      <h1 v-show="percentageCorrect < 0.7">Keep trying</h1>
      <h2>
        You scored {{ studySessionInfo.totalRight }} out of
        {{ studySessionInfo.attemptedQuiz }} attempted.
      </h2>
    </div>
  </div>
</template>

<script>
import DeckService from "@/services/DeckService";
import SessionService from "@/services/SessionService";
export default {
  data() {
    return {
      showFront: true,
      flashcards: [],
      currentCard: {},
      studySessionInfo: {
        deckId: this.$route.params.deckId,
        userId: this.$store.state.user.id,
        attemptedQuiz: 0,
        totalRight: 0,
      },
      cardsCorrect: [],
      cardsIncorrect: [],
      sessionFinished: false,
    };
  },

  created() {
    DeckService.getDeckCards(this.$route.params.deckId).then((response) => {
      this.flashcards = response.data;
      this.currentCard = this.flashcards[this.$route.params.cardIndex];
    });
  },
  computed: {
    nextIndex() {
      return parseInt(this.$route.params.cardIndex) + 1;
    },
    previousIndex() {
      return parseInt(this.$route.params.cardIndex) - 1;
    },
    percentageCorrect() {
      if (this.studySessionInfo.attemptedQuiz != 0) {
        return (
          this.studySessionInfo.totalRight / this.studySessionInfo.attemptedQuiz
        );
      } else {
        return 0;
      }
    },
  },
  methods: {
    finish() {
      this.sessionFinished = true;
      SessionService.createSession(this.studySessionInfo).then((response) => {
        console.log(response.status);
      });
    },
    markRight() {
      this.studySessionInfo.attemptedQuiz++;
      this.studySessionInfo.totalRight++;
      this.cardsCorrect.push(this.currentCard.flashCardId);
    },
    markWrong() {
      this.studySessionInfo.attemptedQuiz++;
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
.markMsg {
  display: block;
  font-size: 33px;
}

.btn{
        display:inline-block;
        padding:0.7em 1.7em;
        margin:0 0.3em 0.3em 0;
        border-radius:0.25rem;
        box-sizing: border-box;
        text-decoration:none;
        /* font-family:'Roboto',sans-serif; */
        font-family: "Love Ya Like A Sister", sans-serif;
        font-weight:400;
        color:#FFFFFF;
        background-color:#3369ff;
        box-shadow:inset 0 -0.6em 1em -0.35em rgba(0,0,0,0.17),inset 0 0.6em 2em -0.3em rgba(255,255,255,0.15),inset 0 0 0em 0.05em rgba(255,255,255,0.12);
        text-align:center;
        position:relative;
    }
</style>