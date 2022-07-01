import { Component, OnInit } from '@angular/core';

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
  constructor() { }

  ngOnInit(): void 
  {
    this.init()
  }
  init()
  {
    this.user = {}
    this.userResponse = {}
  }
}
