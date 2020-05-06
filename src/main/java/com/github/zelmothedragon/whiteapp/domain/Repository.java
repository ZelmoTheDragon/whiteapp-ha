package com.github.zelmothedragon.whiteapp.domain;

import java.util.Optional;

/**
 *
 * @author MOSELLE Maxime
 * @param <E>
 * @param <K>
 */
public interface Repository<E, K> {

    boolean contains(K email);

    void add(E customer);

    void remove(E customer);

    Optional<E> get(K email);
}
