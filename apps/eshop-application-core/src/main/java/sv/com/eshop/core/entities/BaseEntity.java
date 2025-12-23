package sv.com.eshop.core.entities;

public abstract class BaseEntity {
    protected int id;

    public int getId() {
        return id;
    }
    
    protected void setId(int id){
        this.id = id;
    }
}
