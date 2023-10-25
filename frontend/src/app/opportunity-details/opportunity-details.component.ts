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

  constructor(private route: ActivatedRoute, private opportunityService: OpportunityService,private datePipe: DatePipe) {}

  ngOnInit() {
    const oppId = +this.route.snapshot.params['oppId']; // Convert leadId to a number
    console.log(oppId);

    this.opportunityService.getOpportunityById(oppId).subscribe(data => {
      this.opportunity = data;
      console.log(this.opportunity);
    });

  }
}
