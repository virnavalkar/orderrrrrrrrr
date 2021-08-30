package com.cg.main.exception;

public class PaymentMethodEmptyException extends Exception{

    PaymentMethodEmptyException() {}

    public PaymentMethodEmptyException(String msg)
    {
        super(msg);
    }

}