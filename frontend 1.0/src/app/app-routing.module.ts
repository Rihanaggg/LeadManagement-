import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountDetailsComponent } from './account-details/account-details.component';
import { AccountFormComponent } from './account-form/account-form.component';
import { AccountComponent } from './account/account.component';
import { ContactDetailsComponent } from './contact-details/contact-details.component';
import { ContactFormComponent } from './contact-form/contact-form.component';
import { ContactComponent } from './contact/contact.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { LeadDetailsComponent } from './lead-details/lead-details.component';
import { LeadFormComponent } from './lead-form/lead-form.component';
import { LeadComponent } from './lead/lead.component';
import { LoginComponent } from './login/login.component';
import { OpportunityDetailsComponent } from './opportunity-details/opportunity-details.component';
import { OpportunityFormComponent } from './opportunity-form/opportunity-form.component';
import { OpportunityComponent } from './opportunity/opportunity.component';
import { RegisterComponent } from './register/register.component';
import { ReportsComponent } from './reports/reports.component';
import { AuthGuard } from './service/auth.guard';

const routes: Routes = [
  //{ path: '',redirectTo : '/home',pathMatch : 'full'},
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'home', component: HomeComponent },
  { path: 'lead', component: LeadComponent ,canActivate: [AuthGuard] },
  { path: 'account', component: AccountComponent ,canActivate: [AuthGuard] },
  { path: 'contact', component: ContactComponent ,canActivate: [AuthGuard]},
  { path: 'opportunity', component: OpportunityComponent ,canActivate: [AuthGuard]},
  { path: 'reports', component: ReportsComponent ,canActivate: [AuthGuard]},
  { path: 'dashboard', component: DashboardComponent ,canActivate: [AuthGuard]},
  { path: 'lead-form', component: LeadFormComponent ,canActivate: [AuthGuard] },
  { path: 'lead-detail/:leadId', component: LeadDetailsComponent ,canActivate: [AuthGuard]},
  { path: 'account-form', component: AccountFormComponent ,canActivate: [AuthGuard] },
  { path: 'account-detail/:accountId', component: AccountDetailsComponent ,canActivate: [AuthGuard]},
  { path: 'contact-form', component: ContactFormComponent ,canActivate: [AuthGuard] },
  { path: 'contact-detail/:contactId', component: ContactDetailsComponent ,canActivate: [AuthGuard]},
  { path: 'opportunity-form', component: OpportunityFormComponent ,canActivate: [AuthGuard] },
  { path: 'opportunity-detail/:oppId', component: OpportunityDetailsComponent ,canActivate: [AuthGuard]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
