package com.wt.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/1 1:57 下午
 * @description：
 */
@Data
public class SysUserRole {

    private String id;

    private String userId;

    private String roleId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    private String deleted;

}
