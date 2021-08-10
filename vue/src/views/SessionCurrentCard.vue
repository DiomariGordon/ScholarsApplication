<template>
  <div>
      <div class="flashcardDisplay">{{this.thisFlashcard.question}}</div>
  </div>
</template>

<script>
export default {
    data() {
        return {
            thisFlashcard: []
        }
    },
    created() {
        this.thisFlashcard = this.$store.state.flashcards.find((card) =>{
            return card.flashCardId == this.$route.params.cardId;
        });
    }

}
</script>

<style>

</style>