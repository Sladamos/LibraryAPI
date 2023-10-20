import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { PublishingHouseModule } from './publishing-house/publishing-house.module';
import { BookModule } from './book/book.module';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    PublishingHouseModule,
    BookModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
