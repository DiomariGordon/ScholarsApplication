<template>
  <div id="app">
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
    background-color: #d62828;
    font-size: 25px;
    border: 2px solid #eae2b7;
    display: inline-block;
  }
</style>

