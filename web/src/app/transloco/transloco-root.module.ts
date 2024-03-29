import {HttpClient} from "@angular/common/http";
import {Injectable, NgModule} from "@angular/core";
import {environment} from "../../environments/environment.prod";
import {
  Translation,
  TRANSLOCO_CONFIG,
  TRANSLOCO_LOADER,
  translocoConfig,
  TranslocoLoader,
  TranslocoModule
} from "@ngneat/transloco";

@Injectable({providedIn: 'root'})
export class TranslocoHttpLoader implements TranslocoLoader {
  constructor(private http: HttpClient) {}

  getTranslation(lang: string) {
    return  this.http.get<Translation>(`/assets/i18n/${lang}.json`);
  }
}
@NgModule({
  exports: [TranslocoModule],
  providers: [
    {
      provide: TRANSLOCO_CONFIG,
      useValue: translocoConfig({
        availableLangs: ['en'],
        defaultLang: 'en',
        reRenderOnLangChange: true,
        prodMode: environment.production,
        missingHandler: {
          allowEmpty: false,
          logMissingKey: false
        }
      })
    },
    { provide: TRANSLOCO_LOADER, useClass: TranslocoHttpLoader },
  ]
})
export class TranslocoRootModule {}
