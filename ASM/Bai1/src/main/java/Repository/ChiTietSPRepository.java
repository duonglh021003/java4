package Repository;

import domain_model.*;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {
    private Session hSession;

    public ChiTietSPRepository()
    {
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }

    public void insert(ChiTietSp ctsp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(ChiTietSp ctsp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(ChiTietSp ctsp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public ChiTietSp findById(String id) {
        return this.hSession.find(ChiTietSp.class, id);
    }

    public List<ChiTietSp> findAll() {

        String hql = "SELECT obj FROM ChiTietSp obj";
        TypedQuery<ChiTietSp> query = this.hSession.createQuery(hql, ChiTietSp.class);
        return query.getResultList();


    }

    public ChiTietSp findByMa(Integer id)
    {
        String hql = "SELECT obj FROM ChiTietSp obj WHERE obj.Id = ?1";
        TypedQuery<ChiTietSp> query = this.hSession.createQuery(hql, ChiTietSp.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }
}
