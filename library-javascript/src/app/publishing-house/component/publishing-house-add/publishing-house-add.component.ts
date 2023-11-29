import { v4 as uuidv4 } from 'uuid';
import { Component } from '@angular/core';
import { PublishingHouse } from '../../model/publishing-house';
import { PublishingHouseService } from '../../service/publishing-house.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-publishing-house-add',
  templateUrl: './publishing-house-add.component.html',
  styleUrls: ['./publishing-house-add.component.css'],
})
export class PublishingHouseAddComponent {
  name: String = '';
  creationYear: number = 0;

  constructor(
    private service: PublishingHouseService,
    private router: Router
  ) {}

  onClickSubmit() {
    if (this.name != '' && this.creationYear > 0)
      this.service
        .createNew(new PublishingHouse(uuidv4(), this.name, this.creationYear))
        .subscribe((el) => {
          this.router.navigate(['./publishing-houses']);
        });
    else {
      window.alert('WROOOOOOOONG');
    }
  }
}
