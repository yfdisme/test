package com.test.mytest.es;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Esclient {
    @Autowired
    JestClient jestClient;

    public SearchResult queryByDSL(String index, String query) {
        Search search = new Search.Builder(query).addIndex(index).build();
        SearchResult execute = null;
        try {
            execute = jestClient.execute(search);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  execute;
    }
    public SearchResult query(Search search) {
        SearchResult execute = null;
        try {
            execute = jestClient.execute(search);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  execute;
    }


    public List<JSONObject> queryListByDSL(String index, String type, String query) {
        Search.Builder searchBuilder = new Search.Builder(query).addIndex(index);
        if (StringUtils.isNotBlank(type)) {
            searchBuilder.addType(type);
        }
        SearchResult searchResult = query(searchBuilder.build());//todo:到es查询数据
        return searchResult.getSourceAsStringList().stream().map(k -> {//todo 遍历数据获取总条数
            JSONObject jsonObject = JSON.parseObject(k, JSONObject.class);
            jsonObject.put("total_num", searchResult.getTotal());//fixme 获取总数据
            return jsonObject;//fixme 返回map
        }).collect(Collectors.toList());
    }
}
