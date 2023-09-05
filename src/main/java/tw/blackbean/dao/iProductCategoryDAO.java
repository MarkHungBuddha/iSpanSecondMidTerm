package tw.blackbean.dao;

import tw.blackbean.model.ProductCategoryDataBean;

import java.util.List;

public interface iProductCategoryDAO {
    ProductCategoryDataBean selectById(int productid);

    List<ProductCategoryDataBean> selectAll();
}
