package org.sl.food.mapper;

import org.sl.food.entity.FoodEntity;

public interface FoodEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(FoodEntity record);

    int insertSelective(FoodEntity record);

    FoodEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FoodEntity record);

    int updateByPrimaryKey(FoodEntity record);
}