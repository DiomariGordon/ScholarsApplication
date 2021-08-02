import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    flashcards: [
      {
        id: 1,
        question: "2 + 2",
        answer: "4"
      },
      {
        id: 2,
        question: "What is pi?",
        answer: "3.14159"
      },
      {
        id: 3,
        question: "What color does blue mixed with red make?",
        answer: "Purple"
      }
    ]
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    ADD_FLASHCARD(state, flash) {
      const card = this.state.flashcards.find(c => c.id === flash.flashcardID);
      let maxID = card.id * 1000;
      maxID = card.flash.reduce( (maxID, flash) => {
        return Math.max(maxID, flash.id);
      }, maxID);
      flash.id = maxID + 1;
      card.flash.unshift(flash);
    }
  }
})
