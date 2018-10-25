package ru.psyfabriq.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.psyfabriq.dao.exeption.DataAccessLayerException;
import ru.psyfabriq.util.HibernateUtil;

public abstract class AbstractDAO {
    protected Session session;
    protected Transaction tx;

    public AbstractDAO() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    protected void handleException(HibernateException e) throws DataAccessLayerException {
        tx.rollback();
        throw new DataAccessLayerException(e);
    }

    protected void handleExceptionQuery(HibernateException e) throws DataAccessLayerException {
        throw new DataAccessLayerException(e);
    }

    protected void startOperation() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    protected void startTransaction() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

}
