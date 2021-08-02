<template>
  <div id="login" class="text-center">
    <h1 class="title">Welcome to Scholars!</h1>
    <img class="imgHat" src="@/images/hat.png" alt="An image of a graduation cap">
    <form class="form-signin" @submit.prevent="login">
      <h2 class="h3 mb-3 font-weight-normal">Please Sign In</h2>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
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
      <router-link :to="{ name: 'register' }" class="rLink">Need an account?</router-link>
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
      invalidCredentials: false
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
    display: block;
    padding: 10px;
  }
  .btnSubmit {
    text-align: center;
    margin: 10px;
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
    background-color: aqua;
  }
</style>