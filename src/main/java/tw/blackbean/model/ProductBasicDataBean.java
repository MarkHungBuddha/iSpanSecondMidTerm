package tw.blackbean.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.StringJoiner;

@Entity
@Table(name = "ProductBasicData", schema = "dbo", catalog = "BlackBeanSkinDB")
public class ProductBasicDataBean {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "productid", nullable = false)
    private int productid;
    @Basic
    @Column(name = "sellermemberid", nullable = true)
    private Integer sellermemberid;
    @Basic
    @Column(name = "productname", nullable = true, length = 100)
    private String productname;
    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    private BigDecimal price;
    @Basic
    @Column(name = "specialprice", nullable = true, precision = 2)
    private BigDecimal specialprice;
    @Basic
    @Column(name = "categoryid", nullable = true)
    private Integer categoryid;
    @Basic
    @Column(name = "productdetailid", nullable = true)
    private Integer productdetailid;
    @Basic
    @Column(name = "quantity", nullable = true)
    private Integer quantity;
    @Basic
    @Column(name = "description", nullable = true, length = 400)
    private String description;

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public Integer getSellermemberid() {
        return sellermemberid;
    }

    public void setSellermemberid(Integer sellermemberid) {
        this.sellermemberid = sellermemberid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public BigDecimal getPrice() {
        return price;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSpecialprice() {
        return specialprice;
    }


    public void setSpecialprice(BigDecimal specialprice) {
        this.specialprice = specialprice;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getProductdetailid() {
        return productdetailid;
    }

    public void setProductdetailid(Integer productdetailid) {
        this.productdetailid = productdetailid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ProductBasicDataBean.class.getSimpleName() + "[", "]")
                .add("productid=" + productid)
                .add("sellermemberid=" + sellermemberid)
                .add("productname='" + productname + "'")
                .add("price=" + price)
                .add("specialprice=" + specialprice)
                .add("categoryid=" + categoryid)
                .add("productdetailid=" + productdetailid)
                .add("quantity=" + quantity)
                .add("description='" + description + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductBasicDataBean that = (ProductBasicDataBean) o;

        if (productid != that.productid) return false;
        if (sellermemberid != null ? !sellermemberid.equals(that.sellermemberid) : that.sellermemberid != null)
            return false;
        if (productname != null ? !productname.equals(that.productname) : that.productname != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (specialprice != null ? !specialprice.equals(that.specialprice) : that.specialprice != null) return false;
        if (categoryid != null ? !categoryid.equals(that.categoryid) : that.categoryid != null) return false;
        if (productdetailid != null ? !productdetailid.equals(that.productdetailid) : that.productdetailid != null)
            return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productid;
        result = 31 * result + (sellermemberid != null ? sellermemberid.hashCode() : 0);
        result = 31 * result + (productname != null ? productname.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (specialprice != null ? specialprice.hashCode() : 0);
        result = 31 * result + (categoryid != null ? categoryid.hashCode() : 0);
        result = 31 * result + (productdetailid != null ? productdetailid.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
