import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ContactService } from '../service/ContactService';

@Component({
  selector: 'app-contact-details',
  templateUrl: './contact-details.component.html',
  styleUrls: ['./contact-details.component.css']
})
export class ContactDetailsComponent {
  contact: any; // This will hold the lead data

  constructor(private route: ActivatedRoute, private contactService: ContactService) {}

  ngOnInit() {
    const contactId = +this.route.snapshot.params['contactId']; // Convert leadId to a number
    console.log(contactId);

    this.contactService.getContactById(contactId).subscribe(data => {
      this.contact = data;
      console.log(this.contact);
    });

  }
}
