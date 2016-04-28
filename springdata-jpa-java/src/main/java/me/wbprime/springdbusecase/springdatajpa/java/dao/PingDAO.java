package me.wbprime.springdbusecase.springdatajpa.java.dao;


import me.wbprime.springdbusecase.springdatajpa.java.models.Ping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface: PingDAO
 * Date: 2016/04/18 22:08
 *
 * @author Elvis Wang [mail@wbprime.me]
 */
public interface PingDAO extends JpaRepository<Ping, Integer> {
    List<Ping> findAll();

    Ping findOne(Integer id);

    void delete(final Ping id);
}
