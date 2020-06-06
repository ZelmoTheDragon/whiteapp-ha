package com.github.zelmothedragon.whiteapp.domain.account;

import com.github.zelmothedragon.whiteapp.domain.DomainException;

/**
 *
 * @author MOSELLE Maxime
 */
public class AccountException extends DomainException {

    private static final long serialVersionUID = 1L;

    public static final String MESSAGE_ACCOUNT_ALREADY_EXISTS = "account already exists";

    public AccountException(String message) {
        super(message);
    }

    public AccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountException(Throwable cause) {
        super(cause);
    }

}
