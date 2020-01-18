import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-autor',
  templateUrl: './autor.page.html',
  styleUrls: ['./autor.page.scss'],
})
export class AutorPage implements OnInit, OnDestroy {

  autor: {
    name: string,
    email: string,
    twitter: string,
    phone: string
  };

  constructor() {
    this.autor = {name: 'Sergio', email: 'sergio@email.com', twitter: 'sergioTwitter', phone: '666555444'};
   }

  ngOnInit() {
    console.log('ngOnInit AutorPage');
    }
    ionViewWillEnter(){
      console.log('ionViewWillEnter AutorPage');
    }
    ionViewDidEnter() {
      console.log('ionViewDidEnter AutorPage');
    }
    ionViewWillLeave(){
      console.log('ionViewWillLeave AutorPage');
    }
    ionViewDidLeave(){
      console.log('ionViewDidLeave AutorPage');
    }
    ngOnDestroy() {
    console.log('ngOnDestroy AutorPage');
    }

}
