package com.envest.markdown.model;

/**
 * Created by 41408 on 2018/11/22.
 */
public class MarkDownVo {

    private String id;
    private String title;
    private String content;

    public MarkDownVo() {
    }

    public MarkDownVo(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
