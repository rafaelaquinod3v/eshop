package sv.com.eshop.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sv.com.eshop.core.entities.Address;

@DisplayName("Address Value Object (VO) Test")
public class AddressTest {

    @Nested
    @DisplayName("Constructor and Validation")
    class Validation {
        @Test
        @DisplayName("Should create a valid address when all required fields are provided")
        void createValidAddress() {
            Address address = new Address("50301", "Av. Roosvelt", "San Salvador", "SS", "SV");

            assertThat(address).isNotNull();
            assertThat(address.getZipCode()).isEqualTo("50301");
            assertThat(address.getStreet()).isEqualTo("Av. Roosvelt");
            assertThat(address.getCity()).isEqualTo("San Salvador");
        }

        @ParameterizedTest
        @CsvSource({
            ", Street, City",
            "50301, , City",
            "50301, Street, "
        })
        @DisplayName("Should throw IllegalArgumentException when required fields are missing")
        void throwExceptionWhenFieldsAreMissing(String zipCode, String street, String city) {
            assertThatThrownBy(() -> new Address(zipCode, street, city, "State", "Country")).isExactlyInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("Value Equality (DDD Principles)")
    class Equality {

        @Test
        @DisplayName("Two addresses with same values should be equal")
        void equalityTest() {
            Address address1 = new Address("12345", "Main St", "NY", "NY", "USA");
            Address address2 = new Address("12345", "Main St", "NY", "NY", "USA");

            assertThat(address1).isEqualTo(address2);
            assertThat(address1.hashCode()).isEqualTo(address2.hashCode());
        }
    }

    
}
