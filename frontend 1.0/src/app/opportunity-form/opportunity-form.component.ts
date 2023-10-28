import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { OpportunityFormDTO } from '../model/OpportunityFormDTO';
import { OpportunityService } from '../service/OpportunityService';

@Component({
  selector: 'app-opportunity-form',
  templateUrl: './opportunity-form.component.html',
  styleUrls: ['./opportunity-form.component.css']
})
export class OpportunityFormComponent implements OnInit {
  opportunityForm: FormGroup;


  constructor(private fb: FormBuilder,private opportunityService: OpportunityService,private router: Router) {
    this.opportunityForm = this.fb.group({
      requiredQuantity: [1, [Validators.min(1)]],
      expectedRevenue: [0, [Validators.min(0)]],
      probability: [0, [Validators.min(0), Validators.max(1)]],
      priority: [''],
      expectedClosingDate: [''],
      products: [''],
      status: [''],
      source: [''],
      accountName: ['']
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    if (this.opportunityForm.valid) {
      const opportunityFormDTO: OpportunityFormDTO = this.opportunityForm.value as OpportunityFormDTO;

      this.opportunityService.createOpportunity(opportunityFormDTO).subscribe(
        response => {
          console.log(response); // Handle the response from the backend
          // this.router.navigate(['/lead']);
        },
        error => {
          console.error(error); // Handle errors
        }
      );

      console.log(this.opportunityForm.value);
    }
  }


}

