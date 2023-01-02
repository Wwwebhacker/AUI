import { Component, OnInit } from '@angular/core';
import { CompanyService } from '../company.service';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit{
    companies = undefined;

    constructor(private companyService: CompanyService){

    }

    ngOnInit() {
        this.fetch();
    }

    fetch(){
        this.companyService.getCompanies().subscribe((response) => {
          console.log(response);
        })
    }
}
