import { Route } from '@angular/router';
import { MainLayout } from './components/main-layout/main-layout';

export const appRoutes: Route[] = [
    {
        path: '',
        component: MainLayout,
        children: [
            {
                path: '',
                loadComponent: () => import('./pages/home/home').then(m => m.Home)
            },
            {
                path: 'login',
                loadComponent: () => import('./pages/login/login').then(m => m.Login)
            },
                        {
                path: 'basket',
                loadComponent: () => import('./pages/cart/cart').then(m => m.Cart)
            }
        ]
    }
];
