package org.osource.scd.parse.model;

import org.osource.scd.anno.Location;

import java.util.Date;

public class Label  {

    @Location(column = "A")
    private Long id;

    @Location(column = "E")
    private int type;

    @Location(column = "C")
    private String code;

    @Location(column = "D")
    private int status;

    @Location(column = "B")
    private Long parent;

    private Date date;

    @Location(column = "I")
    private Long userId;

    @Location(column = "F")
    private Long customerId;

    private Long productId;
    private int queryTimes;
    private Date firstTime;

    @Location(column = "N")
    private Date createTime;

    @Location(column = "O")
    private Date updateTime;

    @Location(column = "G")
    private Long operatorId;

    @Location(column = "H")
    private Long resellerId;

    @Location(column = "K")
    private int batch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public int getQueryTimes() {
        return queryTimes;
    }

    public void setQueryTimes(int queryTimes) {
        this.queryTimes = queryTimes;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public Long getResellerId() {
        return resellerId;
    }

    public void setResellerId(Long resellerId) {
        this.resellerId = resellerId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }
}
