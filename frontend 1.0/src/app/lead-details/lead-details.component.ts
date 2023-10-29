import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LeadService } from '../service/lead.service';

@Component({
  selector: 'app-lead-details',
  templateUrl: './lead-details.component.html',
  styleUrls: ['./lead-details.component.css']
})
export class LeadDetailsComponent {
  lead: any; // This will hold the lead data
  leadId :number=0;
  editMode = false;
  newStatus :string ='';
  updatedAttributes: any = {};

  leadI = { name: '',
  companyName: '',
  email: '', phone: '', jobTitle: '',
  website: '', typeOfBusiness: '' ,status:'',Source:'',Probability:'',address:'',
  state:'',region:'',requiredQuantity:'',
  expectedRevenue:'',createdDate:'',
  products:''};

  constructor(private route: ActivatedRoute, private leadService: LeadService,private router:Router) {}


  ngOnInit() {
    const leadId = +this.route.snapshot.params['leadId']; // Convert leadId to a number

    this.leadId = leadId;
    this.leadService.getLeadById(leadId).subscribe(data => {
      this.lead = data;
    });
  }



  toggleEditMode() {
    this.editMode = !this.editMode;
  }

  saveAttribute(attribute: string, value: any) {
    this.updatedAttributes[attribute] = value;
  }

  saveAll() {

    const firstFormDTO = {

          name: this.lead.newLead.name,

          companyName: this.lead.newLead.companyName,

          email: this.lead.newLead.email, phone: this.lead.newLead.phone,

          jobTitle: this.lead.newLead.jobTitle, website: this.lead.newLead.website,

          typeOfBusiness: this.lead.newLead.typeOfBusiness,status: this.lead.newLead.status,

          source: this.lead.newLead.source,probability: this.lead.newLead.probability,

          address: this.lead.newLead.address, state : this.lead.newLead.state,region: this.lead.newLead.region,

          requiredQuantity : this.lead.newLead.requiredQuantity,
          expectedRevenue : this.lead.newLead.expectedRevenue,
          createdDate:this.lead.newLead.createdDate,
          products :this.lead.newLead.products

        }


    this.leadService.patchLead(this.leadId, firstFormDTO).subscribe(

      (updatedLead) => {

        this.lead = updatedLead;

        this.editMode = false;

        console.log('Quote updated successfully.');

      },

      (error) => {

        console.error('Error updating quote:', error);

      }

    );

  }

  callFunction() {
    //this.router.navigate(['/lead-form']);
    }

    updateLeadStatus(newStatus: string) {
      if (this.leadId) {
        this.leadService.updateLeadStatus(this.leadId, newStatus).subscribe(
          response => {
            console.log(response);

          },
          error => {
            console.error(error); // Handle error
          }
        );
      } else {
        console.error('Lead ID is not defined');
      }
    }





}
