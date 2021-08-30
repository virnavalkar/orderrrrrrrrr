package com.cg.main.beans;

	
import java.time.LocalDate;


import javax.persistence.*;

//{
//"amount": 2510.56,
//"billingDate": "2020-06-21",
//"PaymentMethod":"Online"

//}

@Entity
@Table(name = "Orders")

public class Order {  
	
	
	@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private Long orderId;
	@Column
	private Double amount;
	@Column
	private LocalDate billingDate;
	@Column
	private String paymentMethod;
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "Booking", referencedColumnName = "bookingId")
//	private Booking booking;
//	

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Order() {}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

//	public Booking getBooking() {
//		return booking;
//	}
//
//	public void setBooking(Booking booking) {
//		this.booking = booking;
//	}

	public Order(long orderId, double amount, LocalDate billingDate, String paymentMethod ) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.paymentMethod = paymentMethod;
		
	}




//	@Override
//	public String toString() {
//		return "order [orderId=" + orderId + ", amount=" + amount + ", billingDate=" + billingDate + ", PaymentMethod="
//				+ PaymentMethod + "]";
//	}
//	

	

	
	
    
}



