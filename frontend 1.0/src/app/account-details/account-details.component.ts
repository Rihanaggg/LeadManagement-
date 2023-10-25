import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AccountService } from '../service/AccountService';

@Component({
  selector: 'app-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.css']
})
export class AccountDetailsComponent {
  account: any; // This will hold the lead data
  accountId :number=0;
  editMode = false;
  constructor(private route: ActivatedRoute, private accountService: AccountService) {}

  leadI = {
  companyName: '',
  email: '', phone: '',
  website: '', typeOfBusiness: '' ,typeOfAccount:'',active:'',address:'',
  state:'',region:''
};

  ngOnInit() {
    const accountId = +this.route.snapshot.params['accountId']; // Convert leadId to a number
    console.log(accountId);

    this.accountId = accountId;
    this.accountService.getAccountById(accountId).subscribe(data => {
      this.account = data;
      console.log(this.account);
    });

  }


  saveAll() {

    const accountFormDTO = {

          companyName: this.account.companyName,

          email: this.account.email,

          phone: this.account.phone,

          website: this.account.website,

          typeOfBusiness: this.account.typeOfBusiness,

          typeOfAccount: this.account.typeOfAccount,

          active: this.account.active,

          address: this.account.address, state : this.account.state,

          region: this.account.region,

        }


    this.accountService.patchAccount(this.accountId, accountFormDTO).subscribe(

      (updatedAccount) => {

        this.account = updatedAccount;

        this.editMode = false;
        console.log(this.account);


        console.log('Quote updated successfully.');

      },

      (error) => {

        console.error('Error updating quote:', error);

      }

    );

  }
}
