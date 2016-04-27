package me.wbprime.springdbusecase.jpa.java.dao;


import me.wbprime.springdbusecase.jpa.java.models.Ping;

import java.util.List;

/**
 * Interface: PingDAO
 * Date: 2016/04/18 22:08
 *
 * @author Elvis Wang [mail@wbprime.me]
 */
public interface PingDAO {
    void insert(final Ping ping);

    List<Ping> findAll();

    Ping findOne(int id);

    void updateOne(final Ping ping);

    void deleteOne(final Ping id);
}
