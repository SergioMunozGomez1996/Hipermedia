import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PeliculasAPIService } from '../services/peliculas-api.service';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.page.html',
  styleUrls: ['./detalle.page.scss'],
})
export class DetallePage implements OnInit {
  id: any;
  pelicula: any;
  constructor(private activatedRoute: ActivatedRoute, private peliculasAPIService: PeliculasAPIService) {}

  ngOnInit() {
    this.id = this.activatedRoute.snapshot.paramMap.get('id');
    console.log(this.id)
    this.peliculasAPIService.getPelicula(this.id).subscribe(
      result => {
        this.pelicula = result;
      },
      err => {
        console.log(err);
     }
  );
  }

}
