import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, Router } from '@angular/router';
import { GeneralService } from './general.service';
@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate 
{
  constructor(private generalService : GeneralService) { }
  
  public canActivate(route: ActivatedRouteSnapshot)
  {
    var userString  = localStorage.getItem("user");
    var user;
    if(userString && userString.length>0)
    {
      user = JSON.parse(userString);
      var url = this.generalService.getResolvedUrl(route);
      var myMeny = user.userResponse.role.menus.find(menu => 
      {
        return menu.routerLink.find(routerLink => 
        {
          return url.indexOf(routerLink)>=0
        })
      })
      if(user.jwt && user.jwt.length>0 && !this.generalService.tokenExpired(user.jwt) && myMeny)
        return true;
      else
      {
        return this.generalService.router.navigate(["login"]);
      }
    }
    if(this.generalService.user)
        return true;
    return this.generalService.router.navigate(["login"]);
  }

}