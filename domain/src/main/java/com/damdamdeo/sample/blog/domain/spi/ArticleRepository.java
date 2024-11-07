package com.damdamdeo.sample.blog.domain.spi;

import com.damdamdeo.sample.blog.domain.Article;
import com.damdamdeo.sample.blog.domain.ArticleId;
import com.damdamdeo.sample.blog.domain.UnknownArticleException;

public interface ArticleRepository {
    Article getById(ArticleId articleId) throws UnknownArticleException;
}
