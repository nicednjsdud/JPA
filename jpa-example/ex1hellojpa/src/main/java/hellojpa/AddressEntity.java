package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AddressEntity {

    @Id
    private Long id;

    private Address address;

    public AddressEntity(Address address) {
        this.address=address;
    }

    public AddressEntity(String city, String street, String zipcode) {
        this.address = new Address(city, street, zipcode);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
