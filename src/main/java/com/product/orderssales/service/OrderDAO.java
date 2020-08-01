package com.product.orderssales.service;

import com.product.orderssales.domain.ProductSalesInfo;

import java.util.List;

public interface OrderDAO {

    public List<ProductSalesInfo> getAllOrders();
}
