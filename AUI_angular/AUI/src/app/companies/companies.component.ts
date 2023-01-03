import { Component, OnInit } from '@angular/core';
import { CompanyService } from '../company.service';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit{
    companies: any;

    constructor(private companyService: CompanyService){

    }

    ngOnInit() {
        this.fetch();
    }

    fetch(){
        this.companyService.getCompanies().subscribe((response) => {
          this.companies = response.companies;
        });
    }

    onDelete(id: number){
      this.companyService.delete(id).subscribe((response) => {
        this.fetch();
      });
    }
}
