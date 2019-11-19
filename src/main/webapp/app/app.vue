<template>
  <div id="app">      
    <div id="app-header">
      <jhi-navbar></jhi-navbar>
    </div>
    <div class="ib-container">
      <div class="router-view">
        <router-view></router-view>
      </div>
      <b-modal id="login-page" hide-footer lazy>
        <span slot="modal-title" id="login-title">Sign in</span>
        <login-form></login-form>
      </b-modal>      
    </div>
    <jhi-footer></jhi-footer>
  </div>
</template>

<script lang="ts" src="./app.component.ts">
</script>


<style scoped>
  .ib-container {    
    margin: 0px;
    min-height: 500px;
  }
</style>