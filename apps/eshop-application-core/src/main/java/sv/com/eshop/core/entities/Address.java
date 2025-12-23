package sv.com.eshop.core.entities;

import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public class Address {
    
    private String zipCode;
    private String street;
    private String city;
    private String state;
    private String country;

    public Address(String zipCode, String street, String city, String state, String country){
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
        if(o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return 
            Objects.equals(zipCode, address.getZipCode()) && 
            Objects.equals(street, address.getStreet()) &&
            Objects.equals(city, address.getCity()) &&
            Objects.equals(state, address.getState()) &&
            Objects.equals(country, address.getCountry());
    }

    @Override
    public int hashCode(){
        return Objects.hash(zipCode, street, city, state, country);
    }

    @Override
    public String toString(){
        return "zipCode: %s, street: %s, city: %s, state: %s, country: %s".formatted(zipCode, street, city, state, country);
    }
}
