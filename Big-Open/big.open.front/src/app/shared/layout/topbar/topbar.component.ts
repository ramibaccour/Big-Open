import {  Component, OnInit, ViewChild } from '@angular/core';
import { ContextMenuService, MenuItem } from 'primeng/api';
import { GeneralService } from 'src/app/services/general.service';

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.scss']
})
export class TopbarComponent implements OnInit 
{

  constructor(public generalService : GeneralService) { }
  items: MenuItem[];
  showMenu : boolean = false;
  ngOnInit() 
  {
  }
    profile()
    {
      this.generalService.router.navigate(['utilisateur/profile']);
    }
    deconnection()
    {
        localStorage.removeItem('user');
        this.generalService.user = null;
        this.generalService.headers = null;
        this.generalService.router.navigate(["login"]);
    }
}
