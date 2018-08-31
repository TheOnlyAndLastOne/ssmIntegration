package com.own.mvcmybatis.service.impl;

import com.own.mvcmybatis.dao.ItemsMapper;
import com.own.mvcmybatis.pojo.Items;
import com.own.mvcmybatis.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: zhaozhi
 * @Date: 2018/8/24 0024 9:46
 * @Description:
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsMapper itemMapper;

    //查询商品列表
    public List<Items> selectItemsList(){
        return itemMapper.selectByExampleWithBLOBs(null);
    }

    public Items selectItemsById(Integer id){
        return itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateitem(Items items) {
        items.setCreatetime(new Date());
        return itemMapper.updateByPrimaryKeyWithBLOBs(items);
    }
}
