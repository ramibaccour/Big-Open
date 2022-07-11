import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
  typeInput = "password";
  iconPassword = "visibility";
  constructor(private generalService : GeneralService, private router: Router) { }

  ngOnInit(): void 
  {
    this.init()
    this.getListLng();
  }
  getListLng()
  {
    setTimeout(()=>
    {
      this.generalService.showSpinner = true;
      var fn = (listLng)=>
      {
        this.generalService.showSpinner = false;
        this.listLng = listLng.listLngResponse;
        this.setTranslate();
      }
      this.generalService.httpGet(this.generalService.urlFindAllLng,fn, this.generalService.erreur )
    },50);
    
  }
  setTranslate()
  {
    var listLng = this.listLng.map(lng => {return lng.code})
    this.generalService.translate.addLangs(listLng);
    var defaulLng = this.listLng.find(lng => {return lng.byDefault == 1});
    if(defaulLng)
      this.generalService.translate.setDefaultLang(defaulLng.code);
  }
    
  init()
  {
    this.user = {}
    this.userResponse = {}
  }
  setLng(lng)
  {
    this.generalService.switchLang(lng.code)
    this.generalService.lng = lng.attribut;
    this.user.lng = lng;
  }
  showPassword()
  {
    if(this.typeInput == "password")
    {
      this.typeInput = "text";
      this.iconPassword = "visibility_off" ;
    }      
    else
    {
      this.typeInput = "password";
      this.iconPassword = "visibility" ;

    }
  }
  connection()
  {
    this.generalService.showSpinner = true;
    var fn = (user)=>
    {
      this.generalService.showSpinner = false;
      if(user.responseError == null && user.jwt)
      {
        this.generalService.user = user;
        this.generalService.lng = user.lng.attribut;
        if(this.resterConnecter)
          localStorage.setItem("user",JSON.stringify(user));   
        this.router.navigate(["/accueille"])
      }
    }
    this.generalService.httpPost(this.user, this.generalService.urlSignin,fn, this.generalService.erreur )
  }
}

