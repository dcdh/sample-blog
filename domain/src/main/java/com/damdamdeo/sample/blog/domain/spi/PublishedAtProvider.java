package com.damdamdeo.sample.blog.domain.spi;

import com.damdamdeo.sample.blog.domain.PublishedAt;

public interface PublishedAtProvider {
    PublishedAt now();
}
