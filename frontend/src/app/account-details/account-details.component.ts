import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LeadService } from '../service/lead.service';
import { AccountService } from '../service/AccountService';

@Component({
  selector: 'app-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.css']
})
export class AccountDetailsComponent {
  account: any; // This will hold the lead data

  constructor(private route: ActivatedRoute, private accountService: AccountService) {}

  ngOnInit() {
    const accountId = +this.route.snapshot.params['accountId']; // Convert leadId to a number
    console.log(accountId);

    this.accountService.getAccountById(accountId).subscribe(data => {
      this.account = data;
      console.log(this.account);
    });

  }
}
