package me.wbprime.springdbusecase.jpa.xml.dao.impl;


import me.wbprime.springdbusecase.jpa.xml.dao.PingDAO;
import me.wbprime.springdbusecase.jpa.xml.models.Ping;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Class: PingDAOImpl
 * Date: 2016/04/26 18:33
 *
 * @author Elvis Wang [bo.wang35@renren-inc.com]
 */
public class PingDAOImpl implements PingDAO {
    private EntityManager entityManager;

    public final void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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
