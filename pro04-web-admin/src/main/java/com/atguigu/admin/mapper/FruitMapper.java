package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.Fruit;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface FruitMapper {

    public Fruit getFruit(Integer fid);

}
