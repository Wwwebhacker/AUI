import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CompanyService} from "../company.service";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-worker-detail',
  templateUrl: './worker-detail.component.html',
  styleUrls: ['./worker-detail.component.css']
})
export class WorkerDetailComponent implements OnInit {

  workerId: number | undefined;
  companyId: number | undefined;

  workerForm = this.fb.group({
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
      this.companyId = params['companyId']
      if (params['workerId']) {
        this.workerId = params['workerId'];
        this.fetchWorker();
        this.workerForm.get('age')?.disable();
      }
    })
  }

  fetchWorker() {
    if (!this.workerId || !this.companyId) {
      return;
    }

    this.companyService.getWorker(this.companyId, this.workerId).subscribe(response => {
      const worker = response;
      this.workerForm.setValue({name: worker.name, age: worker.age})
    })
  }

  onSubmit() {
    if (!this.companyId) {
      return;
    }

    if (!this.workerId) {
      this.companyService.addWorker(this.companyId, this.workerForm.value).subscribe(response => {
        this.router.navigate(['companies/create-edit'], {
          queryParams: {id: this.companyId}
        });
      });
    } else {
      this.companyService.updateWorker(this.companyId, this.workerId, {name: this.workerForm.value.name}).subscribe(response => {
        this.router.navigate(['companies/create-edit'], {
          queryParams: {id: this.companyId}
        });
      });
    }

  }
}
