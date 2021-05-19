import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { CategoriesComponent } from './categories/categories.component';
import { ContactComponent } from './contact/contact.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DetailsComponent } from './details/details.component';
import { DocumentsComponent } from './documents/documents.component';
import { HomeComponent } from './home/home.component';
import { MainComponent } from './main/main.component';
import { UsersComponent } from './users/users.component';
import { FaqComponent } from './faq/faq.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';

const routes: Routes = [
  {path : 'home', component : HomeComponent},
  {path : 'contact', component : ContactComponent},
  {path : 'about-us', component : AboutUsComponent},
  {path : 'main', component : MainComponent},
  {path : 'dashboard', component : DashboardComponent},
  {path : 'documents', component : DocumentsComponent},
  {path : 'categories', component : CategoriesComponent},
  {path: 'users', component: UsersComponent },
  { path: 'details', component: DetailsComponent },
  { path: 'faq', component: FaqComponent },
  { path: 'feedback', component: FeedbackComponent },
  { path: 'sign-in', component: SignInComponent },
  { path: 'sign-up', component: SignUpComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
