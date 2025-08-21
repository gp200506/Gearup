package com.example.gearUpBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOrderConfirmation(String to, String customerName, Long orderId, String deliveryAddress) {
        String subject = "Order Confirmation - GearUp";
        String body = "Hello " + customerName + ",\n\n" +
                "✅ Your order (ID: " + orderId + ") has been placed successfully.\n" +
                "📍 Delivery Address: " + deliveryAddress + "\n\n" +
                "Thank you for shopping with GearUp!\n\n" +
                "-- GearUp Team";

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(body);

        mailSender.send(msg);
    }
}
