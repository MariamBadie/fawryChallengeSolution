package com.example.fawryChallengeSolution.services;

import com.example.fawryChallengeSolution.models.*;
import java.util.List;

public class ShippingService {
    public static double calculateShipping(List<Shippable> items) {
        double totalWeight = 0.0;
        for (Shippable item : items) {
            totalWeight += item.getWeight();
        }

        return totalWeight * 10;
    }

    public static void printShipmentNotice(List<CartItem> cartItems) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;

        for (CartItem item : cartItems) {
            if (item.getProduct() instanceof Shippable) {
                Shippable shippable = (Shippable) item.getProduct();
                double itemWeight = shippable.getWeight() * item.getQuantity();
                totalWeight += itemWeight;
                double itemWeightGrams = itemWeight * 1000;
                System.out.printf("%dx %s %.0fg%n",
                        item.getQuantity(),
                        shippable.getName(),
                        itemWeightGrams);
            }
        }

        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }
}
