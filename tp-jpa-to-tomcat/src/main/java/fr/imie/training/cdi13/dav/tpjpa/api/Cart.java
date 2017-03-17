package fr.imie.training.cdi13.dav.tpjpa.api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carts")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy="cart")
	private List<Product> productList = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Product> getProductList() {
		if (this.productList == null) {
			this.productList = new ArrayList<>();
		}
		return this.productList;
	}

	public void addProduct(Product product) {
		this.productList.add(product);
//		product.setCart(this);
	}

	public void removeProduct(Product product) {
		this.productList.remove(product);
//		product.setCart(null);
	}

}
