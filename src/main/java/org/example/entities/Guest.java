package org.example.entities;

import lombok.*;
import org.example.enums.RoomType;
import org.example.enums.RoomTypePayment;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Guest extends User{
    private Integer roomNumber;
    private RoomType roomType;
    private RoomTypePayment payment;

    public BigDecimal getPayments() {
        //convert enum string to bigdecimal and return bigdecimal
        //Read about Regex expression

        //converts enum to string
        String roomTypePaymentInStrings = payment.name();
        System.out.println(roomTypePaymentInStrings);
        //removes characters from the enum string
        String paymentInStrings = roomTypePaymentInStrings.replaceAll("L|S|ST|P|_", "");
        System.out.println(paymentInStrings);
        //converts string to long
        Long paymentInLongValue = Long.parseLong(paymentInStrings);
        System.out.println(paymentInLongValue);
        //converts the long to bigDecimal (because BigDecimal is really cool for money transactions)
        BigDecimal money =  BigDecimal.valueOf(paymentInLongValue);
        System.out.println(money);
        return money;
    }
    public BigDecimal getMoneyValue() {
        return BigDecimal.valueOf(Long.parseLong(payment.name().replaceAll("L|S|ST|P|_", "")));
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name=" + getName()+
                ", email="+ getEmail()+
                ", roomNumber=" + roomNumber +
                ", roomType=" + roomType +
                ", payment=" + getMoneyValue() +
                '}';
    }
}