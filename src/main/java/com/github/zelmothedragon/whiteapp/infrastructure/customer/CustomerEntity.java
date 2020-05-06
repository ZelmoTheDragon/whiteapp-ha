package com.github.zelmothedragon.whiteapp.infrastructure.customer;

import com.github.zelmothedragon.whiteapp.infrastructure.AbstractEntity;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.spi.CDI;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author MOSELLE Maxime
 */
@Dependent
@Entity
public class CustomerEntity extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Size(max = 255)
    @Column(name = "email", unique = true)
    private String email;

    @Size(max = 255)
    @Column(name = "given_name")
    private String givenName;

    @Size(max = 255)
    @Column(name = "family_name")
    private String familyName;

    public CustomerEntity() {
    }

    public static CustomerEntity of() {
        return CDI.current().select(CustomerEntity.class).get();
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
