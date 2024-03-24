package com.xiaolanhe;

/**
 * @author xiaolanhe
 * @version V1.0
 * @Package com.xiaolanhe
 * @date 2024/3/24 21:52
 */

// 定义统一适配接口
public interface OrderAdapterService {
    /**
     * 判断是否首单
     * @param uId 用户ID
     * @return
     */
    boolean isFirst(String uId);
}
