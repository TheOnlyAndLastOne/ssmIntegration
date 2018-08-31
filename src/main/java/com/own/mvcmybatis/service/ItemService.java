package com.own.mvcmybatis.service;

import com.own.mvcmybatis.pojo.Items;

import java.util.List;

/**
 * @Author: zhaozhi
 * @Date: 2018/8/24 0024 9:46
 * @Description:
 */
public interface ItemService {
    List<Items> selectItemsList();

    Items selectItemsById(Integer id);

    int updateitem(Items items);
}
