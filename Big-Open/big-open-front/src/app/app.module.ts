import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule} from '@angular/forms';
import { HashLocationStrategy, LocationStrategy  } from '@angular/common';   
//------------------------Begin material----------------------
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {DateAdapter, MatNativeDateModule, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { MatMomentDateModule, MAT_MOMENT_DATE_ADAPTER_OPTIONS, MomentDateAdapter } from "@angular/material-moment-adapter";
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatDialogModule} from '@angular/material/dialog';
import {MatCardModule} from '@angular/material/card';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatFormFieldModule} from '@angular/material/form-field';   
import {MomentDateModule} from '@angular/material-moment-adapter';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatExpansionModule} from '@angular/material/expansion';
//------------------------End material----------------------
import { MainComponent } from './shared/layout/main/main.component';
import { TopbarComponent } from './shared/layout/topbar/topbar.component';
import { MenuComponent } from './shared/layout/menu/menu.component';
import { TableComponent } from './shared/utility/table/table.component';
import { DialogComponent } from './shared/utility/dialog/dialog.component';
import { LoginComponent } from './shared/login/login.component';

//------------------------Begin Translate----------------------
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { AccueilleComponent } from './components/accueille/accueille.component';
//------------------------End Translate----------------------

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    TopbarComponent,
    MenuComponent,
    TableComponent,
    DialogComponent,
    LoginComponent,
    AccueilleComponent,
   
  ],
  imports: 
  [
    
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  //------------------------begin material----------------------
  MatButtonModule,
  MatIconModule,
  MatSelectModule,
  MatInputModule,
  MatDatepickerModule,
  MatNativeDateModule, 
  MatMomentDateModule,
  MatCheckboxModule,
  MatTooltipModule,
  MatSnackBarModule,
  MatDialogModule,
  MatCardModule,
  MatProgressSpinnerModule,  
  MatFormFieldModule,
  MomentDateModule,
  MatPaginatorModule,
  MatExpansionModule,
  //------------------------End material----------------------
  //------------------------Begin Translate----------------------
  TranslateModule.forRoot(
  {
    loader: 
    {
      provide: TranslateLoader,
      useFactory: httpTranslateLoader,
      deps: [HttpClient]
    }
  })
  ],
  //------------------------End Translate----------------------
  providers: 
  [
    // {provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE]},
    // {provide: MAT_DATE_FORMATS, useValue: MY_FORMATS}
    {provide : LocationStrategy , useClass: HashLocationStrategy},
    {provide: MAT_MOMENT_DATE_ADAPTER_OPTIONS, useValue: { useUtc: true } },
    {provide: MAT_DATE_LOCALE, useValue: 'fr-FR'},
    {
        provide: DateAdapter,
        useClass: MomentDateAdapter,
        deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
export function httpTranslateLoader(http: HttpClient) 
{
  return new TranslateHttpLoader(http);
}