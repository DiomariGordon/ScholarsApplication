<template>
  <div id="app">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta">
    <div id="nav">
      <h1>
      <router-link class="home" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp;
      </h1>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
  .home {
    font-family: "Mukta", sans-serif;
    font-size: 25px;
    display: inline-block;
  }

  .home:visited {
    color: #eae2b7;
  }
</style>

