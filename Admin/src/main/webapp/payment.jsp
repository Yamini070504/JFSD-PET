<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Page</title>
</head>
<body>
    <h1>Payment Page</h1>
    
    <form action="processPayment" method="post">
        <label for="cardNumber">Card Number:</label>
        <input type="text" id="cardNumber" name="cardNumber" required><br>

        <label for="expiryDate">Expiry Date (MM/YY):</label>
        <input type="text" id="expiryDate" name="expiryDate" required><br>

        <label for="cvv">CVV:</label>
        <input type="text" id="cvv" name="cvv" required><br>

        <button type="submit">Submit Payment</button>
    </form>
    
    <a href="index.jsp">Back to Home</a>
</body>
</html>
