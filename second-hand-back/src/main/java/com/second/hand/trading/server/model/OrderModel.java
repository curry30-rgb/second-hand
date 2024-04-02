package com.second.hand.trading.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * sh_order
 * @author myl
 */
public class OrderModel implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 用户主键id
     */
    private Long userId;

    private UserModel user;

    /**
     * 闲置物品主键id
     */
    private Long idleId;

    private IdleItemModel idleItem;
    /**
     * 订单总价
     */
    private BigDecimal orderPrice;

    /**
     * 支付状态
     */
    private Byte paymentStatus;

    /**
     * 支付方式
     */
    private String paymentWay;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 支付时间
     */
    private Date paymentTime;

    /**
     * 订单状态
     */
    private Byte orderStatus;

    /**
     * 是否删除
     */
    private Byte isDeleted;


    private static final long serialVersionUID = 1L;



    private Integer num;
    private String label;
    private Double price;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Long getIdleId() {
        return idleId;
    }

    public void setIdleId(Long idleId) {
        this.idleId = idleId;
    }

    public IdleItemModel getIdleItem() {
        return idleItem;
    }

    public void setIdleItem(IdleItemModel idleItem) {
        this.idleItem = idleItem;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Byte getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Byte paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrderModel other = (OrderModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getIdleId() == null ? other.getIdleId() == null : this.getIdleId().equals(other.getIdleId()))
                && (this.getOrderPrice() == null ? other.getOrderPrice() == null : this.getOrderPrice().equals(other.getOrderPrice()))
                && (this.getPaymentStatus() == null ? other.getPaymentStatus() == null : this.getPaymentStatus().equals(other.getPaymentStatus()))
                && (this.getPaymentWay() == null ? other.getPaymentWay() == null : this.getPaymentWay().equals(other.getPaymentWay()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getPaymentTime() == null ? other.getPaymentTime() == null : this.getPaymentTime().equals(other.getPaymentTime()))
                && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
                && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
                && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
                && (this.getLabel() == null ? other.getLabel() == null : this.getLabel().equals(other.getLabel()))
                && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
                && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getIdleId() == null) ? 0 : getIdleId().hashCode());
        result = prime * result + ((getOrderPrice() == null) ? 0 : getOrderPrice().hashCode());
        result = prime * result + ((getPaymentStatus() == null) ? 0 : getPaymentStatus().hashCode());
        result = prime * result + ((getPaymentWay() == null) ? 0 : getPaymentWay().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getPaymentTime() == null) ? 0 : getPaymentTime().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getLabel() == null) ? 0 : getLabel().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", userId=").append(userId);
        sb.append(", idleId=").append(idleId);
        sb.append(", orderPrice=").append(orderPrice);
        sb.append(", paymentStatus=").append(paymentStatus);
        sb.append(", paymentWay=").append(paymentWay);
        sb.append(", createTime=").append(createTime);
        sb.append(", paymentTime=").append(paymentTime);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", num=").append(num);
        sb.append(", label=").append(label);
        sb.append(", price=").append(price);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}