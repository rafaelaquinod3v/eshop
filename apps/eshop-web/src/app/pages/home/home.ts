import { Component, signal, computed, inject } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { CatalogItemService } from '../../services/catalog-item/catalog-item.service';
import { BasketService } from '../../services/basket/basket.service';
import { Hero } from '../../components/hero/hero';
import { CatalogItem } from '../../model/catalog-item.model';
import { toSignal, toObservable } from '@angular/core/rxjs-interop';
import { switchMap } from 'rxjs/operators';
import { PaginatedResponse } from '../../dto/PaginatedResponse';

@Component({
  selector: 'app-home',
  imports: [CommonModule, CurrencyPipe, Hero],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {

  private catalogItemService = inject(CatalogItemService);
  private basketService = inject(BasketService);
  // 1. Define los parámetros como señales
  page = signal(0);
  FIRST_PAGE_INDEX = signal(0);
  size = signal(4);
  isLast = false;
  isFirst = true;

  // toSignal solo convierte un Observable estático en un Signal
  // catalogItems = toSignal<CatalogItem[], CatalogItem[]>(this.catalogItemService.getCatalogItems(), { initialValue: [] });
  addToCart(id: string){
    console.log(id);
    this.basketService.addItem(id, 1).subscribe();
  }

  /*  
    Para que los datos se recarguen cuando cambien la página o el tamaño, 
    debes usar un patrón reactivo combinando toObservable y switchMap
  */
  // 2. Crea un objeto combinado de parámetros (opcional, ayuda a la legibilidad)
  params$ = toObservable(computed(() => ({ 
    page: this.page(), 
    size: this.size() 
  })));


/*   catalogItemsReactive = toSignal(
    this.params$.pipe(
      switchMap(p => this.catalogItemService.getItems(p.page, p.size))
    ),
    { initialValue: [] as CatalogItem[] }
  ); */
  
  // Método para cambiar de página
  changePage(delta: number) {
    this.page.update(p => p + delta);
  }

  // 3. Usa switchMap para llamar al servicio cada vez que los parámetros cambien
  // Cargamos el objeto completo usando toSignal
  // Se asume que page y size son señales como en el ejemplo anterior
  private dataResponse = toSignal(
    toObservable(computed(() => ({ page: this.page(), size: this.size() }))).pipe(
      switchMap(p => this.catalogItemService.getItemsPaginatedResponse(p.page, p.size))
    ),
    { initialValue: { items: [], totalPages: 0, totalElements: 0 } as PaginatedResponse<CatalogItem> }
  );

  // 2. Extraemos la lista de ítems (reactiva)
  items = computed(() => this.dataResponse().items);

  // 3. Extraemos los metadatos (reactiva)
  totalPages = computed(() => this.dataResponse().totalPages);
  totalElements = computed(() => this.dataResponse().totalElements);
  LAST_PAGE_INDEX = computed(() => this.dataResponse().totalPages - 1);

}
