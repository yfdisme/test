package com.test.mytest;

import com.alibaba.fastjson.JSONObject;
import com.test.mytest.bean.Esblog;
import com.test.mytest.bean.Page;
import com.test.mytest.es.Esclient;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.indices.CreateIndex;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MytestApplicationTests {
    @Autowired
    JestClient jestClient;
    @Resource
    Esclient esclient;
    @Test
    public void contextLoads() {
//        //1.给es中索引（保存）一个文档
//        Esblog esBlog=new Esblog();
//        esBlog.setBlogId(10001l);
//        esBlog.setId("10001");
//        esBlog.setContent("content");
//        esBlog.setSummary("summary");
//        esBlog.setTitle("title");
//        //构建一个索引功能
//        Index index=new Index.Builder(esBlog).index("thblog").type("blog").build();
//
//        try {
//            //执行
//            jestClient.execute(index);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    @Test
    public void testSearch(){
        //查询表达式
        String json="{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"title\" : \"tle\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建搜索功能
        Search search=new Search.Builder(json).addIndex("thblog").addType("blog").build();

        try {
            SearchResult result=jestClient.execute(search);
            System.out.println("------------"+result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void query() {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        HighlightBuilder highlightBuilder = new HighlightBuilder().field("*").requireFieldMatch(false).tagsSchema("default");
        searchSourceBuilder.highlighter(highlightBuilder);
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder("summary");
        queryStringQueryBuilder
                .field("id")
                .field("content")
                .field("title")
                .field("summary");
        searchSourceBuilder.query(queryStringQueryBuilder).from(from(1, 10)).size(10);
        log.info("搜索DSL:{}", searchSourceBuilder.toString());
        List<JSONObject> jsonObjects = esclient.queryListByDSL("thblog", "blog",searchSourceBuilder.toString());
        jsonObjects.toString();
    }


    private int from(int pageNo, int size) {
        return (pageNo - 1) * size < 0 ? 0 : (pageNo - 1) * size;
    }
    public Page<Esblog> query(String queryString, int pageNo, int size) {
//        String settings = "\"settings\" : {\n" +
//                "        \"number_of_shards\" : 5,\n" +
//                "        \"number_of_replicas\" : 1\n" +
//                "    }\n";
//
//        client.execute(new CreateIndex.Builder("articles").settings(Settings.builder().loadFromSource(settings).build().getAsMap()).build());

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        HighlightBuilder highlightBuilder = new HighlightBuilder().field("*").requireFieldMatch(false).tagsSchema("default");
        searchSourceBuilder.highlighter(highlightBuilder);
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(queryString);
        queryStringQueryBuilder
                .field("id")
                .field("content")
                .field("title")
                .field("summary");
        searchSourceBuilder.query(queryStringQueryBuilder).from(from(pageNo, size)).size(size);
        log.info("搜索DSL:{}", searchSourceBuilder.toString());
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex("thblog")
                .addType("blog")
                .build();
        try {
            SearchResult result = jestClient.execute(search);
            List<SearchResult.Hit<Esblog, Void>> hits = result.getHits(Esblog.class);
            List<Esblog> movies = hits.stream().map(hit -> {
                Esblog movie = hit.source;
                Map<String, List<String>> highlight = hit.highlight;
                if (highlight.containsKey("title")) {
                    movie.setTitle(highlight.get("title").get(0) + " [score]-->" + hit.score);
                }
//                if (highlight.containsKey("actors")) {
//                    movie.setActors(highlight.get("actors"));
//                }
//                if (highlight.containsKey("types")) {
//                    movie.setTypes(highlight.get("types"));
//                }
//                if (highlight.containsKey("regions")) {
//                    movie.setRegions(highlight.get("regions"));
//                }
                return movie;
            }).collect(toList());
            int took = result.getJsonObject().get("took").getAsInt();
            Page<Esblog> page = Page.<Esblog>builder().list(movies).pageNo(pageNo).size(size).total(result.getTotal()).took(took).build();
            return page;
        } catch (IOException e) {
            log.error("search异常", e);
            return null;
        }

    }


}
