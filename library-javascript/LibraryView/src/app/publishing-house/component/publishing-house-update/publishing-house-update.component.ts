import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PublishingHouse } from '../../model/publishing-house';
import { PublishingHouseService } from '../../service/publishing-house.service';

@Component({
  selector: 'app-publishing-house-update',
  templateUrl: './publishing-house-update.component.html',
  styleUrls: ['./publishing-house-update.component.css'],
})
export class PublishingHouseUpdateComponent implements OnInit {
  id: String = '';
  name: String = '';
  creationYear: number = 0;

  constructor(
    private service: PublishingHouseService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.route.params.subscribe((params) => (this.id = params['id']));
  }

  ngOnInit(): void {
    try {
      this.service.findPublishingHouse(this.id).subscribe((house) => {
        this.id = house.id;
        this.name = house.name;
        this.creationYear = house.creationYear;
      });
    } catch (error) {
      window.alert('BAD ID');
    }
  }

  onClickSubmit() {
    if (this.name != '' && this.creationYear > 0) {
      this.service
        .update(new PublishingHouse(this.id, this.name, this.creationYear))
        .subscribe((el) => {
          this.router.navigate([`./publishing-houses/${this.id}/content`]);
        });
    } else {
      window.alert('WROOOOOOOONG');
    }
  }
}
