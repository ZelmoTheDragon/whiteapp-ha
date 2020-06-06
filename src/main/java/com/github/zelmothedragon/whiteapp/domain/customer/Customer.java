package com.github.zelmothedragon.whiteapp.domain.customer;

import com.github.zelmothedragon.whiteapp.domain.util.lang.Equals;
import com.github.zelmothedragon.whiteapp.domain.util.lang.ToString;
import com.github.zelmothedragon.whiteapp.domain.util.validation.Constraint;
import com.github.zelmothedragon.whiteapp.domain.util.validation.Validator;
import java.util.Objects;

/**
 *
 * @author MOSELLE Maxime
 * 
 */
public final class Customer {

    public static final Customer EMPTY = new Customer(Email.EMPTY, "", "");

    private final Email email;

    private final String givenName;

    private final String familyName;

    private Customer(
            final Email email,
            final String givenName,
            final String familyName) {

        this.email = email;
        this.givenName = givenName;
        this.familyName = familyName;
    }

    public static Customer of(
            final Email email,
            final String givenName,
            final String familyName) {

        var entity = new Customer(email, givenName, familyName);
        return Validator
                .of(entity)
                .validate(Customer::getEmail, Constraint::notNull, "email", Constraint.MESSAGE_NOT_NULL)
                .validate(Customer::getEmail, Constraint.notEquals(Email.EMPTY), "email", Constraint.MESSAGE_NOT_EMPTY_OBJECT)
                .validate(Customer::getGivenName, Constraint::notEmpty, "givenName", Constraint.MESSAGE_NOT_EMPTY)
                .validate(Customer::getFamilyName, Constraint::notEmpty, "familyName", Constraint.MESSAGE_NOT_EMPTY)
                .get();
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, givenName, familyName);
    }

    @Override
    public boolean equals(final Object obj) {
        return Equals
                .with(Customer::getEmail)
                .thenWith(Customer::getGivenName)
                .thenWith(Customer::getFamilyName)
                .apply(this, obj);
    }

    @Override
    public String toString() {
        return ToString
                .with("email", Customer::getEmail)
                .thenWith("givenName", Customer::getGivenName)
                .thenWith("familyName", Customer::getFamilyName)
                .apply(this);
    }

    public Customer withEmail(final Email email) {
        return Customer.of(email, givenName, familyName);
    }

    public Customer withGivenName(final String givenName) {
        return Customer.of(email, givenName, familyName);
    }

    public Customer withFamilyName(final String familyName) {
        return Customer.of(email, givenName, familyName);
    }

    public Email getEmail() {
        return email;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

}
