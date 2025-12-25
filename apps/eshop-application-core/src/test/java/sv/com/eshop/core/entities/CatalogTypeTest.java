package sv.com.eshop.core.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CatalogTypeTest {
     
    @Test
    @DisplayName("Should create a CatalogType with a valid ID and type")
    void shouldCreateCatalogType() {
        String expectedType = "ELECTRONICS";
        CatalogType catalogType = CatalogType.create(expectedType);

        assertThat(catalogType.getId()).isNotNull();
        assertThat(catalogType.getId().id()).isNotNull(); //Valids internal UUID
        assertThat(catalogType.getType()).isEqualTo(expectedType);
    }

    @Test
    @DisplayName("Each CatalogType should have a unique identifier")
    void sholdHaveUniqueIdentifier() {
        CatalogType catalogType1 = CatalogType.create("BOOKS");
        CatalogType catalogType2 = CatalogType.create("BOOKS");

        assertThat(catalogType1.getId()).isNotEqualTo(catalogType2.getId());
    }

    @Test
    @DisplayName("CatalogType cannot be empty")
    void shouldThrowExceptionWhenTypeIsInvalid() {
        assertThatThrownBy(() -> CatalogType.create("")).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
