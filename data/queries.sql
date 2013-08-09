-- display all tables
/*
prompt ****************************************************  AVAILABLE TABLES;
select table_name from user_tables;
*/

-- select all attr from specified tables
/*
prompt ****************************************************  PURCHASE;
select * from Purchase;
prompt ****************************************************  ITEM;
select * from Item;
prompt ****************************************************  PURCHASEITEM;
select * from PurchaseItem;
*/




-- In-store purchase statements
-------------------------------


-- For printing out receipt: Q1 and Q2

-- Q1) Given a receipt number, this query lists all the items purchased, their 
-- quantities and their prices. Total amount for the purchase to be calculated in Java code.
prompt ****************************************************  Q1;
SELECT ititle as Title, I.upc, quantity, price
FROM Item I, PurchaseItem PI
WHERE I.upc=PI.upc AND receiptId=1001;

--  Q2) Given a receipt number, finds purchase date, and last 5 digits of the card's number if exists
prompt ****************************************************  Q2;
SELECT receiptId, pdate as PurchaseDate, 'xxxxxxxxxxx' || SUBSTR(cardno, 12,5) as CardNumber
FROM Purchase
WHERE receiptId=1004 AND cardno IS NOT NULL
UNION
SELECT receiptId, pdate, cardno
FROM Purchase
WHERE receiptId=1004 AND cardno IS NULL;



-- Q3) query Item to see if there is sufficient stock for given UPC and quantity
prompt ****************************************************  Q3;
SELECT stock
FROM Item 
WHERE upc=111113;



-- Q7) update stock in Item by corresponding amount for each item purchased



-- Q8)
prompt ****************************************************  Q8;
WITH 
sq1 AS 
	(select * 
		from (select upc,  sum(quantity) as Sold 
			from purchaseitem pi, purchase p  
			where p.receiptid = pi.receiptid and pdate >= "date" and pdate <= "date" 
			group by upc 
			order by sold desc) 
		where rownum <= n), 
sq2 AS 
	(select pi.upc, ititle, stock, company 
		from item i, purchase p, purchaseitem pi 
		where i.upc = pi.upc and pi.receiptid = p.receiptid)
	SELECT ititle as Title, company, stock, Sold 
 	FROM sq1, sq2 
 	WHERE  sq1.upc = sq2.upc
 	ORDER BY Sold desc; -- FINAAAALLLLLLLLL


 	-- n is integer, top n items
 	-- date is string, date in 'YY-MM-DD' format

-- Q9) query daily sales report (currently can't specify date)
prompt ****************************************************  Q9;
WITH sq1 AS (select * from (SELECT upc, category, price FROM item ORDER BY category)), sq2 AS (SELECT upc, sum(quantity) AS units FROM purchaseitem GROUP BY upc ORDER BY units) SELECT sq1.upc, category, sq1.price, sq2.units, (sq1.price * sq2.units) AS total_value FROM sq1, sq2 WHERE sq1.upc = sq2.upc ORDER BY category;

-- output new lines (for readability)
prompt 
prompt 
prompt 
prompt 
prompt 
prompt 
prompt 
prompt 
prompt 
