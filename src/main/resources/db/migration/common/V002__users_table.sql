CREATE TABLE WEAPON(
  id                          NUMBER         NOT NULL,
  quality                  NUMBER          NOT NULL,
  person_id            NUMBER
);


ALTER TABLE WEAPON
  ADD CONSTRAINT WEAPON_ID_PK PRIMARY KEY (id);


insert into WEAPON values (1, 1, 1);
insert into WEAPON values (2, 2, 2);
insert into WEAPON values (3, 3, 3);
insert into WEAPON values (5, 12390, 5);
insert into WEAPON values (6, 12, 6);

