-- In-store purchase statements
-------------------------------


-- For printing out receipt
-- When the payment is completed the system prints a receipt that shows 
-- a receipt number, the date, a list with the items purchased, their 
-- quantities and their prices, and the total amount for the purchase. 
-- If the customer pays by a credit card, the receipt should show the last 
-- 5 digits of the card's number.

-- Q1) query Item to find names of titles that were purchased in given receiptId
SELECT ititle
FROM Item I
WHERE I.upc IN (SELECT upc
FROM PurchaseItem WHERE receiptId=?)

-- Q2) query Item to find number of titles that were purchased in given receiptId
SELECT ititle
FROM Item I
WHERE I.upc IN (SELECT upc, 
FROM PurchaseItem WHERE receiptId=?)

-- Q3) query Item to see if there is sufficient stock for given UPC and quantity


-- Q4) query Item to see if there is sufficient  stock for given UPC and quantity
	-- if yes, add this item to GUI table instorePurchaseItems (which should contain 
	-- UPC’s, names, quantities, prices)
-- Q5) insert into Purchase 
	-- (purchase_receiptId.nextval, system date, null for cid, null or val for card#, null or val for cardexpdate, null forexpectd, null for delivd)
-- Q6) insert into PurchaseItem (receiptId, upc,qty)
-- Q7) update stock in Item by corresponding amount for each item purchased
