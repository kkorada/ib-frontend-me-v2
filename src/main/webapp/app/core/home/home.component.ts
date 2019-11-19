import Component from 'vue-class-component';
import { Inject, Vue } from 'vue-property-decorator';
import LoginService from '@/account/login.service';
import BankingService from '@/core/services/core.service';
import AccountService from '@/account/account.service';

@Component({
  filters: {
    toCurrency(value: any) {
      if (typeof value !== 'number') {
        return value;
      }
      const formatter = new Intl.NumberFormat('de-DE', {
        style: 'currency',
        currency: 'EUR',
        minimumFractionDigits: 0
      });
      return formatter.format(value);
    }
  }
})
export default class Home extends Vue {
  @Inject('loginService')
  private loginService: () => LoginService;

  @Inject('bankingService')
  private bankingService: () => BankingService;

  @Inject('accountService')
  private accountService: () => AccountService;

  public currentView = 'accounts';

  public msSelected = null;
  public showOptions = false;

  private customer: any;
  public accounts: any[] = [];

  public currentSelectedAccount: number = null;

  public transactions: any = {};
  // {
  //   '07-11-2019': [
  //     {
  //       id: 123213,
  //       type: 'debit',
  //       amount: 112.09,
  //       description: "ABC Foodcenter, PA897689"
  //     },
  //     {
  //       id: 546745,
  //       type: 'debit',
  //       amount: 17.09,
  //       description: "ABC Foodcenter, PA897689"
  //     },
  //   ],
  //   '08-11-2019': [
  //     {
  //       id: 78967867,
  //       type: 'debit',
  //       amount: 92.09,
  //       description: "ABC Hotels, TA89asd9"
  //     },
  //     {
  //       id: 234324,
  //       type: 'debit',
  //       amount: 270.09,
  //       description: "ABC Salon, T123123"
  //     },
  //   ]
  // };

  mounted() {
    const login = this.$store.getters.account.login;
    this.bankingService()
      .getCustomerByLogin(login)
      .then(res => {
        this.customer = res.data;
        this.bankingService()
          .getAccountsByCustomerId(this.customer.id)
          .then(res1 => {
            console.log(res1.data);
            this.accounts = res1.data;
          });
      });
  }

  public openLogin(): void {
    this.loginService().openLogin((<any>this).$root);
  }

  public get authenticated(): boolean {
    return this.$store.getters.authenticated;
  }

  public get username(): string {
    return this.$store.getters.account ? this.$store.getters.account.login : '';
  }

  public get transactionsLoaded(): boolean {
    return Object.keys(this.transactions).length > 0;
  }

  public openTransactions(accountNumber) {
    this.transactions = {};
    this.currentSelectedAccount = accountNumber;
    console.log(accountNumber);
    this.currentView = 'transactions';
    this.bankingService()
      .getTrnxsByAccountId(accountNumber)
      .then(res => {
        this.transactions = this.formatTransactions(res.data);
      });
  }

  public showTransactions(accountNumber) {
    this.currentSelectedAccount = accountNumber;
    console.log(accountNumber);
    this.bankingService()
      .getTrnxsByAccountId(accountNumber)
      .then(res => {
        this.transactions = this.formatTransactions(res.data);
      });
  }

  public openAccountsList() {
    this.currentView = 'accounts';
  }

  public getAmount(trnx) {
    if (trnx.type === 'debit' && trnx.amount !== 0) {
      return trnx.amount * -1 || 0;
    } else {
      return trnx.amount;
    }
  }

  public msSelectOption(option) {
    console.log(option);
    this.toggleOptions();
    this.msSelected = option;
  }

  public toggleOptions() {
    this.showOptions = !this.showOptions;
  }

  private formatTransactions(transactions) {
    const formattedTrxns = {};

    transactions.reverse().forEach(trnx => {
      if (formattedTrxns[trnx.dateOfTransaction] === undefined) {
        formattedTrxns[trnx.dateOfTransaction] = [];
      }
      formattedTrxns[trnx.dateOfTransaction].push(trnx);
    });
    return formattedTrxns;
  }
}
