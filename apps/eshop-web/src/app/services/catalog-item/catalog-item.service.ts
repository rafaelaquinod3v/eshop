import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CatalogItem } from '../../model/catalog-item.model';

@Injectable({
  providedIn: 'root',
})
export class CatalogItemService {
  private http = inject(HttpClient);
  private apiUrl = "http://localhost:8080/api";

  getCatalogItems() {
    return this.http.get<CatalogItem[]>(`${this.apiUrl}/catalog-items`);
  }
}
