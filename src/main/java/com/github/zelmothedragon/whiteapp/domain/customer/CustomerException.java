package com.github.zelmothedragon.whiteapp.domain.customer;

import com.github.zelmothedragon.whiteapp.domain.DomainException;

/**
 *
 * @author MOSELLE Maxime
 */
final class CustomerException extends DomainException {

    private static final long serialVersionUID = 1L;

    CustomerException(String message) {
        super(message);
    }

}
