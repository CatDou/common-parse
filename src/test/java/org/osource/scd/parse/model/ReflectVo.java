package org.osource.scd.parse.model;

import org.osource.scd.anno.Location;

import java.util.Date;

/**
 * @author chengdu
 *
 */
public class ReflectVo {
    @Location(column = "A")
    private Integer id;

    @Location(column = "B")
    private String userName;

    @Location(column = "C")
    private Double score;

    private Long sort;

    @Location(column = "D")
    private Date date;

    private String otherInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
}
