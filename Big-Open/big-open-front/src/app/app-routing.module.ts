import { NgModule } from '@angular/core';
import { RouterModule,Routes} from '@angular/router'
import { MainComponent } from './shared/layout/main/main.component';
import { RouteGuardService } from './services/route-guard.service';
import { LoginComponent } from './shared/login/login.component';
import { AccueilleComponent } from './components/accueille/accueille.component';

const routes: Routes = 
[
   {
    path: '', component: MainComponent,
    children: 
    [
        {
            path: '', 
            pathMatch: 'full',
            redirectTo : "accueille",
        },
        {
            path: 'accueille', 
            canActivate : [RouteGuardService],
            component: AccueilleComponent
        }     
    ]
  },
//   {
//       path: 'article', component: MainComponent,
//       children: 
//       [
//           {
//               path: "formulaire", 
//               canActivate : [RouteGuardService],
//               component: ArticleFormComponent
//           },
//           {
//               path: 'liste', 
//               canActivate : [RouteGuardService],
//               component: ArticleListComponent
//           },
//           {
//             path: "formulaire/:id", 
//             canActivate : [RouteGuardService],
//             component: ArticleFormComponent
//         }
        
//       ]
//   },
  {path:'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{scrollPositionRestoration: 'enabled', anchorScrolling:'enabled'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
