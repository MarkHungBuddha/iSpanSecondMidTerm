package tw.blackbean.dao;

import org.hibernate.Session;
import tw.blackbean.model.MemberData;
import tw.blackbean.model.ProductCategoryDataBean;

import java.util.List;

public class ProductCategoryDAO implements iProductCategoryDAO
{
    @Override
    public ProductCategoryDataBean selectById(int categoryid) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(ProductCategoryDataBean.class, categoryid);
        }    }

    @Override
    public List<ProductCategoryDataBean> selectAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ProductCategoryDataBean", ProductCategoryDataBean.class).list();
        }
    }
}
