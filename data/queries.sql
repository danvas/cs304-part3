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

-- Q4) update stock in Item by corresponding amount for each item purchased

-- Q6) query Return, ReturnItem for list of returns within the past 15 days
prompt ****************************************************  Q6;
WITH pq1 AS (SELECT p.pdate, pi.receiptid, pi.upc, pi.quantity 
			FROM purchase p, purchaseitem pi 
			WHERE p.receiptid = pi.receiptid AND p.receiptId = '1013' 
					AND pi.upc = '111112' AND pdate >= (sysdate - 15)), 
rq1 AS (SELECT r.retid, r.receiptid, rdate 
		FROM return r, returnitem ri 
		WHERE r.retid = ri.retid AND rdate >= sysdate - 15) 
SELECT DISTINCT(pq1.upc), pq1.receiptId, pq1.quantity 
FROM pq1, rq1 
WHERE pq1.receiptId = rq1.receiptId;

-- Q7) query top n selling items on a given day 
prompt ****************************************************  Q7;
WITH 
sq1 AS 
	(select * 
		from (select upc,  sum(quantity) as Sold 
			from purchaseitem pi, purchase p  
			where p.receiptid = pi.receiptid and pdate >= '13-05-25' and pdate <= '13-05-25' 
			group by upc 
			order by sold desc) 
		where rownum <= 4), 
sq2 AS 
	(select distinct (pi.upc), ititle, stock, company 
		from item i, purchase p, purchaseitem pi 
		where i.upc = pi.upc and pi.receiptid = p.receiptid)
	SELECT ititle as Title, company, stock, Sold 
 	FROM sq1, sq2 
 	WHERE  sq1.upc = sq2.upc
 	ORDER BY Sold desc; -- FINAAAALLLLLLLLL


 	-- n is integer, top n items
 	-- date is string, date in 'YY-MM-DD' format

-- Q8) query daily sales report
prompt ****************************************************  Q8;
WITH sq1 AS (SELECT * FROM (SELECT i.upc, category, price FROM item i, purchase p, purchaseitem pi WHERE i.upc = pi.upc AND pi.receiptid = p.receiptid ORDER BY category)), 
sq2 AS (SELECT upc, sum(quantity) AS units FROM purchase p, purchaseitem pi WHERE p.receiptid = pi.receiptid AND pdate >= '03-03-18' and pdate <= '03-03-18' GROUP BY upc ORDER BY units) 
SELECT sq1.upc, DISTINCT(category), sq1.price, sq2.units, (sq1.price * sq2.units) AS total_value 
FROM sq1, sq2 
WHERE sq1.upc = sq2.upc 
ORDER BY category;

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
