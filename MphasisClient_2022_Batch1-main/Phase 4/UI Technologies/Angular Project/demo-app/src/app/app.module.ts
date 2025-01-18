import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {ChildComponent} from './child.component'
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,ChildComponent, HeaderComponent, FooterComponent
  ],
  imports: [
    BrowserModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
