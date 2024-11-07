package com.damdamdeo.sample.blog.infrastructure.web.api;

import com.damdamdeo.sample.blog.domain.Article;
import com.damdamdeo.sample.blog.domain.ExecutedBy;
import com.damdamdeo.sample.blog.domain.State;

import java.time.ZonedDateTime;

public record ArticleDTO(String articleId,
                         String author,
                         String title,
                         String content,
                         State state,
                         ZonedDateTime publishedAt,
                         Boolean canPublish,
                         Boolean canWrite,
                         Boolean openToComment) {
    public ArticleDTO(final Article article, final ExecutedBy executed) {
        this(article.articleId().id(),
                article.author().name(),
                article.title(),
                article.content(),
                article.state(),
                article.publishedAt().at(),
                article.canPublish(executed),
                article.canWrite(executed),
                article.openToComment());
    }

}
