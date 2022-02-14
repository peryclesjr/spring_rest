-- spring_db.person definition
CREATE TABLE person (
                          id bigint(20) NOT NULL AUTO_INCREMENT,
                          address varchar(100) DEFAULT NULL,
                          first_name varchar(80) NOT NULL,
                          gender varchar(1) DEFAULT NULL,
                          last_name varchar(80) NOT NULL,
                          PRIMARY KEY (id)
);