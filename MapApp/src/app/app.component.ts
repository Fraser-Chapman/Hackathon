import { Component, OnInit } from '@angular/core';
import { MouseEvent } from '@agm/core';
import { LikelihoodService } from './LikelihoodService';
import { LatLong } from './Models/coordinates';
import { likelihoodIndicator } from './Models/likelihoodIndicator';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  private latLong : LatLong;
  private marker: marker;
  likeLihoodIndicator: likelihoodIndicator = {likelihood: null};

  constructor(private likelihoodService: LikelihoodService) { }
 
   // google maps zoom level
   zoom: number = 11;
  
   // initial center position for the map
   lat: number = 53.483959;
   lng: number = -2.244644;   
 
   clickedMarker(label: string, index: number) {
     console.log(`clicked the marker: ${label || index}`)     
   }
   
   mapClicked($event: MouseEvent) {
    
    this.marker = {
       lat: $event.coords.lat,
       lng: $event.coords.lng,
       label: 'Location',
       draggable: false 
    }

    this.markers.push(this.marker);
    
    this.latLong = {
      lat: this.marker.lat,
      long: this.marker.lng
    }
    console.log('request sending');

    this.likelihoodService.sendLatLong(this.latLong).subscribe(response =>
      {
        console.log("got response: ");
        console.log(response);
        this.likeLihoodIndicator.likelihood = response;
      });
    
   }

   returnLikihood(likelihood: likelihoodIndicator) {
    
   }
   
   markerDragEnd(m: marker, $event: MouseEvent) {
     console.log('dragEnd', m, $event);
   }
   
   markers: marker[] = []
 }
 
 // just an interface for type safety.
 interface marker {
   lat: number;
   lng: number;
   label?: string;
   draggable: boolean;
 }

