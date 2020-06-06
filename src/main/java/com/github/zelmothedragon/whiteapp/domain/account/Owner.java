package com.github.zelmothedragon.whiteapp.domain.account;

import com.github.zelmothedragon.whiteapp.domain.util.lang.Equals;
import com.github.zelmothedragon.whiteapp.domain.util.lang.ToString;
import com.github.zelmothedragon.whiteapp.domain.util.validation.Constraint;
import com.github.zelmothedragon.whiteapp.domain.util.validation.Validator;
import java.util.Objects;

/**
 *
 * @author MOSELLE Maxime
 */
public final class Owner {

    public static final Owner EMPTY = new Owner("");

    private final String email;

    private Owner(final String email) {
        this.email = email;
    }

    public static Owner of(final String email) {
        var entity = new Owner(email);
        return Validator
                .of(entity)
                .validate(Owner::getEmail, Constraint::notEmpty, "email", Constraint.MESSAGE_NOT_EMPTY)
                .validate(Owner::getEmail, Constraint::isEmailValid, "email", Constraint.MESSAGE_INVALID_EMAIL)
                .get();
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public boolean equals(final Object obj) {
        return Equals
                .with(Owner::getEmail)
                .apply(this, obj);
    }

    @Override
    public String toString() {
        return ToString
                .with("email", Owner::getEmail)
                .apply(this);
    }

    public Owner withEmail(final String email) {
        return Owner.of(email);
    }

    public String getEmail() {
        return email;
    }

}
