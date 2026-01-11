package sv.com.eshop.core;

import java.util.List;

public final class PagedResult<T> {
    private final List<T> items;
    private final long totalElements;
    private final int totalPages;

    public PagedResult(List<T> items, long totalElements, int pageSize) {
        this.items = List.copyOf(items);
        this.totalElements = totalElements;
        this.totalPages = (int) Math.ceil((double) totalElements / pageSize );
    }

    public List<T> getItems() {
        return this.items;
    }

    public long getTotalElements() {
        return this.totalElements;
    }

    public int getTotalPages() {
        return this.totalPages;
    }
}
