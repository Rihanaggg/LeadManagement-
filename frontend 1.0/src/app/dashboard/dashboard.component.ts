import { Component, OnInit } from '@angular/core';
import { ChartDataset, ChartOptions, ChartType } from 'chart.js';
import { interval } from 'rxjs';
import { DashboardService } from '../service/DashboardService';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  leadProbabilities: number[] = [];
  statusCounts: any = {};


  public lineChartData: ChartDataset[] = [
    { data: [], label: 'Probability Analysis' },
  ];

  public lineChartLabels: string[] = [];

  public lineChartOptions: ChartOptions = {
    responsive: true,
  };

  public pieChartOptions: ChartOptions = {
    responsive: true,
  };


  public pieChartData: ChartDataset[] = [];
  public pieChartLabels: string[] = [];

  public pieChartType: ChartType = 'pie';
  public pieChartLegend = true;

  public barChartOptions: ChartOptions = {
    responsive: true,
  };

  public barChartData: ChartDataset[] = [
    { data: [], label: 'Products Count' },
  ];

  public barChartLabels: string[] = [];

  public barChartType: ChartType = 'bar';
  public barChartLegend = true;

  public doughnutChartOptions: ChartOptions = {
    responsive: true,
    aspectRatio: 1, // Set the aspect ratio to make it a circle
    //cutout: '70%', // Adjust the size of the center hole
  };

  public doughnutChartData: ChartDataset[] = [];
  public doughnutChartLabels: string[] = [];

  public doughnutChartType: ChartType = 'doughnut';
  public doughnutChartLegend = true;

  constructor(private dashboardService: DashboardService) { }

  ngOnInit(): void {
    interval(1000) // Poll every 1 seconds (adjust as needed)
      .subscribe(() => {
        this.dashboardService.getAllLeadProbabilities().subscribe(data => {
          this.leadProbabilities = data;
          this.lineChartData[0].data = this.leadProbabilities;
          this.lineChartLabels = Array.from({ length: data.length }, (_, i) => `Lead ${i + 1}`);
        });
      });


    this.dashboardService.getLeadCountsByStatus().subscribe(data => {
      this.pieChartLabels = Object.keys(data);
      this.pieChartData = [
        { data: Object.values(data), backgroundColor: ['#FF5733', '#33FF57', '#3366FF', '#FFC300', '#8E44AD'], label: 'Status Counts' }
      ];
    });

    this.dashboardService.getLeadCountsByProducts().subscribe(data => {
      this.barChartLabels = Object.keys(data);
      this.barChartData[0].data = Object.values(data);
    });

    this.dashboardService.getLeadCountsByRegion().subscribe(data => {
      this.doughnutChartLabels = Object.keys(data);
      this.doughnutChartData = [
        { data: Object.values(data), backgroundColor: ['#FF5733', '#33FF57', '#3366FF', '#FFC300'], label: 'Region Counts' }
      ];
    });
  }
}
