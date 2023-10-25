import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AccountFormDTO } from '../model/AccountFormDTO';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private baseUrl = 'http://localhost:8080/api/accounts';

  constructor(private http: HttpClient) { }

  getAllAccounts(): Observable<any[]> {
    const headers = new HttpHeaders({

      'Authorization': 'Bearer ' + localStorage.getItem('token')

    });
    return this.http.get<any[]>(`${this.baseUrl}/all`, { headers });
  }

  getAccountById(accountId: number): Observable<any> {
    const headers = new HttpHeaders({

      'Authorization': 'Bearer ' + localStorage.getItem('token')

    });
    return this.http.get<any>(`${this.baseUrl}/account/${accountId}`, { headers });
  }

  createAccount(accountForm: any): Observable<string> {
    const headers = new HttpHeaders({

      'Authorization': 'Bearer ' + localStorage.getItem('token'),
      'Content-Type': 'application/json'
    });

    return this.http.post<string>(`${this.baseUrl}/create`, accountForm, { headers });
  }

  updateAccount(accountId: number, updatedForm: any): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('token'),
      'Content-Type': 'application/json'
    });
    return this.http.put<any>(`${this.baseUrl}/update/${accountId}`, updatedForm, { headers });
  }

  updateAccountAttributes(accountId: number, updatedAttributes: any): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('token'),
      'Content-Type': 'application/json'
    });
    return this.http.patch<any>(`${this.baseUrl}/updatebyid/${accountId}`, updatedAttributes, { headers });
  }


  deleteAccountById(accountId: number): Observable<void> {
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });

    return this.http.delete<void>(`${this.baseUrl}/delete/${accountId}`, { headers });
  }

  searchAccounts(searchType: string, query: string): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
    return this.http.get(`${this.baseUrl}/search?searchType=${searchType}&query=${query}`,{headers});
  }


  patchAccount(accountId: number, AccountFormDTO: any): Observable<AccountFormDTO> {
console.log(accountId);

    const url = `${this.baseUrl}/updatebyId/${accountId}`;

    return this.http.patch<AccountFormDTO>(url, AccountFormDTO);

}
}
