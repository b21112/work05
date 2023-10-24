package oit.is.apple.work05.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FruitMapper {
    @Select("select * from fruit")
    ArrayList<Fruit> selectAllFruits();
}
