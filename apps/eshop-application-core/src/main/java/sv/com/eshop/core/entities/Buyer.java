package sv.com.eshop.core.entities;

/* import java.util.ArrayList;
import java.util.List; */
import java.util.UUID;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

public class Buyer implements AggregateRoot<Buyer, Buyer.BuyerIdentifier> {

    private BuyerIdentifier id;
    private String identityGuid; // Guid (Globally Unique Identifier)
    //private List<PaymentMethod> paymentMethods = new ArrayList<>();

    @Override
    public BuyerIdentifier getId() {
        return this.id;
    }

    public String getIdentityGuid() {
        return this.identityGuid;
    }

/*     public List<PaymentMethod> getPaymentMethods() {
        return List.copyOf(this.paymentMethods);
    } */

    public Buyer(String identityGuid) {
        if(identityGuid == null || identityGuid.isBlank()) throw new IllegalArgumentException("IdentityGuid cannot be null or empty");
        this.identityGuid = identityGuid;
    }

    // Requerido por JPA (proxies/reflexión)
    protected Buyer() {}
        
    public static record BuyerIdentifier(UUID id) implements Identifier {};
}
