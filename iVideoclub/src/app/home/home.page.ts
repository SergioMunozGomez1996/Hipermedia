import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit, OnDestroy {

  constructor() {}
  ngOnInit() {
    console.log('ngOnInit HomePage');
    }
    ionViewWillEnter(){
      console.log('ionViewWillEnter HomePage');
    }
    ionViewDidEnter() {
      console.log('ionViewDidEnter HomePage');
    }
    ionViewWillLeave(){
      console.log('ionViewWillLeave HomePage');
    }
    ionViewDidLeave(){
      console.log('ionViewDidLeave HomePage');
    }
    ngOnDestroy() {
    console.log('ngOnDestroy HomePage');
    }

}
