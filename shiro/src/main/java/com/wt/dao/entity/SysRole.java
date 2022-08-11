package com.wt.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/1 1:36 下午
 * @description：
 */
@Data
public class SysRole {

    private String id;

    private String srName;

    private String srKey;

    private String srRemark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    private String deleted;



}
