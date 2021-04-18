import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FrontEndService } from './services/front-end.service';
import { FrontEndListComponent } from './components/front-end-list/front-end-list.component';

@NgModule({
  declarations: [
    AppComponent,
    FrontEndListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    FrontEndService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
