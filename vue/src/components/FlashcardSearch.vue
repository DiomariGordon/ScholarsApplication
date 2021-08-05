<template>
  <div>
        <!-- create a search field with the id search-term -->
        <!--<label for="search-term">Search </label> -->
        <input class="search-keyword" type="text" id="search-term" v-model= searchKeyword />
        <button  class="flashcard-search"  v-on:click="getCardsByKeyWord">Search</button>
        <div class="status-message" v-show="errorMsg !== ''">{{errorMsg}}</div>
       
       <div class="cards">
       <div   v-for="card in flashCards" v-bind:key="card.id"  >
       
            <!-- this should display  "flashcard-question"-->
            <div class="card">{{ card.question }}</div>
        
        </div>
       </div>
 </div>
</template>

<script>
import FlashcardService from '@/services/FlashcardService'
export default {
    name: "my-cards-list",
    components: {},
    data() {
        return {
            flashCards: [],
            searchKeyword: '',
            errorMsg: ""
        }
    },

    methods:{
            
         clearSerchField(){
            this.flashCards = [],
            this.errorMsg = ''
        },
        
        getCardsByKeyWord() {

            this.clearSerchField();

            if(this.searchKeyword == '' || this.searchKeyword == undefined){
                this.errorMsg = "Please enter a keyword." ;
                return;
            }
            FlashcardService.getCardsByKeyWord(this.$store.state.user.id, this.searchKeyword)
            .then(response =>{
                 if (response.status === 200) {
                this.flashCards = response.data;
               
                 }    
            })
            .catch(error => {
                if (error.response && error.response.status === 404) {
              this.errorMsg =
                "No Flashcard found with entered keyword: " + this.searchKeyword ;
            }

            });    
        }
    }    
}
</script>



<style scoped>
    /* label {
         display: block; 
    } */

    #serch-term {
        width: 70%;
    }

    .flashcard-search{
        display:inline-block;
        padding:0.7em 1.7em;
        margin:0 0.3em 0.3em 0;
        border-radius:0.2em;
        box-sizing: border-box;
        text-decoration:none;
        font-family:'Roboto',sans-serif;
        font-weight:400;
        color:#FFFFFF;
        background-color:#3369ff;
        box-shadow:inset 0 -0.6em 1em -0.35em rgba(0,0,0,0.17),inset 0 0.6em 2em -0.3em rgba(255,255,255,0.15),inset 0 0 0em 0.05em rgba(255,255,255,0.12);
        text-align:center;
        position:relative;
    }

    
    .search-keyword {
        height: 30px;
        width: 300px;
        background-color: white;
        display: inline-block;
        border-radius: 5px;
    }

    .body {
    background: #e2e1e0;
    text-align: center;
    color: black;
    }

    .card {
        box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
    background: #fff;
    border-radius: 2px;
    display: inline-block;
    margin: 1rem;
    position: relative;
    color: black;
    font-weight: bold;
    font-family: 'Courier New', Courier, monospace;
    text-justify: center;
    padding: 100px;
    font-size: 20px;
    }
   

    
      
</style>