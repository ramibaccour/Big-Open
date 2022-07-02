import { Component, OnInit } from '@angular/core';
import { GeneralService } from 'src/app/services/general.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit 
{
  user;
  userResponse;
  resterConnecter = false;
  listLng;
  constructor(private generalService : GeneralService) { }

  ngOnInit(): void 
  {
    this.init()
    this.getListLng();
  }
  getListLng()
  {
    this.generalService.showSpinner = true;
    var fn = (listLng)=>
    {
      this.generalService.showSpinner = false;
      this.listLng = listLng;
    }
    this.generalService.httpGet(this.generalService.urlFindAllLng,fn, this.generalService.erreur )
  }
  init()
  {
    this.user = {}
    this.userResponse = {}
  }
}
