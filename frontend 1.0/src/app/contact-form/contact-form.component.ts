import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ContactService } from '../service/ContactService';
import { ContactFormDTO } from '../model/ContactFormDTO';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {
  contactForm: FormGroup; // Define accountForm

  constructor(private fb: FormBuilder, private router: Router, private contactService:ContactService) {
    this.contactForm = this.fb.group({
      name: [''],
      accountName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.maxLength(10)]],
      jobTitle: [''],
      leadSource: ['']
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    if (this.contactForm.valid) {
      const contactFormDTO: ContactFormDTO = this.contactForm.value as ContactFormDTO;
        this.contactService.createContact(contactFormDTO).subscribe(
          response => {
            console.log(response); // Handle the response from the backend
            // this.router.navigate(['/lead']);
          },
          error => {
            console.error(error); // Handle errors
          }
        );

        console.log(this.contactForm.value);
    }
  }
}

