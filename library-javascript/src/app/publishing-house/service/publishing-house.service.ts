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
      `/api/publishing-houses/${publishingHouse.id}`,
      publishingHouse
    );
  }

  createNew(publishingHouse: PublishingHouse) {
    return this.http.put<void>(
      `/api/publishing-houses/${publishingHouse.id}`,
      publishingHouse
    );
  }

  findPublishingHouse(id: String) {
    return this.http.get<PublishingHouse>(
      `/api/publishing-houses/${id}`
    );
  }

  deletePublishingHouse(id: String) {
    return this.http.delete<void>(
      `/api/publishing-houses/${id}`
    );
  }

  findAllPublishingHouses(): Observable<PublishingHouses> {
    return this.http.get<PublishingHouses>(
      '/api/publishing-houses'
    );
  }
}
