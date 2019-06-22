import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ExecResponse} from "../model/exec-response";

@Component({
  selector: 'app-exec',
  templateUrl: './exec.component.html',
  styleUrls: ['./exec.component.less']
})
export class ExecComponent implements OnInit {
  host = 'http://localhost:8088/exec';
  output: string[];


  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  executeCommand() {
    let url = this.host + '?pass=secret!&cmd=df';
    this.http.get<ExecResponse>(url).subscribe(res=>{
      this.output = res.ouput;
    })
  }

}
