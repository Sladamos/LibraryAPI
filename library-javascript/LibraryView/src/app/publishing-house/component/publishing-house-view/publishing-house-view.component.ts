import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PublishingHouse } from '../../model/publishing-house';
import { PublishingHouseService } from '../../service/publishing-house.service';

@Component({
  selector: 'app-publishing-house-view',
  templateUrl: './publishing-house-view.component.html',
  styleUrls: ['./publishing-house-view.component.css'],
})
export class PublishingHouseViewComponent implements OnInit {
  publishingHouse: PublishingHouse = new PublishingHouse();
  id: String = '';

  constructor(
    private route: ActivatedRoute,
    private service: PublishingHouseService,
    private router: Router
  ) {
    this.route.params.subscribe((params) => (this.id = params['id']));
  }

  ngOnInit(): void {
    this.service.findPublishingHouse(this.id).subscribe((publishingHouse) => {
      this.publishingHouse = publishingHouse;
      //get books
    });
  }

  onDelete(id: String): void {
    this.service.deletePublishingHouse(id).subscribe((el) => {
      this.router.navigate(['./publishing-houses']);
    });
  }
}
