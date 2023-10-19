import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { PublishingHouses } from '../model/publishing-houses';

@Injectable({ providedIn: 'root' })
export class PublishingHouseService {
  constructor(private http: HttpClient) {}

  findAllPublishingHouses(): Observable<PublishingHouses> {
    return this.http.get<PublishingHouses>(
      'http://172.17.0.1:8084/api/publishing-houses'
    );
  }
}
