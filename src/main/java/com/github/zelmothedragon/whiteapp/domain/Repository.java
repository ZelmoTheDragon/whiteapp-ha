package com.github.zelmothedragon.whiteapp.domain;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author MOSELLE Maxime
 * @param <E>
 * @param <K>
 */
public interface Repository<E, K> {

    boolean contains(K id);

    void add(E entity);

    void remove(E entity);

    Optional<E> get(K id);
    
    List<E> get();
}
