package com.xingheng.ai.BigDataAnalysis.repository;

import com.xingheng.ai.BigDataAnalysis.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @ClassName ArticleRepository
 * @Description TODO
 * @Author liuyanming
 * @Date 2019/2/1 11:45 AM
 */

public interface ArticleRepository extends ElasticsearchRepository<Article,Long> {
}
