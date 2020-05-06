package com.github.zelmothedragon.whiteapp.domain.customer;

import java.util.Optional;
import java.util.Set;

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
            throw new CustomerException("email already in use");
        }
    }

    public void update(final Customer customer) {
        if (repository.contains(customer.getEmail())) {
            repository.add(customer);
        } else {
            throw new CustomerException("unknow customer");
        }
    }

    public void remove(final Customer customer) {
        if (repository.contains(customer.getEmail())) {
            repository.remove(customer);
        } else {
            throw new CustomerException("unknow customer");
        }
    }

    public Optional<Customer> find(final Email email) {
        return repository.get(email);
    }

    public Set<Customer> search() {
        return Set.of();
    }
}
