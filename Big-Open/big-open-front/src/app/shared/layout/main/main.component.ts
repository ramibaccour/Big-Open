import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { GeneralService } from 'src/app/services/general.service';
declare var $;
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

  constructor(public generalService : GeneralService) { }
  setColor
  ngOnInit() 
  {
    if(this.generalService.user)
    {
      this.generalService.headers = new HttpHeaders
      ({ 
          // 'Content-Type': 'application/json',
          'Authorization':  'Bearer ' + this.generalService.user.jwt
      });
      //this.generalService.menus = this.makeTree(this.generalService.user.userResponse.role.menus,"");
    }
  }

  // makeTree(nodes, parentId) 
  // {
  //     return nodes
  //       .filter((node) => node.idParent === parentId)
  //       .reduce(
  //         (tree, node) => 
  //         [
  //           ...tree,
  //           this.makeTree(nodes, node.id).length>0?
  //           {
  //             ...node,
  //             items: this.makeTree(nodes, node.id)
  //           }:
  //           {
  //             ...node,
  //           },
  //         ],
  //         [],
  //       )
  // }

}
