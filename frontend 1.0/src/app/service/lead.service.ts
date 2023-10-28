import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FirstFormDTO } from '../model/FirstFormDTO';

@Injectable({
  providedIn: 'root'
})
export class LeadService {

  private baseUrl = 'http://localhost:8080/api/leads'; // Replace with your backend URL

  constructor(private http: HttpClient) { }

  getAllLeads(): Observable<any[]> {

    return this.http.get<any[]>(`${this.baseUrl}/all`);

  }

  createLead(firstFormDTO: FirstFormDTO): Observable<string> {

    return this.http.post<string>(`${this.baseUrl}/create`, firstFormDTO);
  }

  getLeadById(leadId: number) {

    return this.http.get<any>(`${this.baseUrl}/lead/${leadId}`);
  }

  deleteLeadById(leadId: number): Observable<void> {


    return this.http.delete<void>(`${this.baseUrl}/delete/${leadId}`);
  }

  searchLeads(searchType: string, query: string): Observable<any> {

    return this.http.get(`${this.baseUrl}/search?searchType=${searchType}&query=${query}`);
  }



  patchLead(leadId: number, FirstFormDTO: any): Observable<FirstFormDTO> {

          const url = `${this.baseUrl}/update/${leadId}`;

          return this.http.patch<FirstFormDTO>(url, FirstFormDTO);

      }

  updateLeadStatus(leadId: number, newStatus: string): Observable<string> {
    // const url = `${this.baseUrl}/${leadId}/status/${newStatus}`;
    const url = `http://localhost:8080/api/leads/${leadId}/status?newStatus=${newStatus}`;


    console.log(newStatus);

    return this.http.put<string>(url,null);
  }


}
