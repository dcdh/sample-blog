package com.damdamdeo.sample.blog.domain;

public final class ExecutedBy extends Named {

    public ExecutedBy(final String name) {
        super(name);
    }

    public boolean matchesAuthor(final Author author) {
        return name.equals(author.name());
    }

    public Author toAuthor() {
        return new Author(name);
    }
}
