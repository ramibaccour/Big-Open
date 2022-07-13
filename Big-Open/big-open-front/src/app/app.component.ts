import { Component, OnInit } from '@angular/core';
import { GeneralService } from './services/general.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit 
{
  constructor(public generalService : GeneralService){}

  title = 'Big-Open-Front';
  ngOnInit(): void 
  {
    var userString  ;
    userString  = localStorage.getItem("user");
    if(userString && userString.length>0)
    {
      this.generalService.user = JSON.parse(userString);
      this.generalService.lng = this.generalService.user.lng.attribut;
      var listLng;
      listLng = localStorage.getItem("listLng")
      this.generalService.listLng = JSON.parse(listLng);
      this.generalService.generateMenu();
    }    
  }
}
