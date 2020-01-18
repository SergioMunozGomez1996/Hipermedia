import { Component, OnInit, OnDestroy} from '@angular/core';

@Component({
  selector: 'app-curriculum',
  templateUrl: './curriculum.page.html',
  styleUrls: ['./curriculum.page.scss'],
})
export class CurriculumPage implements OnInit, OnDestroy {

  listaTrabajos: {fecha: string, desc: string}[];

  constructor() {
    this.listaTrabajos = [{fecha: '2010-actualidad', desc: 'Profesor del Máster Universitario en Desarrollo de Software para Dispositivos Móviles'},
     {fecha: '2015-actualidad', desc: 'Profesor del Máster Universitario en Desarrollo de Aplicaciones y Servicios Web'},
    {fecha: '2008-2010', desc:'Sexador de pollos'}]
   }

  ngOnInit() {
    console.log('ngOnInit CurriculumPage');
    }
    ionViewWillEnter(){
      console.log('ionViewWillEnter CurriculumPage');
    }
    ionViewDidEnter() {
      console.log('ionViewDidEnter CurriculumPage');
    }
    ionViewWillLeave(){
      console.log('ionViewWillLeave CurriculumPage');
    }
    ionViewDidLeave(){
      console.log('ionViewDidLeave CurriculumPage');
    }
    ngOnDestroy() {
    console.log('ngOnDestroy CurriculumPage');
    }

}
