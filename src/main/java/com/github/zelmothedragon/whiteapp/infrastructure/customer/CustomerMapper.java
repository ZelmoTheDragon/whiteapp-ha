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
        return Customer.of(
                Email.of(source.getEmail()),
                source.getGivenName(),
                source.getGivenName()
        );
    }
    
    @Override
    public Customer toObject(final CustomerEntity source, final Customer target) {
        return target
                .withEmail(Email.of(source.getEmail()))
                .withGivenName(source.getGivenName())
                .withFamilyName(source.getFamilyName());
    }
    
    @Override
    public CustomerEntity fromObject(Customer source) {
        var entity = CustomerEntity.of();
        return fromObject(source, entity);
    }
    
    @Override
    public CustomerEntity fromObject(Customer source, CustomerEntity target) {
        target.setEmail(source.getEmail().getEmail());
        target.setGivenName(source.getGivenName());
        target.setFamilyName(source.getFamilyName());
        return target;
    }
    
}
