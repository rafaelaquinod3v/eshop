package sv.com.eshop.core.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CatalogTypeTest {
     
    @Test
    @DisplayName("Should create a CatalogType with a valid ID and type")
    void shouldCreateCatalogType() {
        String expectedType = "ELECTRONICS";
        CatalogType catalogType = new CatalogType(expectedType);

        assertThat(catalogType.getId()).isNotNull();
        assertThat(catalogType.getId().id()).isNotNull(); //Valids internal UUID
        assertThat(catalogType.getType()).isEqualTo(expectedType);
    }
}
