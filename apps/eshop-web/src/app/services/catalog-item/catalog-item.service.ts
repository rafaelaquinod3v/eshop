import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CatalogItem } from '../../model/catalog-item.model';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CatalogItemService {
  private http = inject(HttpClient);
  private apiUrl = "http://localhost:8080/api";

  getCatalogItems() {
    return this.http.get<any[]>(`${this.apiUrl}/catalog-items`).pipe(
      map(items => items.map(item => ({
        ...item,
        id: (typeof item.id === 'object' && item.id !== null) ? String(item.id.id) : String(item.id)
      } as CatalogItem)))
    );
  }
}
