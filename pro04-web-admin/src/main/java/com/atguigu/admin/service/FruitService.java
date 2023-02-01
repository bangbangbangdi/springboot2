package com.atguigu.admin.service;

import com.atguigu.admin.bean.Fruit;
import com.atguigu.admin.mapper.FruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

    @Autowired
    FruitMapper fruitMapper;

    public Fruit getFruitById(Integer id){
        return fruitMapper.getFruit(id);
    }

}
