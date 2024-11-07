package com.damdamdeo.sample.blog.domain;

import java.util.Objects;

public final class ExecutedByIsNotTheAuthorException extends Exception {

    private final ArticleId articleId;
    private final Author author;
    private final ExecutedBy executedBy;

    public ExecutedByIsNotTheAuthorException(final ArticleId articleId,
                                             final Author author,
                                             final ExecutedBy executedBy) {
        this.articleId = Objects.requireNonNull(articleId);
        this.author = Objects.requireNonNull(author);
        this.executedBy = Objects.requireNonNull(executedBy);
    }

    public ArticleId getArticleId() {
        return articleId;
    }

    public Author getAuthor() {
        return author;
    }

    public ExecutedBy getExecutedBy() {
        return executedBy;
    }
}
