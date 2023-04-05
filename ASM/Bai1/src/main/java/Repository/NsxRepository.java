package Repository;



import domain_model.Nsx;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;


import java.util.List;

public class NsxRepository {
    private Session hSession;

    public NsxRepository()
    {
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }

    public void insert(Nsx nsx)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(Nsx nsx)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(Nsx nsx)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public Nsx findById(String id) {
        return this.hSession.find(Nsx.class, id);
    }

    public List<Nsx> findAll() {
        String hql = "SELECT obj FROM Nsx obj";
        TypedQuery<Nsx> query = this.hSession.createQuery(hql, Nsx.class);
        return query.getResultList();
    }

    public Nsx findByMa(Integer id)
    {
        String hql = "SELECT obj FROM Nsx obj WHERE obj.Id = ?1";
        TypedQuery<Nsx> query = this.hSession.createQuery(hql, Nsx.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }
}
