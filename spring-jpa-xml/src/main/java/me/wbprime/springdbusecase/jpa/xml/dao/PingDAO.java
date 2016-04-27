package me.wbprime.springdbusecase.jpa.xml.dao;


import me.wbprime.springdbusecase.jpa.xml.models.Ping;

import java.util.List;

/**
 * Note: Do not use Spring's context:component-scan to scan this interface
 *
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

    void deleteOne(final Ping ping);
}
