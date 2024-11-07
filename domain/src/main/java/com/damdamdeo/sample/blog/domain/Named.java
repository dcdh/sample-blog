package com.damdamdeo.sample.blog.domain;

import java.util.Objects;

public abstract class Named {
    protected final String name;

    protected Named(final String name) {
        this.name = Objects.requireNonNull(name);
        if (!name.matches("[a-z-A-Z]")) {
            throw new IllegalStateException("Invalid author name: " + name);
        }
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Named that = (Named) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
