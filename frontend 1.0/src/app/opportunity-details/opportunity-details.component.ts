import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OpportunityService } from '../service/OpportunityService';

@Component({
  selector: 'app-opportunity-details',
  templateUrl: './opportunity-details.component.html',
  styleUrls: ['./opportunity-details.component.css']
})
export class OpportunityDetailsComponent {
  opportunity: any; // This will hold the lead data
  oppId :number=0;
  editMode = false;

  opportunityI = {
  accountName: '',source:'',
  requiredQuantity:'',
  expectedRevenue:'',expectedClosingDate:'',products:'',status:'',probability:'',
};

  constructor(private route: ActivatedRoute, private opportunityService: OpportunityService,private datePipe: DatePipe) {}

  ngOnInit() {
    const oppId = +this.route.snapshot.params['oppId']; // Convert leadId to a number
    console.log(oppId);

    this.oppId=oppId;
    this.opportunityService.getOpportunityById(oppId).subscribe(data => {
      this.opportunity = data;
      console.log(this.opportunity);
    });

  }

  saveAll() {

    const OpportunityFormDTO = {

        accountName: this.opportunity.accountName,
        status: this.opportunity.status,
        probability: this.opportunity.probability,
        source : this.opportunity.source,
        requiredQuantity : this.opportunity.requiredQuantity,
        expectedRevenue : this.opportunity.expectedRevenue,
        expectedClosingDate:this.opportunity.expectedClosingDate,
        products :this.opportunity.products

        }


    this.opportunityService.patchOpportunity(this.oppId, OpportunityFormDTO).subscribe(

      (updatedOpportunity) => {

        this.opportunity = updatedOpportunity;

        this.editMode = false;

        console.log('Quote updated successfully.');

      },

      (error) => {

        console.error('Error updating quote:', error);

      }

    );

  }
}
