package Repository;


import domain_model.NhanVien;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;
import view_model.QLKhachHang;
import view_model.QLNhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {

    private Session hSession;

    public NhanVienRepository()
    {
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }

    public void insert(NhanVien nv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(NhanVien nv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(NhanVien nv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public NhanVien login(String ma, String matKhau)
    {
        String hql = "SELECT nv FROM NhanVien nv WHERE nv.ma = ?1 AND nv.matKhau = ?2";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        query.setParameter(1, ma);
        query.setParameter(2, matKhau);
        try {
            NhanVien nv = query.getSingleResult();
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    public NhanVien findById(Integer id) {
        return this.hSession.find(NhanVien.class, id);
    }

    public List<NhanVien> findAll() {

        String hql = "SELECT obj FROM NhanVien obj";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        return query.getResultList();


    }

    public NhanVien findByMa(String ma)
    {
        String hql = "SELECT obj FROM NhanVien obj WHERE obj.ma = ?1";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }


}
