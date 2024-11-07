package com.damdamdeo.sample.blog.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Article {

    private final ArticleId articleId;
    private Author author;
    private String title;
    private String content;
    private State state;
    private PublishedAt publishedAt;
    private final List<Comment> comments = new ArrayList<>();

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

    public Article publish(final PublishedAt publishedAt,
                        final ExecutedBy executedBy) throws CannotPublishArticleException {
        if (!canPublish(executedBy)) {
            throw new CannotPublishArticleException(articleId);
        }
        this.state = State.PUBLISHED;
        this.publishedAt = Objects.requireNonNull(publishedAt);
        return this;
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

    public boolean openToComment() {
        return this.state == State.PUBLISHED;
    }

    public void addComment(final Comment comment) throws CommentsNotOpenedYetException {
        Objects.requireNonNull(comment);
        if (!openToComment()) {
            throw new CommentsNotOpenedYetException(articleId);
        }
        this.comments.add(comment);
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
