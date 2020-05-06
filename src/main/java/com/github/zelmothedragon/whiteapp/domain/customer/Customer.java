package com.github.zelmothedragon.whiteapp.domain.customer;

import com.github.zelmothedragon.whiteapp.domain.util.validation.Constraint;
import com.github.zelmothedragon.whiteapp.domain.util.validation.Validator;
import java.util.Objects;

/**
 *
 * @author MOSELLE Maxime
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
                .validate(Customer::getEmail, Constraint::notNull, Constraint.MESSAGE_NOT_NULL)
                .validate(Customer::getEmail, Constraint.notEquals(Email.EMPTY), Constraint.MESSAGE_NOT_EMPTY_OBJECT)
                .validate(Customer::getGivenName, Constraint::notNull, Constraint.MESSAGE_NOT_NULL)
                .validate(Customer::getFamilyName, Constraint::notNull, Constraint.MESSAGE_NOT_NULL)
                .get();
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, givenName, familyName);
    }

    @Override
    public boolean equals(final Object obj) {
        final boolean eq;
        if (this == obj) {
            eq = true;
        } else if (!(obj instanceof Customer)) {
            eq = false;
        } else {
            final var other = (Customer) obj;
            eq = Objects.equals(email, other.email)
                    && Objects.equals(givenName, other.givenName)
                    && Objects.equals(familyName, other.familyName);
        }
        return eq;
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
