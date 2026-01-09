import { Component } from '@angular/core';
import { Hero } from '../../components/hero/hero';
@Component({
  selector: 'app-cart',
  imports: [Hero],
  templateUrl: './cart.html',
  styleUrl: './cart.css',
})
export class Cart {}
