package com.cg.main.service;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.main.exception.OrderNotFoundException;
import com.cg.main.exception.PaymentMethodEmptyException;
import com.cg.main.beans.Order;
import com.cg.main.exception.ImproperPaymentMethodException;
import com.cg.main.repository.IOrderRepositoryIntf;

@Service
public class IOrderServiceImpl implements IOrderServiceIntf {
	
	@Autowired
	private IOrderRepositoryIntf orderrepository;
	
	

	@Override
	public Order addOrder(Order order) {
		try {
            if(order.getPaymentMethod().isBlank()|| order.getPaymentMethod().length()==0) {
                throw new PaymentMethodEmptyException("Payment Method is empty, Please provide proper Payment Method !");
            }
            return orderrepository.saveAndFlush(order);

        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
	}
//		if(order.getPaymentMethod().compareToIgnoreCase("offline")==0||order.getPaymentMethod().compareToIgnoreCase("online")==0)
//		{
//			orderrepository.saveAndFlush(order);
//			return order;
//		}
//		try {
//			(order.getPaymentMethod().compareToIgnoreCase("offline")!=0||order.getPaymentMethod().compareToIgnoreCase("online")!=0)
//		};
//		throw new ImproperPaymentMethodException("Payment method improper");
//	}
		
	

	@Override
	public Order removeOrder(Long orderId) {
		Order retrievedOrderVal=null;
		try {
			retrievedOrderVal=orderrepository.findById(orderId).orElseThrow(()-> new OrderNotFoundException("Order details not found"));
			 orderrepository.deleteById(orderId);
			 return retrievedOrderVal;
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			return null;
			}
		}
		 


	@Override
	public void updateOrder(Long orderId,Order order) {	
		 orderrepository.deleteById(orderId);
		 orderrepository.saveAndFlush(order);
//		orderrepository.findById(orderId).get().UpdateWold(order.getAmount(),order.getBillingDate(),order.getPaymentMethod());
					
	}

	@Override
	public Order getOrderDetails(Long orderId) {
		try {
			return orderrepository.findById(orderId).orElseThrow(()-> new OrderNotFoundException("Order details not found!"));
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			return null;
		}
		// return orderrepository.findById(orderId).get();
	}

	@Override
	public List<Order> getAllOrders() {
		
		return orderrepository.findAll() ;
	}
	public static boolean isNotNumeric(String str) {
		try {
			Long.parseLong(str);
			return false;
		}
		catch(NumberFormatException e) {
			System.out.println(e.toString());
			return true;
		}
	}

}
