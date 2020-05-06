package com.github.zelmothedragon.whiteapp.domain.customer;

import com.github.zelmothedragon.whiteapp.domain.util.validation.Constraint;
import com.github.zelmothedragon.whiteapp.domain.util.validation.Validator;
import java.util.Objects;

/**
 *
 * @author MOSELLE Maxime
 */
public final class Email {

    public static final Email EMPTY = new Email("");

    private final String email;

    private Email(final String email) {
        this.email = email;
    }

    public static Email of(final String email) {
        var entity = new Email(email);
        return Validator
                .of(entity)
                .validate(Email::getEmail, Constraint::notEmpty, Constraint.MESSAGE_NOT_EMPTY)
                .validate(Email::getEmail, Constraint::isEmailValid, Constraint.MESSAGE_INVALID_EMAIL)
                .get();
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public boolean equals(final Object obj) {
        final boolean eq;
        if (this == obj) {
            eq = true;
        } else if (!(obj instanceof Email)) {
            eq = false;
        } else {
            final var other = (Email) obj;
            eq = Objects.equals(email, other.email);
        }
        return eq;
    }

    public Email withEmail(final String email) {
        return Email.of(email);
    }

    public String getEmail() {
        return email;
    }

}
