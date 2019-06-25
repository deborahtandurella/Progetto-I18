/* create a table if not exists the table Operator*/
CREATE TABLE  if not exists Operator(			
    Numbe varchar(255) NOT NULL,
    Username varchar(255) NOT NULL,
    Passwor varchar(255),
    LoggedIn boolean  ,
	PRIMARY KEY (Numbe,Username)
);

/* return all the attributes of all the operators in the table operator*/
select * from operator;

/* delete an operator from the table operator which has a certain username and numberCalled*/
DELETE FROM operator WHERE username = 'Username' AND numbe = '15';

/* add a new operator in the table operator with some attribute values*/
INSERT INTO operator VALUES ('005','username','password',false);

/* return an operatore from the table operator with a defined username and numberCalled*/
SELECT * FROM operator where numbe ='5555' and username ='username';

/* change the username of an operator*/
UPDATE operator SET username= '7' WHERE numbe='555' AND username='oldUsername';

/* change the password of an operator*/
UPDATE operator SET Passwor= '7' WHERE numbe='555' AND username='Username';

/* delete all the rows in the table operator */
truncate operator;

/* change the status logged of an operator to true*/
update operator set loggedIn=true;

