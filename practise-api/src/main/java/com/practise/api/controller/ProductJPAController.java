package com.practise.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.api.model.ProductVO;
import com.practise.api.service.ProductJPAService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/data/productitem")
public class ProductJPAController {

	@Autowired
	ProductJPAService orderJPAService;

	@ApiOperation(value = "Get All Products. ")
	@GetMapping(value = "/product")
	public ResponseEntity<List<ProductVO>> getOrders() {

		return new ResponseEntity<List<ProductVO>>(orderJPAService.getOrders(), HttpStatus.OK);
	}

	@ApiOperation(value = "Create new Product with Item")
	@PostMapping(value = "/product")
	public ResponseEntity<Boolean> createOrder(@RequestBody ProductVO productVo) {

		return new ResponseEntity<Boolean>(orderJPAService.createOrder(productVo), HttpStatus.OK);
	}

	@ApiOperation(value = "Update  Product with Items")
	@PutMapping(value = "/product")
	public ResponseEntity<Boolean> updateOrder(@RequestBody ProductVO productVo) {
		return new ResponseEntity<Boolean>(orderJPAService.updateOrder(productVo), HttpStatus.OK);
	}

}
