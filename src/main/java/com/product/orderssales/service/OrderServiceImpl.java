package com.product.orderssales.service;

import com.product.orderssales.domain.ProductSalesInfo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public List<ProductSalesInfo> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    public Map<Integer, Long> aggregateUnitsSoldPerYear(List<ProductSalesInfo> records) {
        return records.stream()
                .collect(Collectors.groupingBy(o -> o.getOrderDate().getYear(), Collectors.summingLong(ProductSalesInfo::getUnitsSold)));
    }

    @Override
    public Map<String, Double> aggregateOrdersByItemTypeProfit(List<ProductSalesInfo> records) {
        return records.stream()
                .collect(Collectors.groupingBy(ProductSalesInfo::getItemType, Collectors.summingDouble(ProductSalesInfo::getProfit)));
    }

}
