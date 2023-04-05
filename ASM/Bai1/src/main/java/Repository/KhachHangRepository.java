package Repository;


import domain_model.KhachHang;
import domain_model.MauSac;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;
import java.util.List;

public class KhachHangRepository {
    private Session hSession;

    public KhachHangRepository()
    {
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }

    public void insert(KhachHang kh)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }


    public void update(KhachHang kh)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(KhachHang kh)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(kh);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public KhachHang findById(String id) {
        return this.hSession.find(KhachHang.class, id);
    }

    public List<KhachHang> findAll() {
        String hql = "SELECT obj FROM KhachHang obj";
        TypedQuery<KhachHang> query = this.hSession.createQuery(hql, KhachHang.class);
        return query.getResultList();
    }

    public KhachHang findByMa(Integer id)
    {
        String hql = "SELECT obj FROM KhachHang obj WHERE obj.Id = ?1";
        TypedQuery<KhachHang> query = this.hSession.createQuery(hql, KhachHang.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

}
