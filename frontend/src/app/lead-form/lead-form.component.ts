import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FirstFormDTO } from '../model/FirstFormDTO';
import { LeadService } from '../service/lead.service';

@Component({
  selector: 'app-lead-form',
  templateUrl: './lead-form.component.html',
  styleUrls: ['./lead-form.component.css']
})
export class LeadFormComponent implements OnInit {
  leadForm: FormGroup;


  constructor(private fb: FormBuilder,private leadService: LeadService,private router: Router,private datePipe: DatePipe) {
    this.leadForm = this.fb.group({
      name: ['', Validators.required],
      companyName: [''],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.maxLength(10)]],
      jobTitle: [''],
      address: [''],
      state: [''],
      region: [''],
      website: [''],
      typeOfBusiness: [''],
      createdDate: [''],
      requiredQuantity: [1, [Validators.min(1)]],
      expectedRevenue: [0, [Validators.min(0)]],
      probability: [0, [Validators.min(0), Validators.max(1)]],
      products: [''],
      status: [''],
      source: ['']
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    if (this.leadForm.valid) {
      const firstFormDTO: FirstFormDTO = this.leadForm.value as FirstFormDTO;

      this.leadService.createLead(firstFormDTO).subscribe(
        response => {
          console.log(response); // Handle the response from the backend
          // this.router.navigate(['/lead']);
        },
        error => {
          console.error(error); // Handle errors
        }
      );

      console.log(this.leadForm.value);
    }
  }


}
