package com.damdamdeo.sample.blog.domain;

import com.damdamdeo.sample.blog.domain.spi.PublishedAtProvider;

import java.util.Objects;

public final class Article {

    private final ArticleId articleId;
    private Author author;
    private String title;
    private String content;
    private State state;
    private PublishedAt publishedAt;

    public Article(final ArticleId articleId) {
        this.articleId = Objects.requireNonNull(articleId);
    }

    public void write(final ExecutedBy executedBy,
                      final String title,
                      final String content) throws CannotWriteArticleException {
        if (!canWrite(executedBy)) {
            throw new CannotWriteArticleException(articleId);
        }
        this.author = Objects.requireNonNull(executedBy).toAuthor();
        this.title = Objects.requireNonNull(title);
        this.content = Objects.requireNonNull(content);
        this.state = State.DRAFT;
    }

    public void publish(final PublishedAtProvider publishedAtProvider,
                        final ExecutedBy executedBy) throws CannotPublishArticleException {
        if (!canPublish(executedBy)) {
            throw new CannotPublishArticleException(articleId);
        }
        this.state = State.PUBLISHED;
        this.publishedAt = publishedAtProvider.now();
    }

    public boolean canWrite(final ExecutedBy executed) {
        Objects.requireNonNull(executed);
        if (this.author != null && !executed.matchesAuthor(author)) {
            return false;
        }
        return this.state == State.PUBLISHED;
    }

    public boolean canPublish(final ExecutedBy executed) {
        Objects.requireNonNull(executed);
        return this.state == State.DRAFT && executed.matchesAuthor(author);
    }

    public ArticleId articleId() {
        return articleId;
    }

    public Author author() {
        return author;
    }

    public String title() {
        return title;
    }

    public String content() {
        return content;
    }

    public State state() {
        return state;
    }

    public PublishedAt publishedAt() {
        return publishedAt;
    }
}
