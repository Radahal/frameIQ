import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";

const routes: Routes = [
  { path: 'dashboard',
    loadChildren: () =>
      import("./dashboard/dashboard.module").then(({DashboardModule}) => DashboardModule),
  },
  { path: 'projects',
    loadChildren: () =>
      import("./project/project.module").then(({ProjectModule}) => ProjectModule),
  },
  { path: 'projects/:projectId/configurations',
    loadChildren: () =>
      import("./configuration/configuration.module").then(({ConfigurationModule}) => ConfigurationModule),
  },
  { path: 'projects/:projectId/configurations/:configurationId/blueprints',
    loadChildren: () =>
      import("./blueprint/blueprint.module").then(({BlueprintModule}) => BlueprintModule),
  },
  { path: 'processings',
    loadChildren: () =>
      import("./processing/processing.module").then(({ProcessingModule}) => ProcessingModule),
  },
  {
    path: '**',
    redirectTo: 'dashboard',
    pathMatch: 'full'
  },
]

@NgModule({
  imports: [RouterModule.forRoot(routes, {scrollPositionRestoration: 'enabled'})],
  exports: [RouterModule]
})
export class AppRoutingModule {}
