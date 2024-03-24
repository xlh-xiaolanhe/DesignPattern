package com.xiaolanhe.service;

import com.xiaolanhe.OrderAdapterService;

/**
 *@author: xiaolanhe
 *@createDate: 2024/3/24 21:57
 */
public class PopOrderAdapterServiceImpl implements OrderAdapterService {

    private POPOrderService popOrderService = new POPOrderService();

    @Override
    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }
}
