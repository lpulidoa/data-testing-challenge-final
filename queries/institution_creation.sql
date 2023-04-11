USE PERSONAS; 

Show Tables;

CREATE TABLE Institution (
	idInstitution	INT PRIMARY KEY,
	instName		VARCHAR(45) NOT NULL,
	phoneNumber		VARCHAR(45) NOT NULL,
	email		VARCHAR(45) NOT NULL
);

INSERT INTO institution (idInstitution, instName, phoneNumber, email) VALUES ('1','Bachillerato','2675466','bachillerato@mail.com');
INSERT INTO institution (idInstitution, instName, phoneNumber, email) VALUES ('2','Universidad','5409135','universidad@mail.com');
INSERT INTO institution (idInstitution, instName, phoneNumber, email) VALUES ('3','Sena','4786523','sena@mail.com');

ALTER TABLE Employee ADD idInstitution INT NOT NULL;  

UPDATE Employee SET idInstitution = '1' WHERE idEmployee = '74';
UPDATE Employee SET idInstitution = '2' WHERE idEmployee = '83';
UPDATE Employee SET idInstitution = '3' WHERE idEmployee = '92';
UPDATE Employee SET idInstitution = '1' WHERE idEmployee = '95';
UPDATE Employee SET idInstitution = '2' WHERE idEmployee = '64';
COMMIT; 

ALTER TABLE Employee ADD CONSTRAINT FK_idInstitution  FOREIGN KEY (idInstitution)  
					REFERENCES Institution (idInstitution)
                    ON DELETE CASCADE     
                    ON UPDATE CASCADE;

