package sv.com.eshop.core.entities;

import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public class Address {
    
    private final String zipCode;
    private final String street;
    private final String city;
    private final String state;
    private final String country;

    public Address(String zipCode, String street, String city, String state, String country){
        if(zipCode == null || zipCode.isBlank()) throw new IllegalArgumentException("zipCode cannot be null or empty");
        if(street == null || street.isBlank()) throw new IllegalArgumentException("street cannot be null or empty");
        if(city == null || city.isBlank()) throw new IllegalArgumentException("city cannot be null or empty");
        this.zipCode = zipCode;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getZipCode(){
        return this.zipCode;
    }

    public String getStreet(){
        return this.street;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }

    public String getCountry(){
        return this.country;
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o) return  true;
        if(!(o instanceof Address that)) return false;
        return 
            Objects.equals(this.zipCode, that.getZipCode()) && 
            Objects.equals(this.street, that.getStreet()) &&
            Objects.equals(this.city, that.getCity()) &&
            Objects.equals(this.state, that.getState()) &&
            Objects.equals(this.country, that.getCountry());
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.zipCode, this.street, this.city, this.state, this.country);
    }

    @Override
    public String toString() {
        return "Address[zipCode='%s', street='%s', city='%s', state='%s', country='%s']"
               .formatted(this.zipCode, this.street, this.city, this.state, this.country);
    }
}
