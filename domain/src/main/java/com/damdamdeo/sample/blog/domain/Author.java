package com.damdamdeo.sample.blog.domain;

import java.util.Objects;

public record Author(String name) {
    public Author {
        Objects.requireNonNull(name);
        if (!name.matches("[a-z-A-Z]")) {
            throw new IllegalStateException("Invalid author name: " + name);
        }
    }
}
