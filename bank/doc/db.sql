drop table account;
drop table inaccount;

create table account
(
   accountid varchar2(18) primary key,
   balance   number(10,2)
);

alter table account
     add constraint ck_balance
        check( balance>=1 );


create table inaccount
(
   accountid varchar2(18),
   inbalance number(10,2)
);

delete from inaccount;

select * from account;
select * from inaccount;

commit;

