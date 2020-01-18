import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PeliculasAPIService {

  APIep = 'http://gbrain.dlsi.ua.es/videoclub/api/v1/catalog';

  constructor(public http: HttpClient) { }

  getPeliculas(): any {
    return this.http.get(this.APIep);
  }

  getPelicula(id): any {
    return this.http.get(this.APIep + '/' + id);
  }
}
