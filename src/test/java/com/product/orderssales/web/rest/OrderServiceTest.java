package com.product.orderssales.web.rest;

import com.product.orderssales.domain.ProductSalesInfo;
import com.product.orderssales.service.OrderDAO;
import com.product.orderssales.service.OrderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Date;

public class OrderServiceTest {

    @Mock
    OrderDAO orderDAO;

    @InjectMocks
    OrderService orderService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(OrderServiceTest.class);
    }

    @Test
    public void testGetAllOrdersNull() {
        Mockito.when(orderDAO.getAllOrders()).thenReturn(null);
        Assert.assertNull(orderService.getAllOrders());
    }

    @Test
    public void testGetAllOrdersEmpty() {
        Mockito.when(orderDAO.getAllOrders()).thenReturn(Collections.emptyList());
        Assert.assertEquals(0, orderService.getAllOrders().size());
    }

    @Test
    public void testGetAllOrdersSingleValueReturned() {
        ProductSalesInfo build = new ProductSalesInfo.ProductSalesInfoBuilder(1l, "", new Date(), new Date()).build();
        Mockito.when(orderDAO.getAllOrders()).thenReturn(Collections.singletonList(build));
        Assert.assertEquals(1, orderService.getAllOrders().size());
    }
}
