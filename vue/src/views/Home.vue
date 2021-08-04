<template>
  <div class="home">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lobster">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <router-link :to="{name: 'editflashcard'}" class="editCards">Flashcards</router-link>
    <router-link>Create Decks</router-link>
    <router-link>View Decks</router-link>
    <router-link>Study Session</router-link>
  </div>
</template>

<script>
export default {
  name: "home",
  components: {},
    data() {
        return {
            home: {
                flashcards: '',
                deck: '',
                deck_list: '',
                session: ''
            }
        }
    }
};
</script>

<style>
div {
  text-align: center;
  background-color: #5dd39e;
  color: #513b56;
}

h1 {
  font-family: "Lobster", sans-serif;
}

.editCards {
  align-content: center;
}

</style>
