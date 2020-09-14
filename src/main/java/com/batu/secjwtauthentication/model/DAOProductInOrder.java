package com.batu.secjwtauthentication.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "productInOrder")
public class DAOProductInOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "cart_id") //böyle dersek databasede joinliyo yani databasedeki name vermek lazım
	@JsonIgnore
	private DAOCart cart;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private DAOOrderMain orderMain;
	
	@NotEmpty
    private String productId;


	@NotEmpty
    private String productName;

 
	@NotEmpty
    private String productDescription;




    @NotNull
    private Integer categoryType;


    @NotNull
    private BigDecimal productPrice;

 
    @Min(0)
    private Integer productStock;

    @Min(1)
    private Integer count;
	
    
    
    public DAOProductInOrder(DAOProductInfo productInfo, Integer quantity) {
        this.productId = productInfo.getProductId();
        this.productName = productInfo.getProductName();
        this.productDescription = productInfo.getProductDescription();
        this.categoryType = productInfo.getCategoryType();
        this.productPrice = productInfo.getProductPrice();
        this.productStock = productInfo.getProductStock();
        this.count = quantity;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DAOProductInOrder that = (DAOProductInOrder) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productDescription, that.productDescription) &&
                Objects.equals(categoryType, that.categoryType) &&
                Objects.equals(productPrice, that.productPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), id, productId, productName, productDescription, categoryType, productPrice);
    }

	public DAOCart getCart() {
		return cart;
	}

	public void setCart(DAOCart cart) {
		this.cart = cart;
	}

	public DAOOrderMain getOrderMain() {
		return orderMain;
	}

	public void setOrderMain(DAOOrderMain orderMain) {
		this.orderMain = orderMain;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductStock() {
		return productStock;
	}

	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "DAOProductInOrder [id=" + id + ", cart=" + cart + ", orderMain=" + orderMain + ", productId="
				+ productId + ", productName=" + productName + ", productDescription=" + productDescription
				+ ", categoryType=" + categoryType + ", productPrice=" + productPrice + ", productStock=" + productStock
				+ ", count=" + count + "]";
	}
    
    
    
    
    
    
	

}
