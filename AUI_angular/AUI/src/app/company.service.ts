import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getCompanies() {
    return this.http.get(this.baseUrl + '/api/companies');
  }
}
