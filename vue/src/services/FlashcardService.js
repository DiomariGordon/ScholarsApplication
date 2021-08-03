import axios from 'axios';


export default {
addCard(flashcard) {
    return axios.post('/flashCards', flashcard);
  }
}

