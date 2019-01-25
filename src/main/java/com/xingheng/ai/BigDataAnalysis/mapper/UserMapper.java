package com.xingheng.ai.BigDataAnalysis.mapper;

import com.xingheng.ai.BigDataAnalysis.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * 访问数据库的接口
 * @author: lym
 * @Date:2019/1/23 18 04
 * @Description:
 */
@Mapper
public interface UserMapper {


	//推荐使用#{}取值，不要用${},因为存在注入的风险

	/**
	 * 插入新数据
	 * @param user
	 * @return
	 */
	@Insert("INSERT INTO user(name,phone,create_time,age) VALUES(#{name}, #{phone}, #{createTime},#{age})")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")   //keyProperty java对象的属性；keyColumn表示数据库的字段
	int insert(User user);


	/**
	 * 查询全部
	 * @return
	 */
    @Select("SELECT * FROM user")
    @Results({
        @Result(column = "create_time",property = "createTime")  //javaType = java.util.Date.class
    })
	List<User> getAll();


	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
    	 @Result(column = "create_time",property = "createTime")
    })
    User findById(Long id);

	/**
	 * 根据id修改姓名
	 * @param user
	 */
    @Update("UPDATE user SET name=#{name} WHERE id =#{id}")
    void update(User user);


	/**
	 * 根据id删除
	 * @param userId
	 */
    @Delete("DELETE FROM user WHERE id =#{userId}")
    void delete(Long userId);


}
