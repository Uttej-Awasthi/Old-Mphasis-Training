import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { UserhomeComponent } from './userhome/userhome.component';

const routes: Routes = [
  {path:"signup",component:SignupComponent},
  {path:'login',component:LoginComponent},
  {path:'adminhome',component:AdminhomeComponent},
  {path:"userhome",component:UserhomeComponent},
  {path:'',redirectTo:"login",pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
