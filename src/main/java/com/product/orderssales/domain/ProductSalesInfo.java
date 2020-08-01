package com.product.orderssales.domain;

import java.util.Date;

public class ProductSalesInfo {


    private ProductSalesInfo(ProductSalesInfoBuilder builder) {
        this.orderId = builder.orderId;
        this.region = builder.region;
        this.country = builder.country;
        this.itemType = builder.itemType;
        this.orderDate = builder.orderDate;
        this.shipDate = builder.shipDate;
        this.profit = builder.profit;
        this.unitsSold = builder.unitsSold;
    }

    //    Region	Country	Item Type	Sales Channel
    //    Order Priority	Order Date	Order ID	Ship Date
    //    Units Sold	Unit Price	Unit Cost	Total Revenue	Total Cost	Total Profit
    private long orderId;
    private String region;
    private String country;
    private String itemType;
    private Date orderDate;
    private Date shipDate;
    private Double profit;
    private long unitsSold;


    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public long getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(long unitsSold) {
        this.unitsSold = unitsSold;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProductSalesInfo{");
        sb.append("orderId=").append(orderId);
        sb.append(", region='").append(region).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", itemType='").append(itemType).append('\'');
        sb.append(", orderDate=").append(orderDate);
        sb.append(", shipDate=").append(shipDate);
        sb.append(", profit=").append(profit);
        sb.append(", unitsSold=").append(unitsSold);
        sb.append('}');
        return sb.toString();
    }

    public static class ProductSalesInfoBuilder {
        private long orderId; // required
        private String region;
        private String country;
        private String itemType; //required
        private Date orderDate; //required
        private Date shipDate; //required
        private Double profit;
        private long unitsSold;

        public ProductSalesInfo build() {
            ProductSalesInfo productSalesInfo = new ProductSalesInfo(this);
            validateObject(productSalesInfo);
            return productSalesInfo;
        }

        public ProductSalesInfoBuilder(Long orderId, String itemType, Date orderDate, Date shipDate) {
            this.orderDate = orderDate;
            this.shipDate = shipDate;
            this.orderId = orderId;
            this.itemType = itemType;
        }

        public ProductSalesInfoBuilder region(String age) {
            this.region = region;
            return this;
        }

        public ProductSalesInfoBuilder country(String country) {
            this.country = country;
            return this;
        }

        public ProductSalesInfoBuilder profit(Double profit) {
            this.profit = profit;
            return this;
        }

        public ProductSalesInfoBuilder unitsSold(Long profit) {
            this.unitsSold = unitsSold;
            return this;
        }


        private void validateObject(ProductSalesInfo user) {
            //Do some basic validations to check
            //if ProductSalesInfo object does not break any assumption of system
        }
    }


}
