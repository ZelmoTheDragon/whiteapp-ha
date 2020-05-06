package com.github.zelmothedragon.whiteapp.domain.account;

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

    public AccountOperation of(
            final AccountEvent event,
            final BigDecimal amount,
            final String description) {

        var entity = new AccountOperation(event, amount, description);
        return Validator
                .of(entity)
                .validate(AccountOperation::getEvent, Constraint::notNull, Constraint.MESSAGE_NOT_NULL)
                .validate(AccountOperation::getEvent, e -> Constraint.notEquals(e, AccountEvent.EMPTY), Constraint.MESSAGE_NOT_EMPTY_OBJECT)
                .validate(AccountOperation::getAmount, Objects::nonNull, Constraint.MESSAGE_NOT_NULL)
                .validate(AccountOperation::getAmount, e -> Constraint.notEquals(e, BigDecimal.ZERO), Constraint.MESSAGE_NOT_EMPTY_OBJECT)
                .get();
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
