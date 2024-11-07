package com.damdamdeo.sample.blog.domain;

import java.util.Objects;

public final class CommentsNotOpenedYetException extends Exception {
    private final ArticleId articleId;

    public CommentsNotOpenedYetException(final ArticleId articleId) {
        this.articleId = Objects.requireNonNull(articleId);
    }

    public ArticleId getArticleId() {
        return articleId;
    }
}
