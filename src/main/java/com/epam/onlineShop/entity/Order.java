package com.epam.onlineShop.entity;

import java.sql.Timestamp;

public class Order {
    private long id;
    private Timestamp dateTime;
    private long statusId;
    private long deliveryAddressId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public long getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setDeliveryAddressId(long deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }
}
