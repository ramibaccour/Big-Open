import { Component, Input, OnInit, Output,  EventEmitter, ViewEncapsulation  } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser'
import * as moment from 'moment';
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class TableComponent implements OnInit 
{
  constructor(private sanitized: DomSanitizer) { }
  disabledBtnNext : boolean = false;
  disabledBtnPreview : boolean = false;
  isInisialisedTabSize = false;
  mediaQuery;
  detailVisibility;
  timerFilter;
  @Input() index = 0;
  @Output() action = new EventEmitter<any>()
  @Input() set pager(value)
  {
    this._pager = value;
    this.initTabSize()
  }
  get pager()
  {
      return this._pager;
  }
  @Input() set data(value) 
  {
    this._data = value;
    this.initDetailVisibility();
    this.initTabSize()
  } 
  get data()
  {
    return this._data;
  }
  @Input() set header(value) 
  {
    this._header = value;
    this.sortHeader();
  }
  get header()
  {
      return this._header;
  }
  private _data
  private _header
  private _pager
  tabSize;
  listBtnPage;
  responsiveSwitcher = true;
  localPager = {page :0,size : 0}
  ngOnInit(): void 
  {
    if(this.pager)
    {
      this.tabSize = this.pager.tabSize;      
    }
      
    this.onResized({target : {innerWidth : window.innerWidth}})
  }
  initTabSize()
  {
    if(this.tabSize && this.pager)
      for(var i=0; i<this.tabSize.length;i++)
      {
        if(this.tabSize[i]>this.pager.count)
          this.tabSize.splice(i);
      }
  }
  initDetailVisibility()
  {
    this.detailVisibility = {};
    if(this.data)
      for(var i= 0; i< this.data.length;i++)
      {
        this.detailVisibility[i] = false;
      }
  }
  
  onResized(event)
  {
    if(this.header.breakpoint >= event.target.innerWidth)
    this.responsiveSwitcher = false;
    else
    this.responsiveSwitcher = true;

  }
  sortHeader()
  {
      if(this.header && this.header.fields)
        this.header.fields.sort((b, a) => b.order > a.order ? 1 : -1)
  }
  filter(name : string, action : string)
  {
    if(this.timerFilter)
    {
      clearTimeout(this.timerFilter);
      this.setTimerFilter(name, action)
    }
    else
      this.setTimerFilter(name, action)
    
  }
  setTimerFilter(name : string, action : string)
  {
    this.timerFilter = setTimeout(() => 
    {
      if(this.pager && action == "filter")
        this.pager.page = 0;
      this.action.emit(
      {
        action : action,
        component : name,
        filter : this.getFilter()
      }); 
    }, 700);
  }
  filterdate(field)
  {
    if(field.filter.value.start && field.filter.value.end)
    {
      try
      {
        var start = field.filter.value.start.toDate(); // pour tester field.filter.value.start.toDate() 
        var end = field.filter.value.end.toDate(); // field.filter.value.end.toDate();
        this.filter(field.label,"filter")
      }
      catch
      {
        try
        {
          field.filter.value.end = moment(field.filter.value.end)  // field.filter.value.end.toDate();
          this.filter(field.label,"filter")
        }
        catch
        {

        }
      }
    }
  }
  viderDate(field)
  {
    field.filter.value = {start : "", end : ""};
    this.filter(field.label,"filter")
  }
  pageChange(event)
  {
    this.pager.page = event.pageIndex
    this.pager.size = event.pageSize
    this.filter("","pager")
    // if(this.timerFilter)
    // {
    //   clearTimeout(this.timerFilter);
    // }
    // this.timerFilter = setTimeout(() => 
    // {
    //   this.pager.page = event.pageIndex
    //   this.pager.size = event.pageSize
    //   this.filter("","pager")
      
    // }, 200);
    
  }
  getPager()
  {

    if(this.pager)    
      return this.pager; 
    else
      return {}
  }
  getFilter()
  {
    var rObj = {};
    this.header.fields.map( field => 
    {
      if(field.filter)
      {
        // rObj[field.name] = field.filter.value;
        if(field.filter.type != "date")
          rObj[field.name] = field.filter.value;
        else
        {
          if(field.filter.value.start && field.filter.value.end)
          {
            rObj[field.name] ={start: this.setFormaDateServer(new Date (field.filter.value.start)), end: this.setFormaDateServer(new Date (field.filter.value.end))} ;
          }
          else
          {
            rObj[field.name] ={start:"",end : ""};
          }
        }         
      }
      
    });

    return Object.assign(rObj,this.getPager());
  }
  showFilter()
  {
    return this.header.fields.reduce((previousValue, currentValue) => previousValue || (currentValue.filter? currentValue.filter.show: false),false);
  }
  
  cellClick(buttonAction, row)
  {
    this.action.emit(
    {
      action : "cellClick",
      component : buttonAction,
      filter : this.getFilter(),
      row : row
    }); 
  }
  sortClick(field, direction)
  {
    if(direction == "asc")
      field.direction = "desc"
    if(direction == "desc")
      field.direction = ""
    if(direction == "")
      field.direction = "asc"
    this.action.emit(
    {
      action : "sortClick",
      component : field,
      filter : this.getFilter(),
      direction : field.direction
    }); 
  }
  selectableCheckboxChange(row,action, index)
  {
    var valueSelect = row["SELECTABLE"] && true;
    if(action == "unique")
      this.data.forEach(d => 
      {
        d["SELECTABLE"] = false;
      });
    row["SELECTABLE"] = valueSelect;
    this.data[index]["SELECTABLE"] = row["SELECTABLE"];
    var selectedElement = this.data.filter(element => {return element["SELECTABLE"] == true})
    this.action.emit(
    {
      index,
      action : action,
      filter : this.getFilter(),
      row : row,
      selectedElement
    }); 
  }
  transform(value) 
  {
    return this.sanitized.bypassSecurityTrustHtml(value);
  }
  checkHaveExpandeRow() : boolean
  {
    
    if(this.data && this.data.length>0 )
    {
      var test = this.data.filter(element => 
      {
        var el =  element["ROWEXPAND"]
        return el != undefined
      })
      if(test.length > 0)
        return true
    }
      
    return false
  }
  setFormaDateServer(date :Date): String
  {
    var d = date.getFullYear() + "-";
    d += ((date.getMonth()+1).toString().length == 1? "0" + (date.getMonth()+1) : (date.getMonth()+1)) + "-" ;
    d += (date.getDate().toString().length == 1? "0" +date.getDate() : date.getDate()) + "T" ;
    d += (date.getHours().toString().length == 1? "0" + date.getHours() : date.getHours()) + ":" ;
    d += (date.getMinutes().toString().length == 1? "0" + date.getMinutes() : date.getMinutes()) + ":" ;
    d += (date.getSeconds().toString().length == 1? "0" + date.getSeconds() : date.getSeconds());
    return d;
  }
  console(obj)
  {
    console.log(obj);
  }
  getStyleTable()
  {
    if(this.header.height)
      return {height : this.header.height? this.header.height : 'auto','overflow-y' : 'auto'};
    else
      return {};
  }
}