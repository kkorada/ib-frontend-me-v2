import Vue from 'vue';
import axios, { AxiosPromise } from 'axios';
export default class BankingService {
  public getCustomerByLogin(login: string): AxiosPromise<any> {
    return axios.get('/api/customers/login/' + login);
  }

  public getAccountsByCustomerId(customerId: number): AxiosPromise<any> {
    return axios.get('/api/accounts/customer/' + customerId);
  }

  public getTrnxsByAccountId(accountId: number): AxiosPromise<any> {
    return axios.get('/api/transactions/account/' + accountId);
  }
}
