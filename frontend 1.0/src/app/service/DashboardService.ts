import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  private apiUrl = 'http://localhost:8080/dashboard'; // Replace with your API URL

  constructor(private http: HttpClient) { }

  getAllLeadProbabilities(): Observable<number[]> {
    return this.http.get<number[]>(`${this.apiUrl}/lead-probabilities`);
  }

  getAllExpectedRevenues(): Observable<number[]> {
    return this.http.get<number[]>(`${this.apiUrl}/expected-revenues`);
  }

  getLeadCountsByStatus(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/status`);
  }

  getLeadCountsBySource(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/source`);
  }

  getLeadCountsByRegion(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/region`);
  }

  getLeadCountsByProducts(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/products`);

  }


  //Report Services

  getAllWonLeads(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/won-leads`);
  }

  getAllLostLeads(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/lost-leads`);
  }

  getTotalExpectedRevenue(): Observable<any> {
    return this.http.get<number>(`${this.apiUrl}/totalExpectedRevenue`);
  }

  getTotalWeightedRevenue(): Observable<any> {
    return this.http.get<number>(`${this.apiUrl}/totalWeightedRevenue`);
  }

  getTotalLeadCount(): Observable<any> {
    return this.http.get<number>(`${this.apiUrl}/totalLeadCount`);
  }

  getTotalWonLeadCount(): Observable<any> {
    return this.http.get<number>(`${this.apiUrl}/totalWonLeadsCount`);
  }

  getTotalLostLeadCount(): Observable<any> {
    return this.http.get<number>(`${this.apiUrl}/totalLostLeadsCount`);
  }

  getConvertionRateValue(): Observable<any> {
    return this.http.get<number>(`${this.apiUrl}/convertionRate`);
  }
}
