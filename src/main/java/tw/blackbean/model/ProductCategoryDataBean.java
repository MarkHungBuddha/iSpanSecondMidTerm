package tw.blackbean.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ProductCategoryData", schema = "dbo", catalog = "BlackBeanSkinDB2")
public class ProductCategoryDataBean {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "categoryid", nullable = false)
    private int categoryid;
    @Basic
    @Column(name = "categoryname", nullable = true, length = 50)
    private String categoryname;
    @Basic
    @Column(name = "parentcategoryid", nullable = true)
    private Integer parentcategoryid;

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Integer getParentcategoryid() {
        return parentcategoryid;
    }

    public void setParentcategoryid(Integer parentcategoryid) {
        this.parentcategoryid = parentcategoryid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCategoryDataBean that = (ProductCategoryDataBean) o;

        if (categoryid != that.categoryid) return false;
        if (categoryname != null ? !categoryname.equals(that.categoryname) : that.categoryname != null) return false;
        if (parentcategoryid != null ? !parentcategoryid.equals(that.parentcategoryid) : that.parentcategoryid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryid;
        result = 31 * result + (categoryname != null ? categoryname.hashCode() : 0);
        result = 31 * result + (parentcategoryid != null ? parentcategoryid.hashCode() : 0);
        return result;
    }
}
