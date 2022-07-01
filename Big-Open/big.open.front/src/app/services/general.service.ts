import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, Router } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialog } from '@angular/material/dialog';
import { DomSanitizer } from '@angular/platform-browser';
// declare var ol;
@Injectable({
  providedIn: 'root'
})
export class GeneralService 
{
  constructor(private sanitized: DomSanitizer, public router: Router, private http: HttpClient,public route: ActivatedRoute, private _snackBar: MatSnackBar,public dialog: MatDialog) { }
  url;
  api;
  headers;
  user
  showSpinner;
  selectedElement;
  modeModal = false;
  listeSelectable;
  dialogRef;
// -----------------begin pour api osrm pam -----------------
  // points = []
  // url_osrm_nearest = 'https://router.project-osrm.org/nearest/v1/driving/'
  // url_osrm_route =   'https://router.project-osrm.org/route/v1/driving/'
  // url_osrm_trip =    'https://router.project-osrm.org/trip/v1/bike/'
  // icon_livreur = 'assets/images/livreur.png'
  // icon_user = 'assets/images/user.png'
  // icon_restau = 'assets/images/restau.png'
  // vectorSource = new ol.source.Vector()
  // vectorLayer = new ol.layer.Vector
  // ({
  //   source: this.vectorSource
  // })

  // styles = 
  // {
  //   route: new ol.style.Style
  //   ({
  //     stroke: new ol.style.Stroke
  //     ({
  //       width: 4, 
  //       color: [40, 40, 40, 0.8]
  //     })
  //   }),
  //   routeCmd: new ol.style.Style
  //   ({
  //     stroke: new ol.style.Stroke
  //     ({
  //       width: 4, 
  //       color: ""
  //     })
  //   }),
  //   iconLivreur: new ol.style.Style
  //   ({
  //     image: new ol.style.Icon
  //     ({
  //       anchor: [0.5, 1],
  //       src: this.icon_livreur
  //     })
  //   }),
  //   iconUser: new ol.style.Style
  //   ({
  //     image: new ol.style.Icon
  //     ({
  //       anchor: [0.5, 1],
  //       src: this.icon_user
  //     })
  //   }),
  //   iconRestau: new ol.style.Style
  //   ({
  //     image: new ol.style.Icon
  //     ({
  //       anchor: [0.5, 1],
  //       src: this.icon_restau
  //     })
  //   })
  // };

  // utils = 
  // {    
  //   getStyleRoute :(color,width= 4, lineDash? )=>
  //   {
  //     return new ol.style.Style
  //     ({
  //       stroke: new ol.style.Stroke
  //       ({
  //         width: width, 
  //         color: color,
  //         lineDash: lineDash? lineDash : []
  //       })
  //     })
  //   },
  //   getNearest: (coord)=>
  //   {
  //     var coord4326 = this.utils.to4326(coord);    
  //     return new Promise((resolve, reject)=>
  //     {
  //       //make sure the coord is on street
  //       fetch(this.url_osrm_nearest + coord4326.join()).then((response) =>
  //       { 
  //         // Convert to JSON
  //         return response.json();
  //       }).then((json) =>
  //       {
  //         if (json.code === 'Ok') 
  //           resolve(json.waypoints[0].location);
  //         else 
  //           reject();
  //       });
  //     });
  //   },
  //   createFeature: (coord, styles) =>
  //   {
  //     var feature = new ol.Feature
  //     ({
  //       type: 'place',
  //       geometry: new ol.geom.Point(ol.proj.fromLonLat(coord))
  //     });
  //     feature.setStyle(styles);
  //     this.vectorSource.addFeature(feature);
  //     return feature;
  //   },
  //   createRoute: (polyline, style) =>
  //   {
  //     // route is ol.geom.LineString
  //     var route = new ol.format.Polyline
  //     ({
  //       factor: 1e5
  //     }).readGeometry(polyline, 
  //     {
  //       dataProjection: 'EPSG:4326',
  //       featureProjection: 'EPSG:3857'
  //     });
     
  //     var feature = new ol.Feature
  //     ({
  //       type: 'route',
  //       geometry: route
  //     });
  //     feature.setStyle(style);
  //     this.vectorSource.addFeature(feature);
  //     this.showSpinner = false;
  //     return feature
  //   },
  //   to4326: (coord)=>
  //   {
      
  //     return ol.proj.transform
  //     ([
  //       parseFloat(coord[0]), parseFloat(coord[1])
  //     ], 'EPSG:3857', 'EPSG:4326');
  //   },
  //   to3857: (coord)=>
  //   {
  //     return ol.proj.transform([parseFloat(coord[0]), parseFloat(coord[1])], 'EPSG:4326', 'EPSG:3857');
      
  //   },
  //   to28992: (coord)=>
  //   {
  //     return ol.proj.transform([parseFloat(coord[0]), parseFloat(coord[1])], 'EPSG:3857', 'EPSG:28992')
      
  //   },
  //   to2284: (coord)=>
  //   {
  //     return ol.proj.transform([-79.4460,37.7890], 'EPSG:4326', 'EPSG:2284');
      
  //   }
  // };
// -----------------end pour api osrm pam -----------------
  httpPost(object,url, fn,error)
  {
    this.checkToken();
    return this.http.post<any>(this.url+this.api + url, object, {headers : this.headers})
    .pipe(catchError(error? error: ()=>{ return of([]); }))    
    .subscribe(fn);
  }
  httpPut(object,url, fn,error)
  {
    this.checkToken();
    return this.http.put<any>(this.url+this.api + url, object, {headers : this.headers})
    .pipe(catchError(error? error: ()=>{ return of([]); }))    
    .subscribe(fn);
  }
  httpGet(url, fn,error)
  {
    this.checkToken();
    return this.http.get<any>(this.url+this.api + url, {headers : this.headers})
    .pipe(catchError(error? error: ()=>{ return of([]); }))    
    .subscribe(fn);
  }
  httpDelete(url, fn,error)
  {
    this.checkToken();
    return this.http.delete<any>(this.url+this.api + url, {headers : this.headers})
    .pipe(catchError(error? error: ()=>{ return of([]); }))    
    .subscribe(fn);
  }
  public tokenExpired(token: string) 
  {
    const expiry = (JSON.parse(atob(token.split('.')[1]))).exp;
    return (Math.floor((new Date).getTime() / 1000)) >= expiry;
  }
  public isEmpty(text)
  {
    return text == undefined || text == null || text == ""
  }
  openSnackBar(message : string,status:boolean, duration = 2000) 
  {
    this._snackBar.open(message,"", {duration:  duration,panelClass : [status ? "success" : "failure"]})
    
  }
  checkToken() 
  {
    if(this.user && this.user.jwt && this.tokenExpired(this.user.jwt))
    {
      this.router.navigate(["login"])
      this.headers = null;
      this.user = null;
      
    }
    return 
  }
  transform(url) 
  {
    return this.sanitized.bypassSecurityTrustResourceUrl(url);
  }
  setFormaDateServer(date :Date): String
  {
    //2022-06-04T07:33:52
    var d = date.getFullYear() + "-";
    d += ((date.getMonth()+1).toString().length == 1? "0" + (date.getMonth()+1) : (date.getMonth()+1)) + "-" ;
    d += (date.getDate().toString().length == 1? "0" +date.getDate() : date.getDate()) + "T" ;
    d += (date.getHours().toString().length == 1? "0" + date.getHours() : date.getHours()) + ":" ;
    d += (date.getMinutes().toString().length == 1? "0" + date.getMinutes() : date.getMinutes()) + ":" ;
    d += (date.getSeconds().toString().length == 1? "0" + date.getSeconds() : date.getSeconds());
    return d;
  }
  getResolvedUrl(route: ActivatedRouteSnapshot): string 
  {
    var str = "/";
    route.pathFromRoot
        .map(v => v.url.map(segment => 
          {
            segment.toString();
            if(segment.toString() != "" && segment.toString()!= null)
              str = str + segment.toString() + "/"
          }).join('/'))
        .join('/');
      if(str.length>1)
      str = str.substring(0,str.length-1)
      return str
  }

  console(obj)
  {
    console.log(obj);
  }
  changeIconDelete(event, header)    
  {
    var header = header.fields.find(h => {return h.name == "action"});
    if(header)
    {
      var btn = header.buttons.find(b =>{return b.name == "delete"});
      if(btn)
      {
        if( event.filter.isArchived == true )
        {
          btn.icon = "restore";
          btn.label = "Restaurer";
        }
        else
        {
          btn.icon = "delete";
          btn.label = "Supprimer";
        }         
      }
     
    }

  }
  
  toBlob(dataURL : String)
  {
    var BASE64_MARKER = ';base64,';
    if (dataURL.indexOf(BASE64_MARKER) == -1) 
    {
        var parts = dataURL.split(',');
        var contentType = parts[0].split(':')[1];
        var raw1 = parts[1];

        return new Blob([raw1], {type: contentType});
    }

    var parts = dataURL.split(BASE64_MARKER);
    var contentType = parts[0].split(':')[1];
    var raw = window.atob(parts[1]);
    var rawLength = raw.length;

    var uInt8Array = new Uint8Array(rawLength);

    for (var i = 0; i < rawLength; ++i) {
        uInt8Array[i] = raw.charCodeAt(i);
    }

    return new Blob([uInt8Array], {type: contentType});
  }
  
  redimentionner(image, type,maxWidth ,maxHeight,quality)
  {
    var imageWidth = image.width,
    imageHeight = image.height;
    if (imageWidth > imageHeight) 
    {
        if (imageWidth > maxWidth) 
        {
            imageHeight *= maxWidth / imageWidth;
            imageWidth = maxWidth;
        }
    }
    else 
    {
        if (imageHeight > maxHeight) 
        {
            imageWidth *= maxHeight / imageHeight;
            imageHeight = maxHeight;
        }
    }
    var canvas = document.createElement('canvas');
    canvas.width = imageWidth;
    canvas.height = imageHeight;
    image.width = imageWidth;
    image.height = imageHeight;
    var ctx;
    ctx = canvas.getContext("2d");
    ctx.drawImage(image, 0, 0, imageWidth, imageHeight);

    var imageReduit = canvas.toDataURL(type,quality);
    return imageReduit
  }
  
  getMyLocation()
  {
    if (navigator.geolocation) 
    {
        navigator.geolocation.getCurrentPosition((position) =>
        {
          return [position.coords.latitude, position.coords.longitude]
    
        }, (error) =>
        {
          return [0,0];
        });
    }          
    return [0,0];
  }

}
