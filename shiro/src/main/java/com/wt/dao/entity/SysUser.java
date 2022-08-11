package com.wt.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/1 12:05 下午
 * @description：
 */
@Data
public class SysUser {

    private String id;

    private String suPhone;

    private String suSalt;

    private String suPassword;

    private String suAvatar;

    private String suName;

    private String suSex;

    private String suBirth;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    private String deleted;

}
