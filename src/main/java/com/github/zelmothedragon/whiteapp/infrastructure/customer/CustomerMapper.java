package com.github.zelmothedragon.whiteapp.infrastructure.customer;

import com.github.zelmothedragon.whiteapp.domain.customer.Customer;
import com.github.zelmothedragon.whiteapp.domain.customer.Email;
import com.github.zelmothedragon.whiteapp.infrastructure.Mapper;
import java.io.Serializable;
import javax.enterprise.context.Dependent;

/**
 *
 * @author MOSELLE Maxime
 */
@Dependent
public class CustomerMapper implements Mapper<Customer, CustomerEntity>, Serializable {

    private static final long serialVersionUID = 1L;

    public CustomerMapper() {
    }

    @Override
    public Customer toObject(final CustomerEntity source) {
        var email = Email.of(source.getEmail());
        return Customer.of(
                email,
                source.getGivenName(),
                source.getFamilyName()
        );
    }

    @Override
    public Customer toObject(final CustomerEntity source, final Customer target) {
        var email = Email.of(source.getEmail());
        return target
                .withEmail(email)
                .withGivenName(source.getGivenName())
                .withFamilyName(source.getFamilyName());
    }

    @Override
    public CustomerEntity fromObject(final Customer source) {
        var target = CustomerEntity.of();
        return fromObject(source, target);
    }

    @Override
    public CustomerEntity fromObject(final Customer source, final CustomerEntity target) {
        target.setEmail(source.getEmail().getEmail());
        target.setGivenName(source.getGivenName());
        target.setFamilyName(source.getFamilyName());
        return target;
    }

}
