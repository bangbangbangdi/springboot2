package com.atguigu.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.atguigu.admin.bean.City;

//@Mapper
public interface CityMapper {

    @Select("select * from city where id = #{id}")
    public City getById(Long id);

}
