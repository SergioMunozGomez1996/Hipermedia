import { Component, OnInit, OnDestroy} from '@angular/core';
import { Router } from '@angular/router';
import { PeliculasAPIService } from '../services/peliculas-api.service';


@Component({
  selector: 'app-videoclub',
  templateUrl: './videoclub.page.html',
  styleUrls: ['./videoclub.page.scss'],
})
export class VideoclubPage implements OnInit, OnDestroy {

  listaPeliculas: any[];

  modoLista: boolean;

  constructor(private router: Router, private peliculasAPIService: PeliculasAPIService) {
    peliculasAPIService.getPeliculas().subscribe(
      result => {
        this.listaPeliculas = result;
      },
      err => {
        console.log(err);
     }
);
    this.modoLista = true;
   }

  ngOnInit() {
    console.log('ngOnInit VideoclubPage');
    }
    ionViewWillEnter(){
      console.log('ionViewWillEnter VideoclubPage');
    }
    ionViewDidEnter() {
      console.log('ionViewDidEnter VideoclubPage');
    }
    ionViewWillLeave(){
      console.log('ionViewWillLeave VideoclubPage');
    }
    ionViewDidLeave(){
      console.log('ionViewDidLeave VideoclubPage');
    }
    ngOnDestroy() {
    console.log('ngOnDestroy VideoclubPage');
    }

    verPaginaDetalle(id): void {
      this.router.navigate(['/detalle', id]);
    }

    cambiarVista(){
      if(this.modoLista == true){
        this.modoLista = false;
      }else{
        this.modoLista = true;
      }
    }
   

}
