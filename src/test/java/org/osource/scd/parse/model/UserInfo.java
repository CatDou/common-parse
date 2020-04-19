package org.osource.scd.parse.model;

import org.osource.scd.anno.Location;

/**
 * @author chengdu
 *
 */
public class UserInfo {
    @Location(column = "A")
    private String name;
    @Location(column = "B")
    private String gender;
    @Location(column = "C")
    private String num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
