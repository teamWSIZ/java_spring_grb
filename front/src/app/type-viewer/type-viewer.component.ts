import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CarType} from "../model/cartype";

@Component({
  selector: 'app-type-viewer',
  templateUrl: './type-viewer.component.html',
  styleUrls: ['./type-viewer.component.less']
})
export class TypeViewerComponent implements OnInit {
  carTypes : CarType[];
  car: string;

  constructor(private http : HttpClient) { }

  ngOnInit() {
    this.car = 'None'

  }

}
