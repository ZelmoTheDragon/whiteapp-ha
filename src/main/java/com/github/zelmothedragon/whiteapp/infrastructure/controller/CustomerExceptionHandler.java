package com.github.zelmothedragon.whiteapp.infrastructure.controller;

import com.github.zelmothedragon.whiteapp.domain.customer.CustomerException;
import com.github.zelmothedragon.whiteapp.infrastructure.controller.ErrorMessage;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author MOSELLE Maxime
 */
@Provider
public class CustomerExceptionHandler implements ExceptionMapper<CustomerException> {

    public CustomerExceptionHandler() {
    }

    @Override
    public Response toResponse(final CustomerException ex) {

        var message = new ErrorMessage();
        message.setError("customer business error");
        message.setMessage(ex.getMessage());

        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(message)
                .type(MediaType.APPLICATION_JSON)
                .build();

    }

}
