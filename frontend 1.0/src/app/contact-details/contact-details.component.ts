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
  contactId :number=0;
  editMode = false;

  contactI = { name: '',
  accountName: '',
  email: '', phone: '', jobTitle: '',leadSource:''
  };


  constructor(private route: ActivatedRoute, private contactService: ContactService) {}

  ngOnInit() {
    const contactId = +this.route.snapshot.params['contactId']; // Convert leadId to a number
    console.log(contactId);

    this.contactId=contactId
    this.contactService.getContactById(contactId).subscribe(data => {
      this.contact = data;
      console.log(this.contact);
    });

}

saveAll() {

  const contactFormDTO = {

        name: this.contact.name,

        email: this.contact.email,

        phone: this.contact.phone,

        jobTitle: this.contact.jobTitle,

        accountName: this.contact.accountName,

        leadSource: this.contact.leadSource,



      }


  this.contactService.patchContact(this.contactId, contactFormDTO).subscribe(

    (updatedContact) => {

      this.contact = updatedContact;

      this.editMode = false;

      console.log('Quote updated successfully.');

    },

    (error) => {

      console.error('Error updating quote:', error);

    }

  );

}
}
