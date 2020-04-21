package org.osource.scd.parse.model;

import org.osource.scd.anno.Location;

import java.util.Date;

/**
 * @author chengdu
 */
public class MergeDataVo {
    @Location(column = "A")
    private String string;
    @Location(column = "B")
    private String date;
    @Location(column = "C")
    private Double doubleData;
    @Location(column = "D")
    private Date utDate;
    @Location(sheet = 1, column = "A")
    private Integer id;
    @Location(sheet = 1, column = "B")
    private String userName;
    @Location(sheet = 1, column = "C")
    private Double score;
    @Location(sheet = 1, column = "D")
    private Date rdate;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getDoubleData() {
        return doubleData;
    }

    public void setDoubleData(Double doubleData) {
        this.doubleData = doubleData;
    }

    public Date getUtDate() {
        return utDate;
    }

    public void setUtDate(Date utDate) {
        this.utDate = utDate;
    }

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

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }
}
