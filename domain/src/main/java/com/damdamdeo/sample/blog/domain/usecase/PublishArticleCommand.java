package com.damdamdeo.sample.blog.domain.usecase;

import com.damdamdeo.sample.blog.domain.ArticleId;
import com.damdamdeo.sample.blog.domain.ExecutedBy;

import java.util.Objects;

public record PublishArticleCommand(ArticleId articleId, ExecutedBy executedBy) {
    public PublishArticleCommand {
        Objects.requireNonNull(articleId);
        Objects.requireNonNull(executedBy);
    }
}
