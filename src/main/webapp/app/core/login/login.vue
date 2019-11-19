<template>
    <div class="login-container">        
        <div class="page-header">
            <h3>{{headerName}}</h3>
        </div>
        <div class="login-section">
            <div class="container-fluid">    
                <div class="row">
                    <div class="col-md-8">
                        <div class="login-form">
                            <div class="row justify-content-center">                            
                                <div class="col-md-8">
                                    <b-alert show variant="danger" v-if="authenticationError" >
                                        <strong>Failed to sign in!</strong> Please check your credentials and try again.
                                    </b-alert>
                                </div>
                                <div class="col-md-8">
                                    <b-form role="form" v-on:submit.prevent="doLogin()">
                                        <b-form-group label="Username"  label-for="username">
                                            <b-form-input id="username" type="text" name="username" autofocus  placeholder="Your username" v-model="login">
                                            </b-form-input>
                                        </b-form-group>
                                        <b-form-group label="Password"  label-for="password">
                                            <b-form-input id="password" type="password" name="password" v-model.trim="name"  placeholder="Your password" v-model="password">
                                            </b-form-input>
                                        </b-form-group>
                                        <b-form-checkbox id="rememberMe" name="rememberMe" v-model="rememberMe" checked >
                                        <span>Remember me</span>
                                        </b-form-checkbox>
                                        <div>
                                            <b-button type="submit" variant="primary">Sign in</b-button>
                                        </div>
                                    </b-form>
                                    <p></p>
                                    <div>
                                        <b-alert show variant="warning">
                                            <b-link :to="'/reset/request'" class="alert-link">Did you forget your password?</b-link>
                                        </b-alert>
                                    </div>
                                    <div>
                                        <b-alert show variant="warning">
                                        <span>You don't have an account yet?</span>
                                        <b-link :to="'/register'" class="alert-link">Register a new account</b-link>
                                        </b-alert>
                                    </div>
                                </div>                          
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4"></div>
                </div>
            </div>        
        </div>
    </div>
</template>
<script lang="ts" src="./login.component.ts">
</script>

<style scoped>
    .page-header {
        height: 150px;
        width: 100%;
        background-image: linear-gradient(-296deg,#000,#58595b);
        padding-top: 35px;
        padding-left: 100px;
        color: #fff;
        font-weight: bold;
    }    
    .login-section {
        padding-left: 85px;
        position: relative;
        top: -50px;
    }
    .login-form {
        padding: 20px;
        background-color: #fff;
        border: 1px solid #efefef;
    }    
</style>
