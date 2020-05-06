package com.github.zelmothedragon.whiteapp.infrastructure;

public interface Mapper<A, B> {

    A toObject(B source);

    A toObject(B source, A target);

    B fromObject(A source);

    B fromObject(A source, B target);
}
