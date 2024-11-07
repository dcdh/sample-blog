package com.damdamdeo.sample.blog.domain;

import java.util.Objects;

public record ArticleId(String id) {
    public ArticleId {
        Objects.requireNonNull(id);
    }
}
