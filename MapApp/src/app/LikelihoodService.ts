import { Injectable } from '@angular/core';
import { LatLong } from './Models/coordinates';
import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/internal/operators';
import { ConfigService } from './config.service';
import { likelihoodIndicator } from './Models/likelihoodIndicator';

@Injectable({
  providedIn: 'root'
})
export class LikelihoodService {  
  private apiEndpoint = ConfigService.addBaseAddress('api/carpark/getlikelihood');

  constructor(private http: HttpClient) { }

  sendLatLong(model: LatLong) : any {
    console.log("request part 2");

const url = this.apiEndpoint + '?lat=' + model.lat.toString() + '&long=' + model.long.toString();

    console.log(url);
    return this.http.get(url)
    .pipe(map((response: any) => {
      console.log(response);
      return response}), catchError(this.handleError));
  }

  private handleError(response: HttpErrorResponse) {
    console.error(response.message);
    return throwError(response.error + ', ' + response.message);
  } 
}
