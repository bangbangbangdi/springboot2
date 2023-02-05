package com.atguigu.admin.service.impl;

import com.atguigu.admin.bean.Fruit;
import com.atguigu.admin.mapper.FruitMapper;
import com.atguigu.admin.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitServiceImpl implements FruitService {

    @Autowired
    FruitMapper fruitMapper;

    public Fruit getFruitById(Integer id){
        return fruitMapper.getFruit(id);
    }

}
