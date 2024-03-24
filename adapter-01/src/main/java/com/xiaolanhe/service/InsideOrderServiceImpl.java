package com.xiaolanhe.service;

import com.xiaolanhe.OrderAdapterService;

/**
 *@author: xiaolanhe
 *@createDate: 2024/3/24 21:54
 */
public class InsideOrderServiceImpl implements OrderAdapterService {

    private OrderService orderService = new OrderService();

    @Override
    public boolean isFirst(String uId) {
        long res = orderService.queryUserOrderCount(uId);
        return res <= 1;
    }
}
