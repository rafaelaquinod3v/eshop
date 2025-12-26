package sv.com.eshop.core.entities;

import java.util.UUID;

import org.jmolecules.ddd.types.Identifier;

public class Buyer {
    
    public static record BuyerIdentifier(UUID id) implements Identifier {};
}
