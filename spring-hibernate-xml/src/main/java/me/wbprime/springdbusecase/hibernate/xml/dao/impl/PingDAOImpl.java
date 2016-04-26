package me.wbprime.springdbusecase.hibernate.xml.dao.impl;


import me.wbprime.springdbusecase.hibernate.xml.dao.PingDAO;
import me.wbprime.springdbusecase.hibernate.xml.models.Ping;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class: PingDAOImpl
 * Date: 2016/04/26 18:33
 *
 * @author Elvis Wang [bo.wang35@renren-inc.com]
 */
public class PingDAOImpl implements PingDAO {
    private SessionFactory sessionFactory;

    public final void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(final Ping ping) {
        sessionFactory.getCurrentSession().save(ping);
    }

    @Override
    public List<Ping> findAll() {
        return sessionFactory.getCurrentSession().createQuery(
            "SELECT p FROM Ping p"
        ).list();
    }

    @Override
    public Ping findOne(final int id) {
        return sessionFactory.getCurrentSession().get(Ping.class, id);
    }

    @Override
    public void updateOne(final Ping ping) {
        sessionFactory.getCurrentSession().update(ping);
    }

    @Override
    public void deleteOne(final Ping ping) {
        sessionFactory.getCurrentSession().delete(ping);
    }
}
