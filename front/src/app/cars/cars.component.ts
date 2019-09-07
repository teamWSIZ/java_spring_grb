import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.less']
})
export class CarsComponent implements OnInit {
  wheels : number;
  shields : number;
  cars: number;

  constructor() { }

  ngOnInit() {
  }

  compute() {

  }
}
