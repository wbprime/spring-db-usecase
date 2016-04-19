package me.wbprime.springdbusecase.mybatis.java.dao;


import me.wbprime.springdbusecase.mybatis.java.models.Ping;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Note: Do not use Spring's context:component-scan to scan this interface
 *
 * Interface: PingDAO
 * Date: 2016/04/18 22:08
 *
 * @author Elvis Wang [mail@wbprime.me]
 */
@Repository
public interface PingDAO {
    @Insert("" +
        "INSERT INTO " +
        " pings " +
        " (title, description, create_time) " +
        " VALUES (#{title}, #{description}, now())" +
        ";"
    )
    @Options(useGeneratedKeys = true)
    void insert(final Ping ping);

    @Select("" +
        " SELECT " +
        " id, title, description " +
        " FROM " +
        " pings " +
        ";"
    )
    List<Ping> findAll();

    @Select("" +
        " SELECT " +
        " id, title, description " +
        " FROM " +
        " pings " +
        " WHERE id = #{id} " +
        ";"
    )
    Ping findOne(int id);

    @Update("" +
        " UPDATE " +
        " pings " +
        " SET title = #{title}, description = #{description} " +
        " WHERE id = #{id} " +
        ";"
    )
    void updateOne(final Ping ping);

    @Delete("" +
        " DELETE FROM " +
        " pings " +
        " WHERE id = #{id}" +
        ";"
    )
    void deleteOne(int id);
}
