package com.github.zelmothedragon.whiteapp.infrastructure.controller;

import com.github.zelmothedragon.whiteapp.infrastructure.service.CustomerService;
import com.github.zelmothedragon.whiteapp.infrastructure.persistence.entity.CustomerEntity;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author MOSELLE
 */
@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerEndPoint {

    @Inject
    private CustomerService service;

    public CustomerEndPoint() {
    }

    @POST
    @Path("/register")
    public void register(@Valid final CustomerEntity entity) {
        service.register(entity);
    }

    @PUT
    @Path("/update")
    public void update(@Valid final CustomerEntity entity) {
        service.update(entity);
    }

    @DELETE
    @Path("/delete")
    public void remove(@Valid final CustomerEntity entity) {
        service.remove(entity);
    }

    @GET
    @Path("/{email}")
    public Optional<CustomerEntity> find(@PathParam("email") final String email) {
        return service.find(email);
    }

    @GET
    @Path("/list")
    public List<CustomerEntity> list() {
        return service.find();
    }
}
