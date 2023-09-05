package tw.blackbean.dao;

import java.util.List;
import tw.blackbean.model.ProductBasicDataBean;

public interface IProductDAO {
	public ProductBasicDataBean insert(ProductBasicDataBean saveBean);

	public ProductBasicDataBean selectById(int productid);
	
	public List<ProductBasicDataBean> selectByName(String keyword);

	public List<ProductBasicDataBean> selectAll();

//	public BlackBean update(int productid, int sellermemberid, String productname, int price, int specialprice,
//			int categoryid, int productdetailid, int quantity, String description);
	
	public ProductBasicDataBean update(ProductBasicDataBean saveBean);


	public boolean delectById(int productid);

}
