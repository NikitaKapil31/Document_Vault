import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { CategoriesComponent } from './categories/categories.component';
import { ContactComponent } from './contact/contact.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DocumentsComponent } from './documents/documents.component';
import { HomeComponent } from './home/home.component';
import { MainComponent } from './main/main.component';
import { UsersComponent } from './users/users.component';
import { FaqComponent } from './faq/faq.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AddDocumentComponent } from './add-document/add-document.component';
import { ListDocumentComponent } from './list-document/list-document.component';
import { UpdateDocumentComponent } from './update-document/update-document.component';
import { ProfileComponent } from './profile/profile.component';
import { SettingsComponent } from './settings/settings.component';

const routes: Routes = [
  { path : 'home', component : HomeComponent},
  { path: '', component : HomeComponent },
  { path : 'contact', component : ContactComponent},
  { path : 'about-us', component : AboutUsComponent},
  { path : 'main', component : MainComponent},
  { path : 'dashboard', component : DashboardComponent},
  { path : 'documents', component : DocumentsComponent},
  { path : 'categories', component : CategoriesComponent},
  { path: 'users', component: UsersComponent },
  { path: 'faq', component: FaqComponent },
  { path: 'feedback', component: FeedbackComponent },
  { path: 'sign-in', component: SignInComponent },
  { path: 'sign-up', component: SignUpComponent },
  { path: 'add-document', component: AddDocumentComponent},
  { path: 'list-document', component: ListDocumentComponent},
  { path: 'update-document', component: UpdateDocumentComponent },
  { path: 'profile', component: ProfileComponent},
  { path: 'settings', component: SettingsComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
