import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CompanyService} from "../company.service";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-company-detail',
  templateUrl: './company-detail.component.html',
  styleUrls: ['./company-detail.component.css']
})
export class CompanyDetailComponent implements OnInit {

  id: number | undefined;
  workers: any;

  companyForm = this.fb.group({
    name: [{value: '', disabled: false}],
    age: [{value: '', disabled: false}]
  })

  constructor(private router: Router,
              private route: ActivatedRoute,
              private companyService: CompanyService,
              private fb: FormBuilder) {

  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      if (params['id']) {
        this.id = params['id'];
        this.fetchCompany();
        this.fetchWorkers();
        this.companyForm.get('age')?.disable();
      }
    })
  }

  fetchCompany() {
    if (!this.id) {
      return
    }

    this.companyService.getCompany(this.id).subscribe(response => {
      const company = response;
      this.companyForm.setValue({name: company.name, age: company.age})
    })

  }

  fetchWorkers() {
    if (!this.id) {
      return
    }

    this.companyService.getWorkers(this.id).subscribe(response => {
      this.workers = response.workers;
    })
  }

  onSubmit() {
    if (!this.id) {
      this.companyService.addCompany(this.companyForm.value).subscribe(response => {
        this.router.navigate(['companies']);
      });
    } else {
      this.companyService.updateCompany(this.id, {name: this.companyForm.value.name}).subscribe(response => {
        this.router.navigate(['companies']);
      });
    }

  }

  onDeleteWorker(workerId: number) {
    if (!this.id) {
      return
    }

    this.companyService.deleteWorker(this.id, workerId).subscribe(response => {
      if (this.id) {
        this.fetchWorkers();
      }
    });
  }

}
