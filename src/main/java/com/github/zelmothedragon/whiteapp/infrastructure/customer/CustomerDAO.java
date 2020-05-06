package com.github.zelmothedragon.whiteapp.infrastructure.customer;

import com.github.zelmothedragon.whiteapp.domain.customer.Customer;
import com.github.zelmothedragon.whiteapp.domain.customer.CustomerRepository;
import com.github.zelmothedragon.whiteapp.domain.customer.Email;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import java.util.Optional;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author MOSELLE Maxime
 */
@ApplicationScoped
public class CustomerDAO implements CustomerRepository,
        PanacheRepositoryBase<CustomerEntity, UUID> {

    @Inject
    private CustomerMapper mapper;

    public CustomerDAO() {
    }

    @Override
    public boolean contains(final Email email) {
        return count("email", email.getEmail()) == 1L;
    }

    @Override
    public void add(final Customer customer) {
        find("email", customer.getEmail().getEmail())
                .firstResultOptional()
                .or(() -> Optional.of(CustomerEntity.of()))
                .map(e -> mapper.fromObject(customer, e))
                .ifPresent(this::persist);
    }

    @Override
    public void remove(final Customer customer) {
        find("email", customer.getEmail().getEmail())
                .firstResultOptional()
                .ifPresent(this::delete);
    }

    @Override
    public Optional<Customer> get(final Email email) {
        return find("email", email.getEmail())
                .firstResultOptional()
                .map(mapper::toObject);
    }

}
