import Vue from 'vue';
import axios, { AxiosPromise } from 'axios';
import router from '../router';

export default class LoginService {
  public openLogin(instance: Vue): void {
    router.push('/login');
  }

  public logout(): AxiosPromise<any> {
    return axios.post('api/logout');
  }

  // public logout1(): any {
  //   axios.post('api/logout').then(() => {
  //     router.push('/login');
  //   });
  // }
}
