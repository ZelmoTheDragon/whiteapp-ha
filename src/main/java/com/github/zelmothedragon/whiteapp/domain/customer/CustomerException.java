package com.github.zelmothedragon.whiteapp.domain.customer;

import com.github.zelmothedragon.whiteapp.domain.DomainException;

/**
 *
 * @author MOSELLE Maxime
 */
public final class CustomerException extends DomainException {

    private static final long serialVersionUID = 1L;

    static final String MESSAGE_EMAIL_IN_USE = "email already in use";
    
    static final String MESSAGE_UNKNOW_ENTITY = "unknow customer";

    CustomerException(final String message) {
        super(message);
    }

}
