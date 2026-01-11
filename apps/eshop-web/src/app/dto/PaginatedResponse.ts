export interface PaginatedResponse<T> {
  items: T[];
  totalPages: number;
  totalElements: number;
  // Otros campos que devuelva tu API
}