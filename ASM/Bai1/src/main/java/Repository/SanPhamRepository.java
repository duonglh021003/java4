package Repository;


import domain_model.SanPham;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import javax.swing.*;
import java.util.List;

public class SanPhamRepository {

    private Session hSession;

    public SanPhamRepository()
    {
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }

    public void insert(SanPham sp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(SanPham sp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(SanPham sp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(sp);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public SanPham findById(String id) {
        return this.hSession.find(SanPham.class, id);
    }

    public List<SanPham> findAll() {
        String hql = "SELECT obj FROM SanPham obj";
        TypedQuery<SanPham> query = this.hSession.createQuery(hql, SanPham.class);
        return query.getResultList();
    }

    public SanPham findByMa(String ma)
    {
        String hql = "SELECT obj FROM SanPham obj WHERE obj.Ma = ?1";
        TypedQuery<SanPham> query = this.hSession.createQuery(hql, SanPham.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
