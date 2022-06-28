import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule} from '@angular/forms';
import { HashLocationStrategy, LocationStrategy  } from '@angular/common';   
//------------------------Begin Primeng----------------------
import {OverlayPanelModule} from 'primeng/overlaypanel';
import {SliderModule} from 'primeng/slider';
import { PasswordModule } from "primeng/password";
import {SidebarModule} from 'primeng/sidebar';
import {PanelModule} from 'primeng/panel';
import {GMapModule} from 'primeng/gmap';
//------------------------End Primeng----------------------
//------------------------begin material----------------------
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
import { MainComponent } from './components/layout/main/main.component';
import { TopbarComponent } from './components/layout/topbar/topbar.component';
import { MenuComponent } from './components/layout/menu/menu.component';
import { TableComponent } from './components/utility/table/table.component';
import { DialogComponent } from './components/utility/dialog/dialog.component';
import { LoginComponent } from './shared/login/login.component';

// const MY_FORMATS = 
// {
//   parse: 
//   {
//     dateInput: 'dd/MM/YYYY',
//   },
//   display: 
//   {
//     dateInput: 'DD/MM/YYYY',
//     monthYearLabel: 'MMMM YYYY',
//     dateA11yLabel: 'LL',
//     monthYearA11yLabel: 'MMMM YYYY',
//   },
// };
@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    TopbarComponent,
    MenuComponent,
    TableComponent,
    DialogComponent,
    LoginComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    //------------------------Begin Primeng----------------------
    OverlayPanelModule,
    SliderModule,
    PasswordModule,
    SidebarModule,
    PanelModule,
    GMapModule,
    //------------------------End Primeng----------------------
    
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
  MatExpansionModule
  //------------------------End material----------------------
  ],
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