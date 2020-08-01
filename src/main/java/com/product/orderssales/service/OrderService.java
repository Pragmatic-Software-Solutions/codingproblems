package com.product.orderssales.service;

import com.product.orderssales.domain.ProductSalesInfo;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<ProductSalesInfo> getAllOrders();

    Map<Integer, Long> aggregateUnitsSoldPerYear(List<ProductSalesInfo> records);

    Map<String, Double> aggregateOrdersByItemTypeProfit(List<ProductSalesInfo> records);
}
