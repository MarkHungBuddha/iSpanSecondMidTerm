package tw.blackbean.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import tw.blackbean.model.ProductBasicDataBean;

import java.util.List;

public class ProductDAO implements IProductDAO {


    // 新增
    @Override
    public ProductBasicDataBean insert(ProductBasicDataBean saveBean) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            ProductBasicDataBean resultBean = session.get(ProductBasicDataBean.class, saveBean.getProductid());
            if (resultBean == null) {
                session.persist(saveBean);
                transaction.commit();
                return saveBean;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    // ID單筆查詢
    @Override
    public ProductBasicDataBean selectById(int productid) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(ProductBasicDataBean.class, productid);
        }
    }

    // 關鍵字名字查詢
    @Override
    public List<ProductBasicDataBean> selectByName(String keyword) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from ProductBasicDataBean where productname like :keyword";
            Query<ProductBasicDataBean> query = session.createQuery(hql, ProductBasicDataBean.class);
            query.setParameter("keyword", "%" + keyword + "%");
            return query.list();
        }
    }

    // 全部查詢
    @Override
    public List<ProductBasicDataBean> selectAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ProductBasicDataBean", ProductBasicDataBean.class).list();
        }
    }

    // 修改
//	@Override
//	public BlackBean update(int productid, int sellermemberid, String productname, int price, int specialprice,
//			int categoryid, int productdetailid, int quantity, String description) {
//		BlackBean resultBean = session.get(BlackBean.class, productid);
//		if (resultBean != null) {
//			resultBean.setSellermemberid(sellermemberid);
//			resultBean.setProductname(productname);
//			resultBean.setPrice(price);
//			resultBean.setSpecialprice(specialprice);
//			resultBean.setCategoryid(categoryid);
//			resultBean.setProductdetailid(productdetailid);
//			resultBean.setQuantity(quantity);
//			resultBean.setDescription(description);
//			session.merge(resultBean);
//			session.flush();
//		}
//		return resultBean;
//	}
    // 修改

    @Override
    public ProductBasicDataBean update(ProductBasicDataBean saveBean) {
        Transaction transaction = null;
        System.out.println("Transaction transaction = null;");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Transaction transaction = null;");
            transaction = session.beginTransaction();
            System.out.println("Transaction transaction = null;");
            ProductBasicDataBean resultBean = session.get(ProductBasicDataBean.class, saveBean.getProductid());
            System.out.println("Transaction transaction = null;");
            if (resultBean != null) {
                System.out.println("Transaction transaction = null;");
                session.merge(saveBean);
                System.out.println("Transaction transaction = null;");
                transaction.commit();
                System.out.println("Transaction transaction = null;");
                System.out.println("Transaction transaction = null;");
                return saveBean;

            }
        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
            e.printStackTrace();
        }
        return null;
    }

    // 刪除
    @Override
    public boolean delectById(int productid) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            ProductBasicDataBean resultBean = session.get(ProductBasicDataBean.class, productid);
            if (resultBean != null) {
                session.remove(resultBean);
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

}
