<template>
    <div class="ib-navbar">
        <span class="logo-img"></span>
        <div class="login-user d-none d-sm-block" v-if="authenticated">
            <p class="name">Welcome, <b>Jhon PD</b></p>
            <img class="loggedin-user-img" src="../../../content/images/user-jhon.jpeg" />            
        </div>
        <b-navbar toggleable="md" type="light" class="bg-ib" v-if="showNavbar">
        <div class="jh-logo-container float-left">
            <b-navbar-toggle right class="jh-navbar-toggler d-lg-none float-right" href="javascript:void(0);"  data-toggle="collapse" target="header-tabs" aria-expanded="false" aria-label="Toggle navigation">
                <font-awesome-icon icon="bars" />
            </b-navbar-toggle>
            <b-navbar-brand class="logo float-left" b-link to="/">
                <img class="caret-down" src="../../../content/images/caret-down.svg" />
            </b-navbar-brand>
        </div>
        <b-collapse is-nav id="header-tabs">
            <b-navbar-nav class="" v-if="authenticated">
                <b-nav-item to="/home"  active-class="active" exact>
                    <span>
                        <font-awesome-icon icon="money-check-alt" />
                        <span>Accounts</span>
                    </span>
                </b-nav-item>
                <b-nav-item to="/"  active-class="active" exact>
                    <span>
                        <font-awesome-icon icon="people-carry" />
                        <span>Self service</span>
                    </span>
                </b-nav-item>
                <b-nav-item to="/"  active-class="active" exact>
                    <span>
                        <font-awesome-icon icon="envelope" />
                        <span>Bankmail</span>
                    </span>
                </b-nav-item>
                <b-nav-item to="/"  active-class="active" exact>
                    <span>
                        <font-awesome-icon icon="tasks" />
                        <span>Tasklist</span>
                    </span>
                </b-nav-item>
                <b-nav-item-dropdown
                    id="entity-menu"
                    v-if="hasAnyAuthority('ROLE_ADMIN')"
                    :class="{'router-link-active': subIsActive('/entity')}"
                    active-class="active" class="pointer">
                    <span slot="button-content" class="navbar-dropdown-menu">
                        <font-awesome-icon icon="th-list" />
                        <span>Entities</span>
                    </span>
                    <!-- jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here -->
                </b-nav-item-dropdown>
                <b-nav-item-dropdown
                    id="admin-menu"
                    v-if="hasAnyAuthority('ROLE_ADMIN')"
                    :class="{'router-link-active': subIsActive('/admin')}"
                    active-class="active"
                    class="pointer">
                    <span slot="button-content" class="navbar-dropdown-menu">
                        <font-awesome-icon icon="user-plus" />
                        <span>Administration</span>
                    </span>
                    <b-dropdown-item to="/admin/user-management">
                        <font-awesome-icon icon="user" />
                        <span>User management</span>
                    </b-dropdown-item>
                    <b-dropdown-item  to="/admin/jhi-metrics">
                        <font-awesome-icon icon="tachometer-alt" />
                        <span>Metrics</span>
                    </b-dropdown-item>
                    <b-dropdown-item to="/admin/jhi-health">
                        <font-awesome-icon icon="heart" />
                        <span>Health</span>
                    </b-dropdown-item>
                    <b-dropdown-item  to="/admin/jhi-configuration">
                        <font-awesome-icon icon="list" />
                        <span>Configuration</span>
                    </b-dropdown-item>
                    <b-dropdown-item  to="/admin/audits">
                        <font-awesome-icon icon="bell" />
                        <span>Audits</span>
                    </b-dropdown-item>
                    <b-dropdown-item  to="/admin/logs">
                        <font-awesome-icon icon="tasks" />
                        <span>Logs</span>
                    </b-dropdown-item>
                    <b-dropdown-item v-if="swaggerEnabled"  to="/admin/docs">
                        <font-awesome-icon icon="book" />
                        <span>API</span>
                    </b-dropdown-item>
                    <b-dropdown-item v-if="!inProduction"  href='./h2-console' target="_tab">
                        <font-awesome-icon icon="hdd" />
                        <span>Database</span>
                    </b-dropdown-item>
                </b-nav-item-dropdown>
                <b-nav-item-dropdown
                    right
                    href="javascript:void(0);"
                    id="account-menu"
                    :class="{'router-link-active': subIsActive('/account')}"
                    active-class="active"
                    class="pointer">
                    <span slot="button-content" class="navbar-dropdown-menu">
                        <font-awesome-icon icon="user" />
                        <span>
                            Settings
                        </span>
                    </span>
                    <b-dropdown-item to="/account/settings" tag="b-dropdown-item" v-if="authenticated">
                        <font-awesome-icon icon="wrench" />
                        <span>Settings</span>
                    </b-dropdown-item>
                    <b-dropdown-item to="/account/password" tag="b-dropdown-item" v-if="authenticated">
                        <font-awesome-icon icon="lock" />
                        <span>Password</span>
                    </b-dropdown-item>
                    <b-dropdown-item to="/account/sessions" tag="b-dropdown-item" v-if="authenticated">
                        <font-awesome-icon icon="cloud" />
                        <span>Sessions</span>
                    </b-dropdown-item>
                    <b-dropdown-item v-if="authenticated"  v-on:click="logout()" id="logout">
                        <font-awesome-icon icon="sign-out-alt" />
                        <span>Sign out</span>
                    </b-dropdown-item>
                    <b-dropdown-item v-if="!authenticated"  v-on:click="openLogin()" id="login">
                        <font-awesome-icon icon="sign-in-alt" />
                        <span>Sign in</span>
                    </b-dropdown-item>
                    <b-dropdown-item to="/register" tag="b-dropdown-item" id="register" v-if="!authenticated">
                        <font-awesome-icon icon="user-plus" />
                        <span>Register</span>
                    </b-dropdown-item>
                </b-nav-item-dropdown>
            </b-navbar-nav>
        </b-collapse>
    </b-navbar>
    </div>        
</template>

<script lang="ts" src="./jhi-navbar.component.ts">
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
/* ==========================================================================
    Navbar
    ========================================================================== */
.navbar-version {
  font-size: 10px;
}

@media screen and (min-width: 768px) {
  .jh-navbar-toggler {
    display: none;
  }
}

@media screen and (min-width: 768px) and (max-width: 1150px) {
  span span {
    display: none;
  }
}

@media screen and (max-width: 767px) {
  .jh-logo-container {
    width: 100%;
  }
}

.navbar-title {
  display: inline-block;
  vertical-align: middle;
}
/* waiting for bootstrap fix bug on nav-item-dropdown a:active
https://github.com/bootstrap-vue/bootstrap-vue/issues/2219
*/
nav li.router-link-active .navbar-dropdown-menu {
  cursor: pointer;
}

/* ==========================================================================
    Logo styles
    ========================================================================== */

.logo-img {
  height: 45px;
  display: inline-block;
  margin: 20px 0 0 45px;
  width: 132px;
}

.logo-img {
  background: url('../../../content/images/logo-full.png') no-repeat center center;
  background-size: contain;
}

.bg-primary {
  background-image: linear-gradient(-296deg,#000,#58595b);
}

.caret-down {
    position: relative;
    top: -22px;
    left: 95px;
}

.navbar {
  padding: 0px;
}

.navbar-dark .navbar-nav .nav-link, .navbar-dark .navbar-nav .dropdown-toggle  {
    color: grey;
}

.bg-ib {
    background-color: #F1F5F8 !important;
}

.ml-150 {
    margin-left: 150px;
}
.login-user {
    float: right;
    margin-top: 22px;
}
.login-user img.loggedin-user-img {
    width: 40px;
    border-radius: 50%;
}
.login-user p.name {
    display: inline;
}
</style>
