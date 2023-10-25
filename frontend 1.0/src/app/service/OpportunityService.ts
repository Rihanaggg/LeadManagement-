import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OpportunityFormDTO } from '../model/OpportunityFormDTO';
// Assuming you have created this DTO

@Injectable({
  providedIn: 'root'
})
export class OpportunityService {
  private apiUrl = 'http://localhost:8080/api/opportunities'; // Replace with your backend API URL

  constructor(private http: HttpClient) { }

  getAllOpportunities(): Observable<OpportunityFormDTO[]> {

    return this.http.get<OpportunityFormDTO[]>(`${this.apiUrl}/all`);
  }

  getOpportunityById(id: number): Observable<OpportunityFormDTO> {
console.log();

    return this.http.get<OpportunityFormDTO>(`${this.apiUrl}/opportunity/${id}`);
  }

  deleteOpportunityById(id: number): Observable<void> {

    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }

  createOpportunity(opportunityForm: OpportunityFormDTO): Observable<string> {

    return this.http.post<string>(`${this.apiUrl}/create`, opportunityForm);
  }

  updateOpportunity(id: number, updatedForm: OpportunityFormDTO): Observable<OpportunityFormDTO> {

    return this.http.put<OpportunityFormDTO>(`${this.apiUrl}/update/${id}`, updatedForm);
  }

  searchOpportunitiesByStatus(status: string): Observable<OpportunityFormDTO[]> {

    return this.http.get<OpportunityFormDTO[]>(`${this.apiUrl}/search/status?status=${status}`);
  }

  // searchOpportunities(searchType: string, query: string): Observable<any> {
  //   const headers = new HttpHeaders({
  //     'Authorization': 'Bearer ' + localStorage.getItem('token')
  //   });
  //   return this.http.get(`${this.apiUrl}/search?searchType=${searchType}&query=${query}`, { headers });
  // }

  patchOpportunity(id: number, OpportunityFormDTO: any): Observable<OpportunityFormDTO> {

    const url = `${this.apiUrl}/updatebyId/${id}`;

    return this.http.patch<OpportunityFormDTO>(url, OpportunityFormDTO);

}
}
