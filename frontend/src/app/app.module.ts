import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { DatePipe } from '@angular/common';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgChartsModule } from 'ng2-charts';
import { AccountDetailsComponent } from './account-details/account-details.component';
import { AccountFormComponent } from './account-form/account-form.component';
import { AccountComponent } from './account/account.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContactDetailsComponent } from './contact-details/contact-details.component';
import { ContactFormComponent } from './contact-form/contact-form.component';
import { ContactComponent } from './contact/contact.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { EditFormComponent } from './edit-form/edit-form.component';
import { HomeComponent } from './home/home.component';
import { LeadDetailsComponent } from './lead-details/lead-details.component';
import { LeadFormComponent } from './lead-form/lead-form.component';
import { LeadComponent } from './lead/lead.component';
import { LoginComponent } from './login/login.component';
import { NavComponent } from './nav/nav.component';
import { NavbarComponent } from './navbar/navbar.component';
import { OpportunityDetailsComponent } from './opportunity-details/opportunity-details.component';
import { OpportunityFormComponent } from './opportunity-form/opportunity-form.component';
import { OpportunityComponent } from './opportunity/opportunity.component';
import { RegisterComponent } from './register/register.component';
import { ReportsComponent } from './reports/reports.component';
import { HttpInterceptorService } from './service/HttpInterceptorService';
//import { LeadDetailsComponent } from './lead-details/lead-details.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    HomeComponent,
    LeadComponent,
    AccountComponent,
    ContactComponent,
    ReportsComponent,
    DashboardComponent,
    RegisterComponent,
    LeadFormComponent,
    EditFormComponent,
    AccountFormComponent,
    AccountDetailsComponent,
    ContactFormComponent,
    ContactDetailsComponent,
    OpportunityComponent,
    OpportunityDetailsComponent,
    OpportunityFormComponent,
    NavComponent,
    LeadDetailsComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgChartsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HttpInterceptorService, multi: true },
    DatePipe, // Add DatePipe to the providers array
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
