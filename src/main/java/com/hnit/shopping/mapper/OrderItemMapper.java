package com.hnit.shopping.mapper;

import java.util.List;

import com.hnit.shopping.entity.OrderItem;

public interface OrderItemMapper {

	int addItems(List<OrderItem> items);
}
