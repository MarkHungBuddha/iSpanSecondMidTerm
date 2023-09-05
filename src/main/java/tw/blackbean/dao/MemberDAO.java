package tw.blackbean.dao;

import tw.blackbean.model.MemberData;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberDAO implements iMemberDAO {

    @Override
    public boolean delete(long memberId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            MemberData member = session.get(MemberData.class, memberId);
            if (member != null) {
                session.delete(member);
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<MemberData> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from MemberData", MemberData.class).list();
        }
    }

    @Override
    public MemberData findById(long memberId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(MemberData.class, memberId);
        }
    }

    @Override
    public MemberData findByemailAndpasswd(String email, String passwd) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<MemberData> query = session.createQuery("from MemberData where email = :email and passwd = :passwd", MemberData.class);
            query.setParameter("email", email);
            query.setParameter("passwd", passwd);
            return query.uniqueResult();
        }
    }


    @Override
    public boolean update(MemberData memberData) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(memberData);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean save(MemberData member) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(member);
            transaction.commit();
            return true;
        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isExistEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from MemberData where email = :email", MemberData.class)
                    .setParameter("email", email)
                    .uniqueResult() != null;
        }
    }

    @Override
    public boolean isExistMember(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from MemberData where username = :username", MemberData.class)
                    .setParameter("username", username)
                    .uniqueResult() != null;
        }
    }
}


