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
public final class Account {

    private final Owner owner;

    private final BigDecimal amount;

    private Account(final Owner owner, final BigDecimal amount) {
        this.owner = owner;
        this.amount = amount;
    }

    public static Account of(final Owner owner, final BigDecimal amount) {

        var entity = new Account(owner, amount);
        return Validator
                .of(entity)
                .validate(Account::getOwner, Constraint::notNull, "owner", Constraint.MESSAGE_NOT_NULL)
                .validate(Account::getOwner, Constraint.notEquals(Owner.EMPTY), "owner", Constraint.MESSAGE_NOT_EMPTY_OBJECT)
                .validate(Account::getAmount, Constraint::notNull, "amount", Constraint.MESSAGE_NOT_NULL)
                .get();
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, amount);
    }

    @Override
    public boolean equals(Object obj) {
        return Equals
                .with(Account::getOwner)
                .thenWith(Account::getAmount)
                .apply(this, obj);
    }

    @Override
    public String toString() {
        return ToString
                .with("owner", Account::getOwner)
                .thenWith("amount", Account::getAmount)
                .apply(this);
    }

    public Account withOwner(Owner owner) {
        return of(owner, amount);
    }

    public Account withAmount(BigDecimal amount) {
        return of(owner, amount);
    }

    public Owner getOwner() {
        return owner;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
