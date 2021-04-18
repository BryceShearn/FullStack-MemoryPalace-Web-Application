import { Component, OnInit } from '@angular/core';
import { Room } from 'src/app/models/room';
import { FrontEndService } from 'src/app/services/front-end.service';

@Component({
  selector: 'app-front-end-list',
  templateUrl: './front-end-list.component.html',
  styleUrls: ['./front-end-list.component.css']
})
export class FrontEndListComponent implements OnInit {

  rooms: Room[] = [];

  constructor(
    private frontEndService: FrontEndService
  ) { }

  ngOnInit(): void {
    this.loadRooms();
  }

loadRooms(): void {
  this.frontEndService.index().subscribe(
    rooms => {
      this.rooms = rooms;
    },
    fail => {
      console.error('FrontEndListComponent.loadRooms() failed :');
      console.error(fail);
    }
  );
}

}
