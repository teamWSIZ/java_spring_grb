import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ContactComponent } from './contact/contact.component';
import {ExecComponent} from "./exec/exec.component";
import {CarsComponent} from "./cars/cars.component";
import {TypeViewerComponent} from "./type-viewer/type-viewer.component";

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'exec', component: ExecComponent },
  { path: 'cars', component: CarsComponent },
  { path: 'types', component: TypeViewerComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
