package com.github.zelmothedragon.whiteapp.infrastructure.customer;

import com.github.zelmothedragon.whiteapp.domain.customer.CustomerBusiness;
import com.github.zelmothedragon.whiteapp.domain.customer.Email;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author MOSELLE Maxime
 */
@Dependent
public class CustomerService implements Serializable {

    private static final long serialVersionUID = 1L;

    private CustomerBusiness business;

    @Inject
    private CustomerDAO dao;

    @Inject
    private CustomerMapper mapper;

    public CustomerService() {
    }

    @PostConstruct
    protected void init() {
        this.business = new CustomerBusiness(dao);
    }

    @Transactional
    public void register(final CustomerEntity entity) {
        var dto = mapper.toObject(entity);
        business.register(dto);
    }

    @Transactional
    public void update(final CustomerEntity entity) {
        var dto = mapper.toObject(entity);
        business.update(dto);
    }

    @Transactional
    public void remove(final CustomerEntity entity) {
        var dto = mapper.toObject(entity);
        business.register(dto);
    }

    public Optional<CustomerEntity> find(final String email) {
        return business
                .find(Email.of(email))
                .map(mapper::fromObject);
    }
    
    public List<CustomerEntity> find(){
        return business
                .find()
                .stream()
                .map(mapper::fromObject)
                .collect(Collectors.toList());
    }

}
