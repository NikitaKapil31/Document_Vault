import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { MainComponent } from './main/main.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { FaqComponent } from './faq/faq.component';
import { FeedbackComponent } from './feedback/feedback.component';

const routes: Routes = [
  {path : 'home', component:HomeComponent},
  {path : 'contact', component:ContactComponent},
  {path : 'about-us', component:AboutUsComponent},
  {path : 'main', component:MainComponent},
  {path : 'sign-in', component:SignInComponent},
  {path : 'sign-up', component:SignUpComponent},
  {path : 'faq', component:FaqComponent},
  {path : 'feedback', component:FeedbackComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
