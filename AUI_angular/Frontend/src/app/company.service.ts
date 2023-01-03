import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {
  }

  getCompanies() {
    return this.http.get<{ companies: Array<any> }>(this.baseUrl + '/api/companies');
  }
  getWorkers(id: number){
    return this.http.get<{workers: Array<any>}>(this.baseUrl + `/api/companies/${id}/workers`);
  }

  getCompany(id: number) {
    return this.http.get<{name: string, age: string}>(this.baseUrl + `/api/companies/${id}`);
  }

  delete(id: number) {
    return this.http.delete(this.baseUrl + `/api/companies/${id}`);
  }

  addCompany(body: object){
    return this.http.post(this.baseUrl +`/api/companies`, body);
  }

  updateCompany(id: number | undefined, body: object){
    return this.http.put(this.baseUrl +`/api/companies/${id}`, body);
  }
}
