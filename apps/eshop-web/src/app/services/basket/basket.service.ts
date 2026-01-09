import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AddItemRequest } from '../../dto/addItemRequest';
@Injectable({
  providedIn: 'root',
})
export class BasketService {

  private http = inject(HttpClient);
  private readonly API_URL = 'http://localhost:8080/api';

  addItem(catalogItemId: String, units: number): Observable<any> {
    const body: AddItemRequest = { catalogItemId, units };
    
    return this.http.post<any>(`${this.API_URL}/basket/items`, body, { withCredentials: true });
  }

}
