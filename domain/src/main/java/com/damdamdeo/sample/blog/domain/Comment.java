package com.damdamdeo.sample.blog.domain;

import java.util.Objects;

public record Comment(Author author, String content) {
    public Comment {
        Objects.requireNonNull(author);
        Objects.requireNonNull(content);
    }
}
