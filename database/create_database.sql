create table Invoice (
  id bigint not null auto_increment,
  customerAddress varchar(255),
  customerFullName varchar(255),
  date varchar(255),
  employeeName varchar(255),
  invoiceNumber varchar(255),
  isSent bit not null,
  officeAdress varchar(255),
  officeName varchar(255),
  paymentDetails varchar(255),
  totalPrice integer not null,
  primary key (id)
);
create table InvoiceLine (
  id bigint not null auto_increment,
  amount integer not null,
  description varchar(255),
  price integer not null,
  pricePerUnit integer not null,
  productNumber integer not null,
  unit varchar(255),
  invoice_id bigint,
  primary key (id)
);
alter table InvoiceLine
  add constraint FKjfi3vbyuv53o5344ef1x18rtu
  foreign key (invoice_id)
  references Invoice (id);