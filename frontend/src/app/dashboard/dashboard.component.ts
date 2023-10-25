import { Component } from '@angular/core';
import { ChartDataset, ChartOptions, ChartType } from 'chart.js';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  public lineChartData: ChartDataset[] = [
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A' },
  ];

  public lineChartLabels: string[] = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];

  public lineChartOptions: ChartOptions = {
    responsive: true,
  };


  // pie chart


// public pieChartOptions: ChartOptions = {
//   responsive: true,
// };

// public pieChartLabels: string[] = ['Red', 'Green', 'Blue'];
// public pieChartData: number[] = [300, 500, 100];
// public pieChartType: ChartType = 'pie';
// public pieChartLegend = true;


// public pieChartOptions: ChartOptions = {
//   responsive: true,
// };

// public pieChartLabels: string[] = ['Red', 'Green', 'Blue'];
// public pieChartData: ChartDataSets[] = [
//   { data: [300, 500, 100], backgroundColor: ['#FF5733', '#33FF57', '#3366FF'], label: 'Series A' }
// ];
// public pieChartType: ChartType = 'pie';
// public pieChartLegend = true;
// }


public barChartOptions: ChartOptions = {
  responsive: true,
};

public barChartLabels: string[] = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];
public barChartType: ChartType = 'bar';
public barChartLegend = true;

public barChartData: ChartDataset[] = [
  { data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A' },
];
}
