drop table account;
drop table inaccount;

create table account
(
   accountid varchar2(18) primary key,
   balance   number(10,2)
);



create table inaccount
(
   accountid varchar2(18),
   inbalance number(10,2)
);

commit;

