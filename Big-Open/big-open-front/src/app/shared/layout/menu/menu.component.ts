import { Component, OnInit } from '@angular/core';
import { GeneralService } from 'src/app/services/general.service';
declare var $;
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit 
{
  constructor(public generalService : GeneralService) { }
  menus;
  ngOnInit(): void 
  {
  }
  getParentNode()
  {
    return this.menus.filter(menu => { return this.generalService.isEmpty(menu.idParent)} )
  }
  getSubParentNode(menuParent)
  {
    return this.menus.filter(menu =>  {return menuParent.id == menu.idParent})
  }
  goToMenu(menu)
  {
    if(this.getSubParentNode(menu).length == 0)
    {
      this.menus.forEach(m => 
      {
        m.selected = false;
      });
      menu.selected = true;      
    }
    else
      menu.open = !menu.open
    if(menu.routerLink && menu.routerLink.length>0)
    {
      this.generalService.router.navigate(menu.routerLink)

    }    
  }
}
