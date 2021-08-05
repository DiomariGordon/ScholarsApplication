import axios from 'axios';


export default {
addDeck(deck) {
    return axios.post('/deck', deck);
  },

  getMyDecks(id) {
    return axios.get(`/deck/${id}`);
  }
}


