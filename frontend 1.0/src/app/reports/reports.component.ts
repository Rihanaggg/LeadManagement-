import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../service/DashboardService';


@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit {
  leads: any[] = [];
  totalExpectedRevenue: number=0.0;
  totalLeadCount: number=0;
  totalWonLeadCount :number=0;
  totalLostLostCount : number=0;
  convertionRate: number=0;

  constructor(private dashboardService: DashboardService) {}

  ngOnInit() {
    this.loadAllLeads();

    this.dashboardService.getTotalExpectedRevenue().subscribe(
      (data) => {
        this.totalExpectedRevenue = data;
      },
      (error) => {
        console.error('Error fetching total expected revenue: ', error);
      }
    );

    this.dashboardService.getTotalLeadCount().subscribe(
      (data) => {
        this.totalLeadCount = data;
      },
      (error) => {
        console.error('Error fetching total lead count: ', error);
      }
    );

    this.dashboardService.getTotalWonLeadCount().subscribe(
      (data) => {
        this.totalWonLeadCount = data;
      },
      (error) => {
        console.error('Error fetching total lead count: ', error);
      }
    );

    this.dashboardService.getTotalLostLeadCount().subscribe(
      (data) => {
        this.totalLostLostCount = data;
      },
      (error) => {
        console.error('Error fetching total lead count: ', error);
      }
    );

    this.dashboardService.getConvertionRateValue().subscribe(
      (data) => {
        this.convertionRate = data;
      },
      (error) => {
        console.error('Error fetching total lead count: ', error);
      }
    );
  }

  loadAllLeads() {
    this.dashboardService.getAllWonLeads().subscribe(
      (data) => {
        this.leads = data;
      },
      (error) => {
        console.error(error);
      }
    );
  }
}
