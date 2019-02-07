import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  public static addBaseAddress(endpoint: string): string {
    return environment.apiBaseUri + endpoint;
  }

  constructor() { }
}
