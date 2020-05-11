package com.github.zelmothedragon.whiteapp.domain.customer;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author MOSELLE Maxime
 */
public class CustomerBusiness {

    private final CustomerRepository repository;

    public CustomerBusiness(final CustomerRepository repository) {
        this.repository = repository;
    }

    public void register(final Customer customer) {
        if (!repository.contains(customer.getEmail())) {
            repository.add(customer);
        } else {
            throw new CustomerException(CustomerException.MESSAGE_EMAIL_IN_USE);
        }
    }

    public void update(final Customer customer) {
        if (repository.contains(customer.getEmail())) {
            repository.add(customer);
        } else {
            throw new CustomerException(CustomerException.MESSAGE_UNKNOW_ENTITY);
        }
    }

    public void remove(final Customer customer) {
        if (repository.contains(customer.getEmail())) {
            repository.remove(customer);
        } else {
            throw new CustomerException(CustomerException.MESSAGE_UNKNOW_ENTITY);
        }
    }

    public Optional<Customer> find(final Email email) {
        return repository.get(email);
    }

    public List<Customer> find() {
        return repository.get();
    }
}
