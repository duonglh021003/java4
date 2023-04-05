package Repository;


import domain_model.ChucVu;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.List;

public class ChucVuRepository {
    private Session hSession;

    public ChucVuRepository()
    {
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }

    public void insert(ChucVu cv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(ChucVu cv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(ChucVu cv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public ChucVu findById(String id) {
        return this.hSession.find(ChucVu.class, id);
    }

    public List<ChucVu> findAll() {
        String hql = "SELECT obj FROM ChucVu obj";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql, ChucVu.class);
        return query.getResultList();
    }

    public ChucVu findByMa(Integer id)
    {
        String hql = "SELECT obj FROM ChucVu obj WHERE obj.Id = ?1";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql, ChucVu.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }
}
