`<template>
  <div class="home">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Love+Ya+Like+A+Sister">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta">
    <!-- <p>You must be authenticated to see this</p> -->

    <nav>
      <div>
        <div class="row1">
          <div><a><router-link :to="{name: 'myflashcards'}" class="editCards">Flashcards</router-link></a></div>
          <div><a><router-link :to="{name: 'deck'}" class="createDeck">Create Decks</router-link></a></div>
        </div>
        <div class="row2">
          <div><a><router-link :to="{name: 'mydecks'}" class="viewDecks">View Decks</router-link></a></div>
          <div><a><router-link :to="{name: 'searchCard'}" class="viewCards">Search Cards</router-link></a></div>
        </div>
        <!-- <li><a><router-link>Study Session</router-link></a></li> -->
      </div>
      <!-- <img src="../images/fournotes.png"> -->
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
.editCards {
  align-content: center;
  font-size: 60px;
  width: 450px;
  height: 270px;
  margin: 0 auto;
  background-image: url("../images/blue.png");
  background-size: 100%;
}
.createDeck {
  align-content: center;
  font-size: 55px;
  width: 450px;
  height: 270px;
  margin: 0 auto;
  background-image: url("../images/yellow.png");
  background-size: 100%;
}
.viewDecks {
  align-content: center;
  font-size: 60px;
  width: 450px;
  height: 270px;
  margin: 0 auto;
  background-image: url("../images/red.png");
  background-size: 100%;
}
.viewCards {
  align-content: center;
  font-size: 55px;
  width: 450px;
  height: 270px;
  margin: 0 auto;
  background-image: url("../images/green.png");
  background-size: 100%;
}
.editCards:link {
  size: 40px;
  padding-top: 200px;
  display: block;
  color: white;
  text-decoration: none;
}
.createDeck:link {
  size: 40px;
  padding-top: 200px;
  display: block;
  color: white;
  text-decoration: none;
}
.viewDecks:link {
  size: 40px;
  padding-top: 200px;
  display: block;
  color: white;
  text-decoration: none;
}
.viewCards:link {
  size: 40px;
  padding-top: 200px;
  display: block;
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
.viewCards:visited {
  color: white;
}
.editCards:hover {
  color: black;
  padding-left: 5px;
}
.createDeck:hover {
  color: black;
  padding-left: 5px;
}
.viewDecks:hover {
  color: black;
  padding-left: 5px;
}
.viewCards:hover {
  color: black;
  padding-left: 5px;
}
.row1 {
    justify-content: space-between;
    display: flex;
  }
.row2 {
    justify-content: space-around;
    display: flex;
  }
</style>
