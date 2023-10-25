import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContactService } from '../service/ContactService';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  contacts: any[] = [];
  contactId: number = 0;
  searchQuery: string = '';
  searchType: string = 'name';

  constructor(private contactService: ContactService, private router:Router) { }

  ngOnInit(): void {
    this.loadAllContacts();
  }

  loadAllContacts() {
    this.contactService.getAllContacts().subscribe(
      (data) => {
        this.contacts = data;
      },
      (error) => {
        console.error(error);
      }
    );
  }

  searchContacts() {
    if (this.searchQuery && this.searchType) {
      this.contactService.searchContacts(this.searchType, this.searchQuery).subscribe(
        (data) => {
          this.contacts = data;
        },
        (error) => {
          console.error(error);
        }
      );
    } else {
      this.loadAllContacts();
    }
  }



  callFunction() {
    this.router.navigate(['/contact-form']);
    }

    openLead(contactId: number) {
      console.log(contactId);
      this.router.navigate(['/contact-detail', contactId]);
    }

    deleteContact(contactId: number) {
      this.contactService.deleteContactById(contactId).subscribe(
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

