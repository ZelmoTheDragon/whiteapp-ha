package com.github.zelmothedragon.whiteapp.domain.account;

import com.github.zelmothedragon.whiteapp.domain.Repository;

/**
 *
 * @author MOSELLE Maxime
 */
public interface AccountRepository extends Repository<AccountOperation, AccountEvent> {

    boolean contains(Owner owner);
}
