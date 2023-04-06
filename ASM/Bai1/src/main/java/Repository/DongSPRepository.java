package Repository;


import domain_model.DongSp;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;
import view_model.QLDongSP;

import java.util.ArrayList;
import java.util.List;

public class DongSPRepository {
    private Session hSession;

    public DongSPRepository()
    {
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }

    public void insert(DongSp ms)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(DongSp ms)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(DongSp ms)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public DongSp findById(String id) {
        return this.hSession.find(DongSp.class, id);
    }

    public List<DongSp> findAll() {
        String hql = "SELECT obj FROM DongSp obj";
        TypedQuery<DongSp> query = this.hSession.createQuery(hql, DongSp.class);
        return query.getResultList();
    }

    public DongSp findByMa(String ma)
    {
        String hql = "SELECT obj FROM DongSp obj WHERE obj.Ma = ?1";
        TypedQuery<DongSp> query = this.hSession.createQuery(hql, DongSp.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
