import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FirstFormDTO } from '../model/FirstFormDTO';
import { LeadService } from '../service/lead.service';

@Component({
  selector: 'app-edit-form',
  templateUrl: './edit-form.component.html',
  styleUrls: ['./edit-form.component.css']
})
export class EditFormComponent implements OnInit {
//   leadForm?: FormGroup;
//   leadData: any; // Assuming you have lead data in this variable
//   editMode = false;
//   isEditing = false;

//   constructor(private fb: FormBuilder,private leadService: LeadService,private router: Router) {
//     this.leadForm = this.fb.group({
//       name: ['', Validators.required],
//       companyName: [''],
//       email: ['', [Validators.required, Validators.email]],
//       phone: ['', [Validators.maxLength(10)]],
//       jobTitle: [''],
//       address: [''],
//       state: [''],
//       region: [''],
//       website: [''],
//       typeOfBusiness: [''],
//       required_quantity: [1, [Validators.min(1)]],
//       expectedRevenue: [0, [Validators.min(0)]],
//       probability: [0, [Validators.min(0), Validators.max(1)]],
//       products: [''],
//       status: [''],
//       source: ['']
//     });
//   }

  ngOnInit() {}

    // this.leadForm.patchValue({
    //   name: lead.newLead.name,
    //   companyName: lead.newLead.companyName,
    //   email: lead.newLead.email,
    //   // ... repeat for other fields
    // });

//     this.leadForm = this.fb.group({
//       name: [this.leadData.name, Validators.required],
//       companyName: [this.leadData.companyName],
//       email: [this.leadData.email, [Validators.required, Validators.email]],
//       phone: [this.leadData.phone, [Validators.maxLength(10)]],
//       jobTitle: [this.leadData.jobTitle],
//       address: [this.leadData.address],
//       state: [this.leadData.state],
//       region: [this.leadData.region],
//       website: [this.leadData.website],
//       typeOfBusiness: [this.leadData.typeOfBusiness],
//       required_quantity: [this.leadData.required_quantity, [Validators.min(1)]],
//       expectedRevenue: [this.leadData.expectedRevenue, [Validators.min(0)]],
//       probability: [this.leadData.probability, [Validators.min(0), Validators.max(1)]],
//       products: [this.leadData.products],
//       status: [this.leadData.status],
//       source: [this.leadData.source]
//       // Add other form controls here
//     });
//   }

//   toggleEditMode() {
//     this.editMode = !this.editMode;
//   }

//   onSubmit() {
//     // if (this.leadForm.valid) {
//     //   const firstFormDTO: FirstFormDTO = this.leadForm.value as FirstFormDTO;

//     //   this.leadService.createLead(firstFormDTO).subscribe(
//     //     response => {
//     //       console.log(response); // Handle the response from the backend
//     //       this.router.navigate(['/lead']);
//     //     },
//     //     error => {
//     //       console.error(error); // Handle errors
//     //     }
//     //   );

//     //   console.log(this.leadForm.value);
//     // }
//   }



// editField(fieldName: string) {
//   if (this.isEditing) {
//     this.isEditing = false;
//   } else {
//     this.isEditing = true;
//     this.leadForm.get(fieldName).enable(); // Enable the field for editing
//   }
// }


}

