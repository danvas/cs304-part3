-- In-store purchase queries
----------------------------


-- For printing out receipt
-- When the payment is completed the system prints a receipt that shows 
-- a receipt number, the date, a list with the items purchased, their 
-- quantities and their prices, and the total amount for the purchase. 
-- If the customer pays by a credit card, the receipt should show the last 
-- 5 digits of the card's number.

-- Q1) Find names of titles that were purchased in given receiptId
SELECT ititle
FROM Item I
WHERE I.upc IN (SELECT PI.upc
FROM PurchaseItem PI WHERE receiptId=?)