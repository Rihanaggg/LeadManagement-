import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OpportunityService } from '../service/OpportunityService';

@Component({
  selector: 'app-opportunity',
  templateUrl: './opportunity.component.html',
  styleUrls: ['./opportunity.component.css']
})
export class OpportunityComponent implements OnInit {

  opportunities: any[] = [];
  id: number =0;
  searchQuery: string='';
  searchType: string = 'name';

  constructor(private opportunityService: OpportunityService,private router: Router) { }

  ngOnInit(): void {
    this.loadAllOpportunity();
  }

  loadAllOpportunity() {
    this.opportunityService.getAllOpportunities().subscribe(
      (data) => {
        this.opportunities = data;
        console.log(this.opportunities);

      },
      (error) => {
        console.error(error);
      }
    );
  }

  // searchLeads() {
  //   if (this.searchQuery && this.searchType) {
  //     this.opportunityService.searchOpportunitiesByStatus(this.searchType, this.searchQuery).subscribe(
  //       (data) => {
  //         this.opportunities = data;
  //       },
  //       (error) => {
  //         console.error(error);
  //       }
  //     );
  //   } else {
  //     this.loadAllOpportunity(); // If search fields are empty, load all leads
  //   }
  // }

  searchOpportunities() {
    const status = 'qualified'; // Replace with the status you want to search
    this.opportunityService.searchOpportunitiesByStatus(status)
      .subscribe(data => {
        // Handle the returned data here
        console.log(data);
      });
  }

  callFunction() {
    this.router.navigate(['/opportunity-form']);
    }

    openOpportunity(id: number) {
      console.log(id);
      this.router.navigate(['/opportunity-detail', id]);
    }

    deleteOpportunity(id: number) {
      console.log(id);
      this.opportunityService.deleteOpportunityById(id).subscribe(
        () => {
        }

      );
    }


}
