`<template>
  <div class="home">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Love+Ya+Like+A+Sister">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta">
    <!-- <p>You must be authenticated to see this</p> -->
    <nav>
      <ul>
        <li><a><router-link :to="{name: 'myflashcards'}" class="editCards">Flashcards</router-link></a></li>
        <li><a><router-link :to="{name: 'deck'}" class="createDeck">Create Decks</router-link></a></li>
        <li><a><router-link :to="{name: 'mydecks'}" class="viewDecks">View Decks</router-link></a></li>
        <li><a><router-link :to="{name: 'searchCard'}" class="viewDecks">Search Cards</router-link></a></li>
        <!-- <li><a><router-link>Study Session</router-link></a></li> -->
      </ul>
    </nav>
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
  color: white;
}

h1 {
  font-family: "Love Ya Like A Sister", sans-serif;
}

.editCards {
  align-content: center;
}

ul {
  list-style-type: none;
  margin: 0 20px 0 20px;
  padding: 0;
}
li {
  font-family: "Love Ya Like A Sister", sans-serif;
  font-size: 2rem;
  font-weight: 400;
  text-transform: uppercase;
  border-bottom: 1px solid white;
  padding-top: 30px
}
.editCards:link {
  color: white;
  text-decoration: none;
}
.createDeck:link {
  color: white;
  text-decoration: none;
}
.viewDecks:link {
  color: white;
  text-decoration: none;
}
.createDeck:visited {
  color: white;
}
.editCards:visited {
  color: white;
}
.viewDecks:visited {
  color: white;
}
.editCards:hover {
  color: red;
  padding-left: 5px;
}
.createDeck:hover {
  color: red;
  padding-left: 5px;
}

.viewDecks:hover {
  color: red;
  padding-left: 5px;
}

</style>
