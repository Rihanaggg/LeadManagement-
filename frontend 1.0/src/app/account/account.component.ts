import { Component, OnInit } from '@angular/core';
import { AccountService } from '../service/AccountService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  accounts: any[] = [];
  accountId: number = 0;
  searchQuery: string = '';
  searchType: string = 'companyName';

  constructor(private accountService: AccountService, private router:Router) { }

  ngOnInit(): void {
    this.loadAllAccounts();
  }

  loadAllAccounts() {
    this.accountService.getAllAccounts().subscribe(
      (data) => {
        this.accounts = data;
      },
      (error) => {
        console.error(error);
      }
    );
  }

  searchAccounts() {
    if (this.searchQuery && this.searchType) {
      this.accountService.searchAccounts(this.searchType, this.searchQuery).subscribe(
        (data) => {
          this.accounts = data;
        },
        (error) => {
          console.error(error);
        }
      );
    } else {
      this.loadAllAccounts();
    }
  }



  callFunction() {
    this.router.navigate(['/account-form']);
    }

    openLead(accountId: number) {
      console.log(accountId);
      this.router.navigate(['/account-detail', accountId]);
    }

    deleteAccount(accountId: number) {
      this.accountService.deleteAccountById(accountId).subscribe(
        () => {
        }

      );
    }
  // createAccount() {

  //   this.accountService.createAccount(accountForm).subscribe(
  //     (response) => {
  //       console.log(response);
  //       // Reload the accounts after creating a new one
  //       this.loadAllAccounts();
  //     },
  //     (error) => {
  //       console.error(error);
  //     }
  //   );
  // }

  // updateAccount(accountId: number) {
  //   const updatedForm = {
  //     companyName: 'Updated Company Name',
  //     address: 'Updated Address',
  //     state: 'Updated State',
  //     // Add other properties as needed
  //   };

  //   this.accountService.updateAccount(accountId, updatedForm).subscribe(
  //     (response) => {
  //       console.log(response);
  //       // Reload the accounts after updating
  //       this.loadAllAccounts();
  //     },
  //     (error) => {
  //       console.error(error);
  //     }
  //   );
  // }

  // updateAccountAttributes(accountId: number) {
  //   const updatedAttributes = {
  //     companyName: 'Updated Company Name',
  //     // Add other attributes as needed
  //   };

  //   this.accountService.updateAccountAttributes(accountId, updatedAttributes).subscribe(
  //     (response) => {
  //       console.log(response);
  //       // Reload the accounts after updating
  //       this.loadAllAccounts();
  //     },
  //     (error) => {
  //       console.error(error);
  //     }
  //   );
  // }

  // deleteAccount(accountId: number) {
  //   this.accountService.deleteAccountById(accountId).subscribe(
  //     () => {
  //       // Reload the accounts after deletion
  //       this.loadAllAccounts();
  //     },
  //     (error) => {
  //       console.error(error);
  //     }
  //   );
  // }


}
