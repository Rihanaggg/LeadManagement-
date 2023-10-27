import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LeadService } from '../service/lead.service';


@Component({
  selector: 'app-lead',
  templateUrl: './lead.component.html',
  styleUrls: ['./lead.component.css']
})
export class LeadComponent implements OnInit {

  leads: any[] = [];
  leadId: number =0;
  searchQuery: string='';
  searchType: string = 'name';

  constructor(private leadService: LeadService,private router: Router,private datePipe: DatePipe) { }

  ngOnInit(): void {
    this.loadAllLeads();
  }

  loadAllLeads() {
    this.leadService.getAllLeads().subscribe(
      (data) => {
        this.leads = data;
        console.log(this.leads);


      },
      (error) => {
        console.error(error);
      }
    );
  }

  searchLeads() {
    if (this.searchQuery && this.searchType) {
      this.leadService.searchLeads(this.searchType, this.searchQuery).subscribe(
        (data) => {
          this.leads = data;


        },
        (error) => {
          console.error(error);
        }
      );
    } else {
      this.loadAllLeads(); // If search fields are empty, load all leads
    }
  }

  callFunction() {
    this.router.navigate(['/lead-form']);
    }

    openLead(leadId: number) {
      console.log(leadId);
      this.router.navigate(['/lead-detail', leadId]);
    }

    deleteLead(leadId: number) {
      this.leadService.deleteLeadById(leadId).subscribe(
        () => {
        }

      );
    }

    // searchLeads() {
    //   this.leadService.searchLeads(this.searchType, this.searchQuery).subscribe(

    //     (results) => {
    //       // Handle the search results here
    //       // console.log(this.searchType);
    //       // console.log(this.searchQuery);
    //       console.log(results);
    //     },
    //     (error) => {
    //       console.error(error);
    //     }
    //   );
    // }
}
