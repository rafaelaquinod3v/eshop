package sv.com.eshop.core.entities;

import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public class PaymentMethod {
    
    private final String alias;
    private final String cardId; // actual card data must be stored in a PCI compliant system, like Stripe
    private final String last4;

    public String getAlias() {
        return this.alias;
    }

    public String getCardId() {
        return this.cardId;
    }

    public String getLast4() {
        return this.last4;
    }

    public PaymentMethod(String alias, String cardId, String last4) {
        if(last4 == null || last4.length() != 4) throw new IllegalArgumentException("Last4 must be 4 digits");
        this.alias = alias;
        this.cardId = cardId;
        this.last4 = last4;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return  true;
        if(!(o instanceof PaymentMethod that)) return false;
        return 
            Objects.equals(this.alias, that.getAlias()) &&
            Objects.equals(this.cardId, that.getCardId()) &&
            Objects.equals(this.last4, that.getLast4());
    }

    @Override
    public int hashCode() {
        return  Objects.hash(this.alias, this.cardId, this.last4);
    }
}
