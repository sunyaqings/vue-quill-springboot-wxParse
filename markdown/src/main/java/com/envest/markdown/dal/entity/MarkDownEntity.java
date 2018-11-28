package com.envest.markdown.dal.entity;


import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by 41408 on 2018/11/22.
 */

@Entity
@Table(name = "markDown")
public class MarkDownEntity {

    @ApiModelProperty(value = "账户uuid,自动生成")
    private String  id;
    @Column
    private String title;

    @Lob
    @Column(columnDefinition="text")
    private String content;


    @Id
    @GenericGenerator(name = "id_uuid", strategy = "uuid")
    @GeneratedValue(generator = "id_uuid")
    @Column(name = "id", nullable = false, unique = true, length = 40)
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
