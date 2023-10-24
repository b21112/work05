package oit.is.apple.work05.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface FruitMapper {
    @Select("select * from fruit")
    ArrayList<Fruit> selectAllFruits();

    @Select("select * from fruit where id = #{id}")
    Fruit selectById(int id);

    @Delete("delete from fruit where id = #{id}")
    boolean deleteFruitById(int id);
}
