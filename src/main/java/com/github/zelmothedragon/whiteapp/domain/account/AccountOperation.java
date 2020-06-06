package com.github.zelmothedragon.whiteapp.domain.account;

import com.github.zelmothedragon.whiteapp.domain.util.lang.Equals;
import com.github.zelmothedragon.whiteapp.domain.util.lang.ToString;
import com.github.zelmothedragon.whiteapp.domain.util.validation.Constraint;
import com.github.zelmothedragon.whiteapp.domain.util.validation.Validator;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author MOSELLE Maxime
 */
public final class AccountOperation {

    public static AccountOperation EMPTY = new AccountOperation(AccountEvent.EMPTY, BigDecimal.ZERO, "");

    private final AccountEvent event;

    private final BigDecimal amount;

    private final String description;

    private AccountOperation(
            final AccountEvent event,
            final BigDecimal amount,
            final String description) {

        this.event = event;
        this.amount = amount;
        this.description = description;
    }

    public static AccountOperation of(
            final AccountEvent event,
            final BigDecimal amount,
            final String description) {

        var entity = new AccountOperation(event, amount, description);
        return Validator
                .of(entity)
                .validate(AccountOperation::getEvent, Constraint::notNull, "event", Constraint.MESSAGE_NOT_NULL)
                .validate(AccountOperation::getEvent, Constraint.notEquals(AccountEvent.EMPTY), "event", Constraint.MESSAGE_NOT_EMPTY_OBJECT)
                .validate(AccountOperation::getAmount, Objects::nonNull, "amount", Constraint.MESSAGE_NOT_NULL)
                .validate(AccountOperation::getAmount, Constraint.notEquals(BigDecimal.ZERO), "amount", Constraint.MESSAGE_NOT_EMPTY_OBJECT)
                .validate(AccountOperation::getDescription, Constraint::notEmpty, "description", Constraint.MESSAGE_NOT_EMPTY)
                .get();
    }

    @Override
    public int hashCode() {
        return Objects.hash(event, amount, description);
    }

    @Override
    public boolean equals(Object obj) {
        return Equals
                .with(AccountOperation::getEvent)
                .thenWith(AccountOperation::getAmount)
                .thenWith(AccountOperation::getDescription)
                .apply(this, obj);
    }

    @Override
    public String toString() {
        return ToString
                .with("event", AccountOperation::getEvent)
                .thenWith("amount", AccountOperation::getAmount)
                .thenWith("description", AccountOperation::getDescription)
                .apply(this);
    }

    public AccountOperation withEvent(AccountEvent event) {
        return AccountOperation.of(event, amount, description);
    }

    public AccountOperation withAmount(BigDecimal amount) {
        return AccountOperation.of(event, amount, description);
    }

    public AccountOperation withDescription(String description) {
        return AccountOperation.of(event, amount, description);
    }

    public AccountEvent getEvent() {
        return event;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

}
