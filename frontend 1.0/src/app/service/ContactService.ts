import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ContactFormDTO } from '../model/ContactFormDTO';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  private baseUrl = 'http://localhost:8080/api/contacts';

  constructor(private http: HttpClient) { }

  getAllContacts(): Observable<any[]> {
       return this.http.get<any[]>(`${this.baseUrl}/all`);
  }

  getContactById(contactId: number): Observable<any> {

    return this.http.get<any>(`${this.baseUrl}/contact/${contactId}`);
  }

  createContact(contactForm: any): Observable<string> {

    return this.http.post<string>(`${this.baseUrl}/create`, contactForm);
  }

  updateContact(contactId: number, updatedForm: any): Observable<any> {

    return this.http.put<any>(`${this.baseUrl}/update/${contactId}`, updatedForm);
  }

  updateContactAttributes(contactId: number, updatedAttributes: any): Observable<any> {

    return this.http.patch<any>(`${this.baseUrl}/updatebyid/${contactId}`, updatedAttributes);
  }

  deleteContactById(contactId: number): Observable<void> {

    return this.http.delete<void>(`${this.baseUrl}/delete/${contactId}`);
  }

  searchContacts(searchType: string, query: string): Observable<any> {

    return this.http.get(`${this.baseUrl}/search?searchType=${searchType}&query=${query}`);
  }

  patchContact(contactId: number, ContactFormDTO: any): Observable<ContactFormDTO> {
    console.log(contactId);

        const url = `${this.baseUrl}/updatebyId/${contactId}`;

        return this.http.patch<ContactFormDTO>(url, ContactFormDTO);

    }
}
