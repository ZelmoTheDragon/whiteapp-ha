package com.github.zelmothedragon.whiteapp.infrastructure.customer;

import com.github.zelmothedragon.whiteapp.infrastructure.AbstractEntity;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.config.PropertyOrderStrategy;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author MOSELLE Maxime
 */
@JsonbPropertyOrder(PropertyOrderStrategy.LEXICOGRAPHICAL)
@Entity
@Table(name = "customer")
public class CustomerEntity extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Size(max = 255)
    @JsonbProperty(value = "email", nillable = false)
    @Column(name = "email", unique = true)
    private String email;

    @Size(max = 255)
    @JsonbProperty(value = "givenName", nillable = false)
    @Column(name = "given_name", nullable = false)
    private String givenName;

    @Size(max = 255)
    @JsonbProperty(value = "familyName", nillable = false)
    @Column(name = "family_name", nullable = false)
    private String familyName;

    public CustomerEntity() {
    }

    public static CustomerEntity of() {
        return new CustomerEntity();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

}
