create table QHQE_USER (user_id  VARCHAR2(30) primary key,  first_name     VARCHAR2(30) not null,  last_name      VARCHAR2(30) not null, mid_name       VARCHAR2(30),
  ph_num         VARCHAR2(15), email          VARCHAR2(50),  qhqe_id        VARCHAR2(15) not null,  qhqe_name      VARCHAR2(100) not null,  qhqe_type      VARCHAR2(40) not null,
  user_active_sw VARCHAR2(1) not null,  created_by     VARCHAR2(30) not null,  created_dt     DATE not null,  updated_by     VARCHAR2(30),  updated_dt     DATE);

CREATE SEQUENCE productsequence START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE itemsequence START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
create table PRODUCT  (product_id number(10) primary key , name varchar(30));
create table ITEM(id number(10) primary key , name varchar(30) , product_id number(10) );
