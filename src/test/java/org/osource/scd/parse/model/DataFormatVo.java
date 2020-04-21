package org.osource.scd.parse.model;

import org.osource.scd.anno.Location;

import java.util.Date;

/**
 * @author James
 */
public class DataFormatVo {
    @Location(column = "A")
    private String name;

    @Location(column = "B")
    private String gender;

    private String province;

    private String city;

    @Location(column = "C")
    private String address;

    @Location(column = "D")
    private String phone;

    @Location(column = "E")
    private Date time;

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
