import { Component, OnInit } from '@angular/core';
import { PublishingHouse } from '../../model/publishing-houses';
import { PublishingHouseService } from '../../service/publishing-house.service';

@Component({
  selector: 'app-publishing-house-list',
  templateUrl: './publishing-house-list.component.html',
  styleUrls: ['./publishing-house-list.component.css'],
})
export class PublishingHouseListComponent implements OnInit {
  publishingHouses: Array<PublishingHouse> = [];

  constructor(private service: PublishingHouseService) {}

  ngOnInit(): void {
    this.service.findAllPublishingHouses().subscribe((publishingHouses) => {
      this.publishingHouses = publishingHouses.publishingHouses;
      console.log(this.publishingHouses.length);
    });
  }
}
