import { Component, inject, signal } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { toSignal } from '@angular/core/rxjs-interop';
import { CatalogItemService } from '../../services/catalog-item/catalog-item.service';
import { BasketService } from '../../services/basket/basket.service';
import { Hero } from '../../components/hero/hero';
import { CatalogItem } from '../../model/catalog-item.model';

@Component({
  selector: 'app-home',
  imports: [CommonModule, CurrencyPipe, Hero],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  private catalogItemService = inject(CatalogItemService);
  private basketService = inject(BasketService);
  catalogItems = toSignal<CatalogItem[], CatalogItem[]>(this.catalogItemService.getCatalogItems(), { initialValue: [] });
  addToCart(id: string){
    console.log(id);
    this.basketService.addItem(id, 1).subscribe();
  }
}
