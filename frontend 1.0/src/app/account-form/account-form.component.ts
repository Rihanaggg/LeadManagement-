import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AccountFormDTO } from '../model/AccountFormDTO';
import { AccountService } from '../service/AccountService';

@Component({
  selector: 'app-account-form',
  templateUrl: './account-form.component.html',
  styleUrls: ['./account-form.component.css']
})
export class AccountFormComponent implements OnInit {
  accountForm: FormGroup; // Define accountForm

  constructor(private fb: FormBuilder, private router: Router, private accountService:AccountService) {
    this.accountForm = this.fb.group({
      companyName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.maxLength(10)]],
      address: [''],
      state: [''],
      region: [''],
      website: [''],
      typeOfBusiness: [''],
      typeOfAccount: [''],
      active: ['']
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    if (this.accountForm.valid) {
      const accountFormDTO: AccountFormDTO = this.accountForm.value as AccountFormDTO;
        this.accountService.createAccount(accountFormDTO).subscribe(
          response => {
            console.log(response); // Handle the response from the backend
            // this.router.navigate(['/lead']);
          },
          error => {
            console.error(error); // Handle errors
          }
        );

        console.log(this.accountForm.value);
    }
  }
}
