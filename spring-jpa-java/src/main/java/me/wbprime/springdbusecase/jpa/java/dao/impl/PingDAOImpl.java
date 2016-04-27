package me.wbprime.springdbusecase.jpa.java.dao.impl;


import me.wbprime.springdbusecase.jpa.java.dao.PingDAO;
import me.wbprime.springdbusecase.jpa.java.models.Ping;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Class: PingDAOImpl
 * Date: 2016/04/26 18:33
 *
 * @author Elvis Wang [bo.wang35@renren-inc.com]
 */
@Repository("pingDAOImpl")
public class PingDAOImpl implements PingDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(final Ping ping) {
        entityManager.persist(ping);
        entityManager.flush();
    }

    @Override
    public List<Ping> findAll() {
        return entityManager.createQuery(
            "SELECT p FROM Ping p", Ping.class
        ).getResultList();
    }

    @Override
    public Ping findOne(final int id) {
        return entityManager.find(Ping.class, id);
    }

    @Override
    public void updateOne(final Ping ping) {
        entityManager.persist(ping);
        entityManager.flush();
    }

    @Override
    public void deleteOne(final Ping ping) {
        entityManager.remove(ping);
        entityManager.flush();
    }
}
