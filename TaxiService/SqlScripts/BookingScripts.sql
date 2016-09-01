--BOOKING SCRIPTS

--CREATING THE BOOKING TABLE

CREATE TABLE BOOKING(
	ID VARCHAR2(20) PRIMARY KEY,
	CUSTOMEREMAIL VARCHAR2(30),
	CABNUMBER VARCHAR2(20),
	VEHICLENAME VARCHAR2(30),
	PICKUP VARCHAR2(20),
	DROPOFF VARCHAR2(20),
	CHARGETYPE VARCHAR2(20),
	FARE NUMBER(6,0),
	TRIPDATE DATE,
	STATUS VARCHAR2(10),
	
	FOREIGN KEY (CUSTOMEREMAIL) REFERENCES TAXIUSER(EMAIL) ON DELETE CASCADE,
	FOREIGN KEY (CABNUMBER) REFERENCES TAXI(CABNUMBER) ON DELETE CASCADE,
	
	CONSTRAINT CHK_STATUS CHECK (STATUS IN ('CANCELLED', 'COMPLETED', 'SCHEDULED')),
	CONSTRAINT CHK_ROUTE CHECK (PICKUP != DROPOFF),
	CONSTRAINT CHK_PAYTYPE CHECK (CHARGETYPE IN ('METER', 'PACKAGE', 'OUTSERVICE'))
);

--STORED PROCEDURE FOR ADDING BOOKING TO TABLE

CREATE OR REPLACE PROCEDURE ADD_BOOKING(B_ID BOOKING.ID%TYPE, B_EMAIL 
BOOKING.CUSTOMEREMAIL%TYPE, B_CABNUMBER BOOKING.CABNUMBER%TYPE, B_VEHICLE 
BOOKING.VEHICLENAME%TYPE, B_PICKUP BOOKING.PICKUP%TYPE, B_DROPOFF 
BOOKING.DROPOFF%TYPE, B_TYPE BOOKING.CHARGETYPE%TYPE, B_FARE BOOKING.FARE%TYPE, 
B_DATE BOOKING.TRIPDATE%TYPE, B_STATUS BOOKING.STATUS%TYPE, RESULT OUT NUMERIC)
IS
BEGIN
	INSERT INTO BOOKING VALUES(B_ID, B_EMAIL, B_CABNUMBER, B_VEHICLE, B_PICKUP, B_DROPOFF,
	B_TYPE, B_FARE, B_DATE, B_STATUS);
	RESULT := SQL%ROWCOUNT;
END ;

--STORED PROCEDURE FOR REMOVING A BOOKING 

CREATE OR REPLACE PROCEDURE REMOVE_BOOKING(B_ID BOOKING.ID%TYPE, RESULT OUT NUMERIC)
IS
BEGIN
	DELETE FROM BOOKING WHERE ID = B_ID;
	RESULT := SQL%ROWCOUNT;
END ;

--STORED PROCEDURE FOR FINDING A BOOKING FROM TABLE

CREATE OR REPLACE PROCEDURE FIND_BOOKING(B_ID BOOKING.ID%TYPE, RESULT OUT SYS_REFCURSOR)
IS
BEGIN
	OPEN RESULT FOR
	SELECT * FROM BOOKING WHERE ID = B_ID;
END ;

--STORED PROCEDURE FOR FIND ALL A USER'S BOOKINGS
CREATE OR REPLACE PROCEDURE FIND_USER_BOOKINGS(B_EMAIL BOOKING.CUSTOMEREMAIL%TYPE, 
RESULT OUT SYS_REFCURSOR)
IS
BEGIN
	OPEN RESULT FOR
	SELECT * FROM BOOKING WHERE CUSTOMEREMAIL = B_EMAIL;
END ;

