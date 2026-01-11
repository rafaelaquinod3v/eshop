package sv.com.eshop.core;

import java.util.UUID;
import java.util.function.Function;
import org.jmolecules.ddd.types.Identifier;

public interface DomainIdentifier extends Identifier {

    static <T extends DomainIdentifier> T from(Class<T> clazz, Function<UUID, T> constructor, String uuid) {
        try {
            return constructor.apply(UUID.fromString(uuid));
        }catch(RuntimeException e) {
            throw new IllegalArgumentException("Formato de " + clazz.getSimpleName() + " invalido: " + uuid);
        }
    }

}
