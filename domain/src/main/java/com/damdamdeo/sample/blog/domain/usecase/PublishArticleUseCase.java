package com.damdamdeo.sample.blog.domain.usecase;

import com.damdamdeo.sample.blog.domain.Article;
import com.damdamdeo.sample.blog.domain.spi.ArticleRepository;
import com.damdamdeo.sample.blog.domain.spi.PublishedAtProvider;

import java.util.Objects;

public class PublishArticleUseCase {

    private final ArticleRepository articleRepository;
    private final PublishedAtProvider publishedAtProvider;

    public PublishArticleUseCase(final ArticleRepository articleRepository,
                                 final PublishedAtProvider publishedAtProvider) {
        this.articleRepository = Objects.requireNonNull(articleRepository);
        this.publishedAtProvider = Objects.requireNonNull(publishedAtProvider);
    }

    public Article execute(PublishArticleCommand publishArticleCommand) throws PublishArticleException {
        try {
            final Article article = articleRepository.getById(publishArticleCommand.articleId());
            // TODO handle article not found
            return article.publish(publishedAtProvider.now(), publishArticleCommand.executedBy());
        } catch (final Exception e) {
            throw new PublishArticleException(e);
        }
    }
}
