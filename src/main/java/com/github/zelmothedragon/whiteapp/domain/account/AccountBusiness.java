package com.github.zelmothedragon.whiteapp.domain.account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author MOSELLE Maxime
 */
public class AccountBusiness {

    private final AccountRepository repository;

    public AccountBusiness(final AccountRepository repository) {
        this.repository = repository;
    }

    public void register(Owner email) {
        if (!repository.contains(email)) {
            var id = AccountEvent.of(email.getEmail(), LocalDateTime.now());
            var entity = AccountOperation.of(
                    id,
                    BigDecimal.ZERO,
                    "created"
            );
            repository.add(entity);
        }else{
            throw new AccountException(AccountException.MESSAGE_ACCOUNT_ALREADY_EXISTS);
        }
    }

}
