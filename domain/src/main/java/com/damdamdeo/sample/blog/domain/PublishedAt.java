package com.damdamdeo.sample.blog.domain;

import java.time.ZonedDateTime;
import java.util.Objects;

public record PublishedAt(ZonedDateTime at) {
    public PublishedAt {
        Objects.requireNonNull(at);
    }
}
