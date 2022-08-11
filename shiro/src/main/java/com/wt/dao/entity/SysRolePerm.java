package com.wt.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/1 1:41 下午
 * @description：
 */
@Data
public class SysRolePerm {

    private String id;

    private String roleId;

    private String permId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    private String deleted;

}
