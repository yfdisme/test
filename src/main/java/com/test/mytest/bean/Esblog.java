package com.test.mytest.bean;

import io.searchbox.annotations.JestId;
import lombok.Data;

@Data
public class Esblog {
    @JestId
    private String id;
    private Long blogId;
    private String title;
    private String summary;
    private String content;
}
