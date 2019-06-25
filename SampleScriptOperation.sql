/* create a table if not exists the table Operation*/
CREATE TABLE  if not exists Operation(			
    ID varchar(255) NOT NULL,
    Numbe varchar(255) NOT NULL,
    Tex varchar(255),
	PRIMARY KEY (ID,Numbe)
);

/*return all the operations in the table operation*/
select * from operation;

/* add a new operation in the table operation with a defined id, numberCalled and text*/
INSERT INTO operation VALUES ('86','5555','Well done!!');

/* delete an operation from the table operation*/
DELETE FROM operation WHERE id ='8'  AND numbe = '5555';

/* change the id of an operation*/
UPDATE operation SET id = '01' WHERE id = '000' AND numbe = '2';

/* change the text of an operation*/
UPDATE operation SET tex= 'new text operation' WHERE id ='2' AND numbe= '5555';

/* returns all the new operations available*/
SELECT * From operation where numbe='2' and id like '00_'
order by id;


