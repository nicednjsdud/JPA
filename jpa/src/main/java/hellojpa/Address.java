package hellojpa;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {

    private String address;
    private String city;
    private String zipcode;

    protected Address(){}
    public Address(String address, String city, String zipcode) {
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(getAddress(), address1.getAddress()) && Objects.equals(getCity(), address1.getCity()) && Objects.equals(getZipcode(), address1.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getCity(), getZipcode());
    }
}
