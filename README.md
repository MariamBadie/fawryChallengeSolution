# Fawry Challenge Solution

This is my complete solution for the **Full Stack Development Internship Challenge**.  
It is a simple **console-based Java e-commerce system** that covers:
- Product definition (including expiry & shipping)
- Shopping cart functionality
- Checkout with validation (expiry, stock, balance)
- Shipping fee calculation
- Clear **shipment notice** and **checkout receipt**


## **Features**

✔️ Define products:  
- Some products can expire (like Cheese & Biscuits).
- Some products need shipping (like Cheese & TV) and have weight.  
- Some products do not expire or ship (like Mobile scratch cards).

✔️ Add products to cart with **quantity validation**.

✔️ Perform checkout:
- Calculate subtotal, shipping fees, and total.
- Validate stock, expiry, balance.
- Update customer balance and product stock.
- Print **Shipment notice** and **Checkout receipt**.
<img width="1440" alt="Screenshot 2025-07-04 at 6 08 00 PM" src="https://github.com/user-attachments/assets/accc7650-b7f0-4048-8b60-a33e915601c1" />



✔️ Throws errors if:
- Cart is empty.
- Product is expired.
- Insufficient stock or balance.
<img width="1440" alt="Screenshot 2025-07-04 at 6 09 11 PM" src="https://github.com/user-attachments/assets/53453a6f-aef5-4339-a200-56d8253988d6" />


## 🧩 **Project Structure**

```plaintext
src/
 └─ main/
     └─ java/
         └─ com.example.fawryChallengeSolution/
             ├─ models/
             │   ├─ Product, Cheese, Biscuit, TV, Mobile, Customer, Cart, CartItem...
             ├─ services/
             │   └─ ShippingService.java
             ├─ FawryChallengeSolutionApplication.java
