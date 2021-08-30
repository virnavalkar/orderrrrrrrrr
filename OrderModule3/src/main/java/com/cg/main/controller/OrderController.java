package com.cg.main.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.main.exception.OrderNotFoundException;
import com.cg.main.beans.Order;
import com.cg.main.service.IOrderServiceImpl;
import com.cg.main.service.IOrderServiceIntf;

import java.util.List;



@RestController
public class OrderController {


@Autowired
   private IOrderServiceImpl iosi;

@PostMapping("/addOrder")
public void addOrder(@RequestBody Order order)
{
	 iosi.addOrder(order);

}
	@DeleteMapping("/removeOrder/{orderId}")
public void remove(@PathVariable Long orderId)
{
	iosi.removeOrder(orderId);
	}

	@PutMapping("/updateOrder/{orderId}")
public void update(@PathVariable Long orderId,@RequestBody Order order)
{
	iosi.updateOrder(orderId, order);
	
	}
	
	@GetMapping("/getOrder/{orderId}")	
public Order get(@PathVariable Long orderId)
{
	return	iosi.getOrderDetails(orderId);
		}
	
	@GetMapping("/getAllOrders")
	public List<Order> getAllOrders(){

		return iosi.getAllOrders();
		}
	

}

