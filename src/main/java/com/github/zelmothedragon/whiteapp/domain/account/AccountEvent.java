package com.github.zelmothedragon.whiteapp.domain.account;

import com.github.zelmothedragon.whiteapp.domain.util.lang.EmptyObject;
import com.github.zelmothedragon.whiteapp.domain.util.validation.Constraint;
import com.github.zelmothedragon.whiteapp.domain.util.validation.Validator;
import java.time.LocalDateTime;

/**
 *
 * @author MOSELLE Maxime
 */
public final class AccountEvent {

    public static final AccountEvent EMPTY = new AccountEvent("", EmptyObject.EMPTY_DATE_TIME);

    private final String email;

    private final LocalDateTime dateOfEvent;

    private AccountEvent(
            final String email,
            final LocalDateTime dateOfEvent) {

        this.email = email;
        this.dateOfEvent = dateOfEvent;
    }

    public static AccountEvent of(
            final String email,
            final LocalDateTime dateOfEvent) {

        var entity = new AccountEvent(email, dateOfEvent);
        return Validator
                .of(entity)
                .validate(AccountEvent::getEmail, Constraint::notEmpty, Constraint.MESSAGE_NOT_EMPTY)
                .validate(AccountEvent::getEmail, Constraint::isEmailValid, Constraint.MESSAGE_INVALID_EMAIL)
                .validate(AccountEvent::getDateOfEvent, Constraint::notNull, Constraint.MESSAGE_NOT_EMPTY)
                .validate(AccountEvent::getDateOfEvent, e -> Constraint.notEquals(e, EmptyObject.EMPTY_DATE_TIME), Constraint.MESSAGE_NOT_EMPTY_OBJECT)
                .get();
    }

    public AccountEvent withEmail(final String email) {
        return AccountEvent.of(email, dateOfEvent);
    }

    public AccountEvent withDateOfEvent(LocalDateTime dateOfEvent) {
        return AccountEvent.of(email, dateOfEvent);
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getDateOfEvent() {
        return dateOfEvent;
    }

}
