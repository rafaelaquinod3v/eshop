package sv.com.eshop.core;

public final class PageQuery {
    private final int page;
    private final int size;

    public PageQuery(int page, int size) {
        if(page < 0) throw new IllegalArgumentException("La pagina no puede ser negativa");
        if(size <= 0) throw new IllegalArgumentException("El tamaño debe ser mayor a cero");
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return this.page;
    }

    public int getSize() {
        return this.size;
    }
}
