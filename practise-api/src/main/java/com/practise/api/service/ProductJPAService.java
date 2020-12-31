package com.practise.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.api.jpa.entity.Item;
import com.practise.api.jpa.entity.Product;
import com.practise.api.model.ItemVO;
import com.practise.api.model.ProductVO;
import com.practise.api.repositories.ProductRepoDAO;

@Service
public class ProductJPAService {

	@Autowired
	ProductRepoDAO orderRepoDAO;

	public List<ProductVO> getOrders() {

		List<Product> lstProd = orderRepoDAO.getAllProductWithItems();

		List<ProductVO> lst = new ArrayList<ProductVO>();

		for (Product product : lstProd) {

			ProductVO productVO = new ProductVO();

			productVO.setProductId(product.getProductId());
			productVO.setName(product.getName());

			for (Item item : product.getItem()) {
				ItemVO itemVO = new ItemVO();
				itemVO.setItemId(item.getItemId());
				itemVO.setName(item.getName());
				productVO.getItem().add(itemVO);
			}

			lst.add(productVO);

		}
		return lst;
	}

	public boolean createOrder(ProductVO productVo) {

		Product product = new Product();

		product.setName(productVo.getName());

		for (ItemVO item : productVo.getItem()) {
			Item itemEntity = new Item();
			itemEntity.setName(item.getName());
			itemEntity.setProduct(product);

			product.getItem().add(itemEntity);

		}

		orderRepoDAO.save(product);

		return true;
	}

	public boolean updateOrder(ProductVO productVo) {

		Product product = orderRepoDAO.findById(productVo.getProductId()).get();

		product.setName(productVo.getName());

		if (productVo.getItem() != null) {
			product.getItem().clear();
			for (ItemVO item : productVo.getItem()) {
				Item itemEntity = new Item();
				itemEntity.setItemId(item.getItemId());
				itemEntity.setName(item.getName());
				itemEntity.setProduct(product);
				
				
				product.getItem().add(itemEntity);

			}
		}
		orderRepoDAO.save(product);

		return true;
	}

	public boolean deleteOrder(long productid) {

		Product product = new Product();

		product.setProductId(productid);
		// product.setName(productVo.getName());

		orderRepoDAO.delete(product);

		return true;
	}

}
