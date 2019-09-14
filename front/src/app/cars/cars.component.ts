import { Component, OnInit } from '@angular/core';
import {ExecResponse} from "../model/exec-response";
import {HttpClient} from "@angular/common/http";
import {CarResponse} from "../model/car-response";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.less']
})
export class CarsComponent implements OnInit {
  wheels : number;
  shields : number;
  cars: number;
  url = 'http://localhost:8088';

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.wheels = 0;
    this.shields = 0;
  }

  compute() {
    let url = this.url + `/cars/?wheels=${this.wheels}&shields=${this.shields}`;
    this.http.get<CarResponse>(url).subscribe(res => {
      alert('Można skonstruować: ' + res.cars + ' samochodów');
    });

  }
}
