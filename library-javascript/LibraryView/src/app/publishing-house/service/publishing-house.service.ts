import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { PublishingHouses } from '../model/publishing-houses';
import { PublishingHouse } from '../model/publishing-house';

@Injectable({ providedIn: 'root' })
export class PublishingHouseService {
  constructor(private http: HttpClient) {}

  update(publishingHouse: PublishingHouse) {
    return this.http.patch<void>(
      `http://172.17.0.1:8084/api/publishing-houses/${publishingHouse.id}`,
      publishingHouse
    );
  }

  createNew(publishingHouse: PublishingHouse) {
    return this.http.put<void>(
      `http://172.17.0.1:8084/api/publishing-houses/${publishingHouse.id}`,
      publishingHouse
    );
  }

  findPublishingHouse(id: String) {
    return this.http.get<PublishingHouse>(
      `http://172.17.0.1:8084/api/publishing-houses/${id}`
    );
  }

  deletePublishingHouse(id: String) {
    return this.http.delete<void>(
      `http://172.17.0.1:8084/api/publishing-houses/${id}`
    );
  }

  findAllPublishingHouses(): Observable<PublishingHouses> {
    return this.http.get<PublishingHouses>(
      'http://172.17.0.1:8084/api/publishing-houses'
    );
  }
}
