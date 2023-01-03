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

  getWorker(companyId: number, workerId: number){
    return this.http.get<{name: string, age: string}>(this.baseUrl + `/api/companies/${companyId}/workers/${workerId}`);
  }

  delete(id: number) {
    return this.http.delete(this.baseUrl + `/api/companies/${id}`);
  }

  deleteWorker(companyId: number, workerId: number){
    return this.http.delete(this.baseUrl + `/api/companies/${companyId}/workers/${workerId}`);
  }

  addCompany(body: object){
    return this.http.post(this.baseUrl +`/api/companies`, body);
  }

  addWorker(companyId: number, body: object){
    return this.http.post(this.baseUrl +`/api/companies/${companyId}/workers`, body);
  }

  updateCompany(id: number, body: object){
    return this.http.put(this.baseUrl +`/api/companies/${id}`, body);
  }

  updateWorker(companyId: number, workerId: number, body: object){
    return this.http.put(this.baseUrl +`/api/companies/${companyId}/workers/${workerId}`, body);
  }
}
