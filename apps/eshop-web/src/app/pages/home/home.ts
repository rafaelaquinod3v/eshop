import { Component, inject } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { toSignal } from '@angular/core/rxjs-interop';
import { CatalogItemService } from '../../services/catalog-item/catalog-item.service';

@Component({
  selector: 'app-home',
  imports: [CommonModule, CurrencyPipe],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  private catalogItemService = inject(CatalogItemService);
  catalogItems = toSignal(this.catalogItemService.getCatalogItems(), { initialValue: [] });
}
