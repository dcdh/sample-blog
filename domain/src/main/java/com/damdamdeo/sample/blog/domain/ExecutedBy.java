package com.damdamdeo.sample.blog.domain;

import java.util.Objects;

public record ExecutedBy(String by) {
    public ExecutedBy {
        Objects.requireNonNull(by);
    }

    public boolean matchesAuthor(final Author author) {
        return by.equals(author.name());
    }

    public Author toAuthor() {
        return new Author(by);
    }
}
