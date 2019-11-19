<template>
    <div class="home-container">
        <div class="page-header" v-if="currentView === 'accounts'">
            <h3 class="dt-inline-block">Accounts Overview</h3>
            <small>As of {{new Date().toLocaleDateString('default', { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' })}}</small>
        </div>
       <div class="accounts-section" v-if="currentView === 'accounts'">
           <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="accounts-info">
                            <div class="accounts-list">
                                <div class="account-record" v-on:click="openTransactions(account.id)" v-bind:key="account.id" v-for="account in accounts">
                                    <div class="row align-items-center">
                                        <div class="col-md-1">
                                            <font-awesome-icon v-show="account.type === 'Personal Account'" icon="credit-card" style="font-size: 45px; color: #D4BCA4;"></font-awesome-icon>
                                            <!-- <img  width="40px" src="../../../content/images/credit-card.png" /> -->
                                            <font-awesome-icon v-show="account.type === 'Direct Quarterly Savings'" icon="piggy-bank" style="font-size: 45px; color: #89c7c9"></font-awesome-icon>                                            
                                            <!-- <img v-show="account.type === 'Direct Quarterly Savings'" width="40px" src="../../../content/images/piggy-bank_grenn.png" /> -->
                                        </div>
                                        <div class="col-md-4">
                                            <div>{{account.name}}</div>
                                            <small>{{account.type}}</small>
                                        </div>
                                        <div class="col-md-4">
                                            <span>{{account.number}}</span>
                                        </div>
                                        <div class="col-md-2">
                                            <span> {{account.balance | toCurrency}}</span>
                                        </div>
                                        <div class="col-md-1 d-none d-sm-block">
                                            <font-awesome-icon icon="chevron-right"></font-awesome-icon>
                                        </div>
                                    </div>                                    
                                </div>
                                <div class="ad-banner">
                                    <div class="row align-items-center">
                                        <div class="col-md-2 text-center">
                                            <font-awesome-icon icon="credit-card" style="font-size: 45px; color: #db7859"></font-awesome-icon>
                                        </div>
                                        <div class="col-md-10">
                                            <h4>Add accounts with other banks to your account overview</h4>
                                            <p>Also have accounts with another bank ? You can give ABC, Xyz
                                                 permission to add these accounts to your Me Bank account overview, so you can keep track
                                                  of all your acounts at all times. </p>
                                            <div class="float-right">
                                                <button class="btn btn-light">Hide</button>  
                                                <button class="btn btn-ib">Add other bank</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <p>Questions or in need of help, You can reach us 24/7.</p>
                        <a href>Contact</a>
                       <div class="ads-column d-none d-sm-block">
                           <h4 class="header">For Daily Banking Matters</h4>
                           <div class="block one"> 
                               <!-- <img width="40px" src="../../../content/images/u141.svg" /> -->
                               <span><font-awesome-icon style="font-size: 40px; margin-right: 12px; color: #509A16" icon="phone-volume"></font-awesome-icon></span>                               
                               <h4>Call Now 0900 - 00 24</h4>
                            </div>
                            <div class="block two">
                                <div class="part1">
                                    <h4> Preffered Banking</h4>
                                    <button class="btn btn-ib col-md-12">Make an appointment (in Dutch)</button>
                                </div>
                                <div class="part2">
                                    <ul class="ad-menu">
                                        <li>your personal adviser</li>
                                        <li>interactive clinics</li>
                                        <li>access to Aspire Lounges at Schiphol Airport</li>
                                        <li>tips and information on investments and pensions</li>
                                    </ul>
                                </div>
                            </div>
                       </div>
                    </div>                    
                </div>
            </div>
       </div>
       <div class="transactions-container" v-if="currentView === 'transactions'">
           <div class="page-header">
               <div class="container-fluid">
                    <div class="row align-items-center">
                        <div class="col-md-6">
                            <h3>My Account Summary</h3>
                            <small>As of {{new Date().toLocaleDateString('default', { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' })}}</small>
                            <div style="margin-top: 15px">
                                <a class="bread-crumbs" href v-on:click.prevent="openAccountsList()">Accounts</a> > <a class="bread-crumbs" href>Summary</a>
                            </div>
                        </div>
                        <div class="col-md-6 text-right d-none d-sm-block">
                            <input typ="text" class="form-control search-box" name="search" placeholder="Name, Amount, Account number" />
                            <button class="btn btn-ib">Search</button>
                        </div>
                    </div>
                </div>
               
           </div>
           <div class="container-fluid">
               <div class="row">
                   
               </div>
               <div class="row">
                   <div class="col-md-3 vr">
                       <div class="accounts-detail-column">
                           <div class="accounts-list-section">
                               <h4 class="header">Account details for</h4>
                               <select class="d-xs-block d-sm-none form-control" name="account" v-on:change="showTransactions($event.target.value)">
                                   <option v-bind:key="account.id" v-for="account in accounts" v-bind:value="account.id"> {{account.name}} </option>
                               </select>
                               <div class="account-card d-none d-sm-block" v-bind:class="{'active': account.id === currentSelectedAccount}" v-on:click="showTransactions(account.id)" v-bind:key="account.id" v-for="account in accounts">
                                    <div class="row align-items-center">
                                        <div class="col-md-4">
                                            <h4>{{account.name}}</h4>
                                            <small>{{account.number}}</small>
                                        </div>
                                        <div class="col-md-6 text-right">
                                            <h4>{{account.balance | toCurrency}}</h4>
                                            <small>{{account.type}}</small>
                                        </div>
                                        <div class="col-md-2">
                                            <font-awesome-icon icon="chevron-right"></font-awesome-icon>
                                        </div>
                                    </div>
                               </div>
                           </div>
                           <div class="transactions-filters-section">
                                <h4>Transactions Filter</h4>
                                <select class="d-xs-block d-sm-none form-control" name="filter">
                                   <option value="all"> All </option>
                                   <option value="all"> Pending </option>
                                   <option value="all"> Rejected </option>
                                   <option value="all"> Scheduled and standing </option>
                                   <option value="all"> Direct debits </option>
                               </select>
                                <div class="form-group d-none d-sm-block">
                                    <input type="checkbox" id="txfilter1" name="txfilter" />
                                    <label for="txfilter1">Pending</label>
                                </div>
                                <div class="form-group d-none d-sm-block">
                                    <input type="checkbox" id="txfilter2" name="txfilter" />
                                    <label for="txfilter2">Rejected</label>
                                </div>
                                <div class="form-group d-none d-sm-block">
                                    <input type="checkbox" id="txfilter3" name="txfilter" />
                                    <label for="txfilter3">Scheduled and standing</label>
                                </div>
                                <div class="form-group d-none d-sm-block">
                                    <input type="checkbox" id="txfilter4" name="txfilter" />
                                    <label for="txfilter4">Direct debits</label>
                                </div>
                           </div>
                           <button class="btn btn-ib col-md-12 d-none d-sm-block">New Transfer</button>
                       </div>            
                   </div>
                   <div class="col-md-6 vr">
                       <div class="d-xs-block d-sm-none mt-20"></div>
                       <div class="transactions-detail-column">
                           <div class="row">
                               <div class="col-md-6">
                                   <h4 class="header">Transactions <small>between 01/11/2019 to 12/11/2019</small> <span><font-awesome-icon icon="calendar-alt"></font-awesome-icon></span></h4>
                                </div>
                                <div class="col-md-6 text-right">
                                    <h4 class="header">
                                        Account settings 
                                        <span><font-awesome-icon icon="cog"></font-awesome-icon></span>
                                    </h4>                                    
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="transactions-list">
                                        <div v-if="!transactionsLoaded" class="text-center"><h4>Loading transactions ...</h4></div>
                                        <div class="transaction-group" v-bind:key="key" v-for="(trnxs, key) in transactions">                                                
                                            <span class="date">{{key}}</span>
                                            <div class="card">
                                                <table>
                                                    <tr class="transaction" v-bind:key="trnx.id" v-for="trnx in trnxs">
                                                        <td><img width="20px" src="../../../content/images/pos.png" /></td> 
                                                        <td>{{trnx.description}}</td> 
                                                        <td style="text-align: right">
                                                            <b>{{ getAmount(trnx)  | toCurrency }}</b>
                                                        </td> 
                                                    </tr>
                                                </table>                                                    
                                            </div>                                                
                                        </div>
                                    </div>
                                </div>
                            </div>
                       </div>
                   </div>
                   <div class="col-md-12 d-xs-block d-sm-none text-center">
                       <button class="btn btn-ib">New Transfer</button>
                    </div>            
                   <div class="col-md-3">
                       <div class="ads-column">
                           <h4 class="header">For Daily Banking Matters</h4>
                           <div class="block one"> 
                               <span><font-awesome-icon style="font-size: 40px; margin-right: 12px; color: #509A16" icon="phone-volume"></font-awesome-icon></span>
                               <!-- <img width="40px" src="../../../content/images/u141.svg" />                               -->
                               <h4>Call Now 0900 - 00 24</h4>
                            </div>
                            <div class="block two">
                                <div class="part1">
                                    <h4> Preffered Banking</h4>
                                    <button class="btn btn-ib col-md-12">Make an appointment (in Dutch)</button>
                                </div>
                                <div class="part2">
                                    <ul class="ad-menu">
                                        <li>your personal adviser</li>
                                        <li>interactive clinics</li>
                                        <li>access to Aspire Lounges at Schiphol Airport</li>
                                        <li>tips and information on investments and pensions</li>
                                    </ul>
                                </div>
                            </div>
                       </div>
                   </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./home.component.ts">
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
.accounts-info {
  margin-left: 65px;
  position: relative;
  top: -50px;
  padding: 0 20px;
}
.accounts-list {
  border-radius: 3px;
}
.account-record {
  background-color: #fff;
  padding: 10px 20px;
  border-bottom: 1px solid #efefef;
  cursor: pointer;
  border-left: 1px solid #efefef;
  border-right: 1px solid #efefef;
}
.account-record:first-child {
  border-top: 1px solid #efefef;
}

.account-record:last-child {
  border-bottom: 1px solid #efefef;
}

.ad-banner {
  margin-top: 20px;
  border: 1px dashed #efefef;
  padding: 20px;
  background: #F9F9F9;
}
.ad-banner h4 {
  font-size: 20px;
  font-weight: 600;
}

.transactions-container {
  /* margin-top: 10px;   */
}
.transactions-container .header {
  font-size: 18px;
}
.transactions-container .header > small{
  font-size: 10px;
}
.transactions-container .page-header {
    min-height: 100px;
    height: inherit;
    width: 100%;
    background-image: linear-gradient(-296deg,#000,#58595b);
    color: #fff;
    padding: 20px;
    margin-bottom: 10px;
}
.transactions-container .page-header h3{
    display: inline;
    font-size: 26px;
}
.transactions-container .page-header .search-box {
    width: 300px;
    display: inline-block;
}
.transactions-container .col-md-3.vr,
.transactions-container .col-md-6.vr {
  border-right: 1px solid #efefef;
}
.transactions-section {
  background-color: #f6f4f7;
}
.transactions-section .block {
  background-color: #fff;
  padding: 15px;
  margin-bottom: 15px;
}
.transactions-section .header {
  text-align: center;
  border: 1px solid #efefef;
  font-weight: bold;
  padding: 5px 10px;
}
.transactions-section .header h4 {
  color: #58595b;
  font-weight: bold;
}
.transactions-section .body {
  padding: 20px;
  border: 1px solid #efefef;
  border-top: none;
}
.transactions-section .body a {
  color: #58595b;
  font-size: 14px;
  display: block;
}
.transactions-section .body .heading {
  font-size: 16px;
}
.transaction-group {
  margin-bottom: 20px;
}
.transaction-group .date {
  color: #58595b;
  font-weight: 600;
}
.transaction-group .card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
}
.transaction-group .card .transaction {
  border-bottom: 1px solid #efefef;
}
.transaction-group .card .transaction:last-child {
  border-bottom: none;
}
.transaction-group .card .transaction > td {
  padding: 5px;
}

.accounts-detail-column > .accounts-list-section {
  margin-bottom: 20px;
}

.accounts-detail-column > .accounts-list-section > h4 {
  font-weight: 600;
}

.accounts-detail-column > .accounts-list-section > .account-card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  padding: 5px;
  border-left: 5px solid #fff;
  margin-bottom: 10px;
  cursor: pointer;
}

.accounts-detail-column > .accounts-list-section > .account-card.active {
  border-left: 5px solid #58595b;
}

.accounts-detail-column > .accounts-list-section > .account-card h4 {
  font-size: 14px;
  font-weight: bold;
  margin-bottom: 0px;
}

.accounts-detail-column > .accounts-list-section > .account-card small {
  font-size: 10px;
}

.transactions-filters-section .form-group {
  margin-bottom: 0px;
}

.transactions-filters-section > h4 {
  font-weight: 600;
}

.transactions-filters-section label {
  color: #58595b;
}

.transactions-detail-column .header {
  font-weight: 600;
}

.ads-column .header {
  font-weight: 600;
}

.ads-column .block {
  padding: 20px;
  margin-bottom: 20px;
}

.ads-column .block.one {
    text-align: center;
    background: #fff;
    border: 1px solid #000;
}

.ads-column .block.one h4 {
  display: inline;
  font-size: 16px;
  font-weight: 600;
}

.ads-column .block.two {
    padding: 0px;
}
.ads-column .block.two .part1 {
    color: #fff;
    text-align: center;
    background: #58595b;
    padding: 20px;
}

.ads-column .block.two .part1 h4 {
  font-weight: 600;
  font-size: 24px;
}

.ads-column .block.two .part2 {
  padding: 20px;
  border: 1px solid #efefef;
}

.ads-column ul.ad-menu {
  list-style: none;
  padding: 0px;
}

.ads-column ul.ad-menu li:before {
  content: '✓';
  color: #000;
  padding-right: 10px;
}

.bread-crumbs {
  color: #fff;
}

.mt-20 {
    margin-top: 20px;
}
</style>
