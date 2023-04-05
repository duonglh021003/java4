package Repository;




import domain_model.MauSac;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;
import java.util.List;

public class MauSacRepository {
    private Session hSession;

    public MauSacRepository()
    {
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }

    public void insert(MauSac ms)
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

    public void update(MauSac ms)
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

    public void delete(MauSac ms)
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

    public MauSac findById(String id) {
        return this.hSession.find(MauSac.class, id);
    }

    public List<MauSac> findAll() {
        String hql = "SELECT obj FROM MauSac obj";
        TypedQuery<MauSac> query = this.hSession.createQuery(hql, MauSac.class);
        return query.getResultList();
    }

    public MauSac findByMa(Integer id)
    {
        String hql = "SELECT obj FROM MauSac obj WHERE obj.Id = ?1";
        TypedQuery<MauSac> query = this.hSession.createQuery(hql, MauSac.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }
}
