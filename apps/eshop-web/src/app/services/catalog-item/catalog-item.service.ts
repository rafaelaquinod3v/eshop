import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CatalogItem } from '../../model/catalog-item.model';
import { map, Observable } from 'rxjs';
import { PaginatedResponse } from '../../dto/PaginatedResponse';

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

  // recibe un arreglo con los items
  getItems(page: number, size: number) {
    return this.http.get<any>(`${this.apiUrl}/items?page=${page}&size=${size}`).pipe(
      map(response => {
         // 1. Accedes a la lista dentro del objeto (ej: response.items)
        const list: any[] = response.items || [];
        // 2. Mapeas cada elemento individual como lo hacías antes
        return list.map(item => ({
          ...item,
          id: (typeof item.id === 'object' && item.id !== null) ? String(item.id.id) : String(item.id)
        } as CatalogItem));
      })
    );
  }

  // recibe un objecto con los items como una de las propiedades
  getItemsPaginatedResponse(page: number, size: number): Observable<PaginatedResponse<CatalogItem>> {
    return this.http.get<any>(`${this.apiUrl}/items?page=${page}&size=${size}`).pipe(
      map(response => ({
        ...response, // Mantiene totalPages, totalElements, etc.
        items: (response.items || []).map((item: any) => ({
          ...item,
          id: (typeof item.id === 'object' && item.id !== null) ? String(item.id.id) : String(item.id)
        } as CatalogItem))
      }))
    );
  }

  
  
}
