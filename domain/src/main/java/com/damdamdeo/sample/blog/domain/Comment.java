package com.damdamdeo.sample.blog.domain;

import java.util.Objects;

public record Comment(CommentedBy commentedBy, String content) {
    public Comment {
        Objects.requireNonNull(commentedBy);
        Objects.requireNonNull(content);
    }
}
