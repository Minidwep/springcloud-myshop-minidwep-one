package com.minidwep.myshop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_content")
public class TbContent {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 内容类目ID
     */
    @TableField(value = "category_id")
    private Long categoryId;

    /**
     * 内容标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 子标题
     */
    @TableField(value = "sub_title")
    private String subTitle;

    /**
     * 标题描述
     */
    @TableField(value = "title_desc")
    private String titleDesc;

    /**
     * 链接
     */
    @TableField(value = "url")
    private String url;

    /**
     * 图片绝对路径
     */
    @TableField(value = "pic")
    private String pic;

    /**
     * 图片2
     */
    @TableField(value = "pic2")
    private String pic2;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    @TableField(value = "created")
    private Date created;

    @TableField(value = "updated")
    private Date updated;

    public static final String COL_ID = "id";

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_TITLE = "title";

    public static final String COL_SUB_TITLE = "sub_title";

    public static final String COL_TITLE_DESC = "title_desc";

    public static final String COL_URL = "url";

    public static final String COL_PIC = "pic";

    public static final String COL_PIC2 = "pic2";

    public static final String COL_CONTENT = "content";

    public static final String COL_CREATED = "created";

    public static final String COL_UPDATED = "updated";
}