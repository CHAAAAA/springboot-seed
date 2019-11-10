package edu.pku.springbootseed.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SysUser {
    /**
     *
     */
    private String id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String xhzgh;

    /**
     *
     */
    private String birth;

    /**
     *
     */
    private Integer age;

    /**
     *
     */
    private String gender;

    /**
     *
     */
    private Date createDate;

    /**
     *
     */
    private String comments;
}

