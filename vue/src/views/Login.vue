<template>
  <div id="login" class="text-center">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Monoton">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Gentium+Book+Basic">
    <h1 class="title">Scholars</h1>
    <img class="imgHat" src="@/images/hat.png" alt="An image of a graduation cap">
    <h2 @mouseover="hover = true" v-show="!hover" class="h3 mb-3 font-weight-normal">Please Sign In</h2>
    <form v-if="hover" @mouseleave="hover = false" class="form-signin" submit.prevent="login">
    
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and/or password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only"></label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only"></label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <div>
      <router-link :to="{ name: 'register' }" class="rLink">CREATE ACCOUNT</router-link>
      </div>
      <button class="btnSubmit" type="submit">Sign in</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: '',
        password: ''
      },
      invalidCredentials: false,
      hover: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>
  .sr-only {
    display: block;
    padding: 5px;
  }
  .rLink {
    padding: 10px;
  }
  .btnSubmit {
    text-align: center;
    margin: 10px;
    background-color: #513b56;
    color: #eae2b7;
  }
  .form-signin {
    text-align: center;
  }
  .title {
    text-align: center;
  }
  .imgHat {
    display: block;
    margin: 0 auto;
    height: 200px;
  }
  body {
    background-color:#003049;
  }
  h1 {
    font-family: "Monoton", sans-serif;
    color: #003049;
    font-size: 75px;
  }
  h2 {
    position: relative;
    display: inline-block;
    border: 3px solid #fcbf49;
    font-family: "Gentium Book Basic", sans-serif;
    color: #eae2b7;
    padding-top: 10px;
    padding-bottom: 10px;
    background-color: #d62828;
  }
  div {
    color: #eae2b7;
  }
</style>