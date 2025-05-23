/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2025/5/22 16:05:12                           */
/*==============================================================*/


drop  

table  if   exists   UserRolePermission;

drop  

table  if   exists   SchemeWithProjectName;

drop  

table  if   exists   OrderWithContact;

drop  

table  if   exists   EvaluationDetails;

drop  

table  if   exists   CashFlowDetail;

drop table if exists Admin_For_Project;

drop table if exists Bidding_Scheme;

drop table if exists Bill;

drop table if exists Case_Project;

drop table if exists Cash_Flow;

drop table if exists Client_Support;

drop table if exists Employee_Skills;

drop table if exists Evaluation;

drop table if exists Message;

drop table if exists Money_Admin;

drop table if exists Money_Notification;

drop table if exists Order_Admin;

drop table if exists Orders;

drop table if exists Orders_State;

drop table if exists Permission;

drop table if exists Project;

drop table if exists Project_Type;

drop table if exists Role;

drop table if exists Role_Permission;

drop table if exists Transaction_Type;

drop table if exists User;

drop table if exists User_Employee;

drop table if exists User_Employer;

drop table if exists User_Role;

/*==============================================================*/
/* Table: Admin_For_Project                                     */
/*==============================================================*/
create table Admin_For_Project
(
   User_Project_Admin_ID int not null,
   Project_Admin_Name   varchar(20),
   primary key (User_Project_Admin_ID)
);

/*==============================================================*/
/* Table: Bidding_Scheme                                        */
/*==============================================================*/
create table Bidding_Scheme
(
   User_Employee_ID     int not null,
   Project_ID           int not null,
   User_Employer_ID     int not null,
   Project_Period       varchar(10),
   Project_Amout        varchar(20),
   Project_Superiority  varchar(50),
   Bidding_Example      varchar(20),
   User_Employee_Name   varchar(20),
   User_Employee_Tel    varchar(11),
   Bidding_Status       varchar(20),
   primary key (User_Employee_ID, Project_ID, User_Employer_ID)
);

/*==============================================================*/
/* Table: Bill                                                  */
/*==============================================================*/
create table Bill
(
   Bill_ID              int not null auto_increment,
   User_ID              int,
   Bill_Value           float(8),
   Bill_Type            varchar(20),
   Bill_Time            datetime,
   Bill_Description     varchar(50),
   primary key (Bill_ID)
);

/*==============================================================*/
/* Table: Case_Project                                          */
/*==============================================================*/
create table Case_Project
(
   User_employee        int not null,
   Project_Name         varchar(20),
   Project_Period       varchar(10),
   Role_In_Project      varchar(20),
   Tech_In_Project      varchar(50),
   Project_Introduction varchar(100),
   primary key (User_employee)
);

/*==============================================================*/
/* Table: Cash_Flow                                             */
/*==============================================================*/
create table Cash_Flow
(
   Flow_ID              int not null auto_increment,
   Money_ID             int not null,
   Money_Admin_ID       int,
   Order_Type_ID        int,
   Open_Balance_Income  float(8),
   Open_Balance_Outcome float(8),
   Current_Occurence_Amount_Income float(8),
   Current_Occurence_Amount_Outcome float(8),
   Accumulated_Amount_Income float(8),
   Accumulated_Amount_Outcome float(8),
   Closing_Balance_Income float(8),
   Closing_Balance_Outcome float(8),
   primary key (Flow_ID, Money_ID)
);

/*==============================================================*/
/* Table: Client_Support                                        */
/*==============================================================*/
create table Client_Support
(
   Equipment_ID         int not null auto_increment,
   Equipment_Name       varchar(30),
   primary key (Equipment_ID)
);

/*==============================================================*/
/* Table: Employee_Skills                                       */
/*==============================================================*/
create table Employee_Skills
(
   User_Employee        int not null,
   Application_Type     varchar(20),
   Project_Type         varchar(30),
   Development_Language varchar(20),
   Development_Skills   varchar(30),
   Position_Availble    varchar(30),
   Product              varchar(30),
   primary key (User_Employee)
);

/*==============================================================*/
/* Table: Evaluation                                            */
/*==============================================================*/
create table Evaluation
(
   Evaluation_ID        int not null auto_increment,
   User_Role_ID         int not null,
   Order_ID             int not null,
   Evaluation_Time      datetime,
   Evaluation_Details   varchar(100),
   primary key (Evaluation_ID, User_Role_ID, Order_ID)
);

/*==============================================================*/
/* Table: Message                                               */
/*==============================================================*/
create table Message
(
   Message_ID           int not null auto_increment,
   User_ID              int,
   Role_ID              int,
   Message_Time         datetime,
   Message_Info         varchar(200),
   primary key (Message_ID)
);

/*==============================================================*/
/* Table: Money_Admin                                           */
/*==============================================================*/
create table Money_Admin
(
   Money_Admin_ID       int not null,
   Money_Admin_Name     varchar(20),
   primary key (Money_Admin_ID)
);

/*==============================================================*/
/* Table: Money_Notification                                    */
/*==============================================================*/
create table Money_Notification
(
   Money_ID             int not null auto_increment,
   Order_ID             int not null,
   User_ID              int,
   Order_Admin_ID       int,
   Money_Time           datetime,
   Amount               float(8),
   Money_Type           INT,
   primary key (Money_ID)
);

/*==============================================================*/
/* Table: Order_Admin                                           */
/*==============================================================*/
create table Order_Admin
(
   Order_Admin_ID       int not null,
   Order_Admin_Name     varchar(20),
   primary key (Order_Admin_ID)
);

/*==============================================================*/
/* Table: Orders                                                */
/*==============================================================*/
create table Orders
(
   Order_ID             int not null auto_increment,
   Project_ID           int not null,
   User_employee_ID     int,
   User_Employer_ID     int,
   Order_Start_Time     datetime,
   Order_State          int,
   Order_Amount         float(8),
   Schedule             int,
   Employer_Deposit     float(8),
   Employee_Deposit     float(8),
   primary key (Order_ID)
);

/*==============================================================*/
/* Table: Orders_State                                          */
/*==============================================================*/
create table Orders_State
(
   Orders_State_ID      int not null,
   Order_State          varbinary(20),
   primary key (Orders_State_ID)
);

/*==============================================================*/
/* Table: Permission                                            */
/*==============================================================*/
create table Permission
(
   permission_ID        int not null auto_increment,
   Permission_Name      varchar(30),
   Permission_Description varchar(100),
   primary key (permission_ID)
);

/*==============================================================*/
/* Table: Project                                               */
/*==============================================================*/
create table Project
(
   Project_ID           int not null auto_increment,
   User_Employer_ID     int not null,
   Equipment_ID         int,
   Project_Type_ID      int,
   Project_Admin_ID     int,
   Project_Name         varchar(50),
   Skills_Requirement   varchar(100),
   Project_Requirement  varchar(100),
   Project_Period       varchar(20),
   Project_Budget       float(8),
   Project_Status       varchar(10),
   Connect_Tel          varchar(13),
   Connect_Name         varchar(5),
   primary key (Project_ID)
);

/*==============================================================*/
/* Table: Project_Type                                          */
/*==============================================================*/
create table Project_Type
(
   Project_Type_ID      int not null auto_increment,
   Project_Type_Name    varchar(10),
   primary key (Project_Type_ID)
);

/*==============================================================*/
/* Table: Role                                                  */
/*==============================================================*/
create table Role
(
   Role_ID              int not null auto_increment,
   Role_Name            varchar(20),
   Role_Description     varchar(20),
   primary key (Role_ID)
);

/*==============================================================*/
/* Table: Role_Permission                                       */
/*==============================================================*/
create table Role_Permission
(
   Role_ID              int not null,
   Permission_ID        int not null,
   primary key (Role_ID, Permission_ID)
);

/*==============================================================*/
/* Table: Transaction_Type                                      */
/*==============================================================*/
create table Transaction_Type
(
   Order_Type_ID        int not null auto_increment,
   Order_Type_Name      varchar(15),
   primary key (Order_Type_ID)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   User_ID              int not null auto_increment,
   User_Name            varchar(20) not null,
   Password             varchar(30) not null,
   Money                float,
   primary key (User_ID),
   unique key AK_UQ_USER_NAME (User_Name)
);

/*==============================================================*/
/* Table: User_Employee                                         */
/*==============================================================*/
create table User_Employee
(
   User_employee_ID     int not null,
   Employee_Name        varchar(20),
   Employee_Region      varchar(20),
   Employee_Enterprise  varchar(20),
   Employee_Self_Introduction varchar(100),
   Employee_phone       varchar(11),
   primary key (User_employee_ID)
);

/*==============================================================*/
/* Table: User_Employer                                         */
/*==============================================================*/
create table User_Employer
(
   User_Employer_ID     int not null,
   User_Employer_Name   varchar(30),
   User_Employer_Region varchar(50),
   User_Employer_Inctroduction varchar(100),
   User_Employer_Tel    varchar(20),
   primary key (User_Employer_ID)
);

/*==============================================================*/
/* Table: User_Role                                             */
/*==============================================================*/
create table User_Role
(
   User_ID              int not null,
   Role_ID              int not null,
   User_Role_ID         int not null auto_increment,
   Money                float(8),
   primary key (User_Role_ID)
);

/*==============================================================*/
/* View: CashFlowDetail                                         */
/*==============================================================*/
create  VIEW      CashFlowDetail

  as

select `cash_flow`.`Flow_ID` AS `Flow_ID`,`cash_flow`.`Money_ID` AS `Money_ID`,`cash_flow`.`Money_Admin_ID` AS `Money_Admin_ID`,`cash_flow`.`Order_Type_ID` AS `Order_Type_ID`,`cash_flow`.`Open_Balance_Income` AS `Open_Balance_Income`,`cash_flow`.`Open_Balance_Outcome` AS `Open_Balance_Outcome`,`cash_flow`.`Current_Occurence_Amount_Income` AS `Current_Occurence_Amount_Income`,`cash_flow`.`Current_Occurence_Amount_Outcome` AS `Current_Occurence_Amount_Outcome`,`cash_flow`.`Accumulated_Amount_Income` AS `Accumulated_Amount_Income`,`cash_flow`.`Accumulated_Amount_Outcome` AS `Accumulated_Amount_Outcome`,`cash_flow`.`Closing_Balance_Income` AS `Closing_Balance_Income`,`cash_flow`.`Closing_Balance_Outcome` AS `Closing_Balance_Outcome`,`transaction_type`.`Order_Type_Name` AS `Order_Type_Name`,`money_notification`.`Money_Time` AS `Money_Time` from ((`cash_flow` join `transaction_type`) join `money_notification`) where ((`cash_flow`.`Order_Type_ID` = `transaction_type`.`Order_Type_ID`) and (`cash_flow`.`Money_ID` = `money_notification`.`Money_ID`));

/*==============================================================*/
/* View: EvaluationDetails                                      */
/*==============================================================*/
create  VIEW      EvaluationDetails

  as

select
   `evaluation`.`Evaluation_ID` as `Evaluation_ID`,
   `evaluation`.`User_Role_ID` as `User_Role_ID`,
   `evaluation`.`Order_ID` as `Order_ID`,
   `evaluation`.`Evaluation_Time` as `Evaluation_Time`,
   `evaluation`.`Evaluation_Details` as `Evaluation_Details`,
   Project.`Project_Name` as `Project_Name`
from
   `evaluation`
   join `orders` on  ( `orders`.`Order_ID` = `evaluation`.`Order_ID` )
   join Project on  ( `orders`.`Project_ID` = Project.`Project_ID`);

/*==============================================================*/
/* View: OrderWithContact                                       */
/*==============================================================*/
create  VIEW      OrderWithContact

  as

select
   `orders`.`Order_ID` as `Order_ID`,
   Project.`Project_ID` as `Project_ID`,
   Project.`User_Employer_ID` as `User_Employer_ID`,
   `bidding_scheme`.`User_Employee_ID` as `User_Employee_ID`,
   Project.`Project_Name` as `Project_Name`,
   Project.`Connect_Name` as `Connect_Name`,
   Project.`Connect_Tel` as `Connect_Tel`,
   `bidding_scheme`.`User_Employee_Name` as `User_Employee_Name`,
   `bidding_scheme`.`User_Employee_Tel` as `User_Employee_Tel`,
   `orders`.`Schedule` as `Schedule`,
   `orders`.`Order_Start_Time` as `Order_Start_Time`,
   `orders`.`Order_State` as `Order_State`,
   `orders`.`Order_Amount` as `Order_Amount`,
   `orders`.`Employer_Deposit` as `Employer_Deposit`,
   `orders`.`Employee_Deposit` as `Employee_Deposit`
from
   `orders`
   join Project on  ( `orders`.`Project_ID` = Project.`Project_ID`)
   join `bidding_scheme` on  (( `bidding_scheme`.`User_Employee_ID` = `orders`.`User_Employee_ID`) and ( `bidding_scheme`.`Project_ID` = Project.`Project_ID`));

/*==============================================================*/
/* View: SchemeWithProjectName                                  */
/*==============================================================*/
create  VIEW      SchemeWithProjectName

  as

select
   `bidding_scheme`.`User_Employee_ID` as `User_Employee_ID`,
   `bidding_scheme`.`Project_ID` as `Project_ID`,
   `bidding_scheme`.`User_Employer_ID` as `User_Employer_ID`,
   `bidding_scheme`.`Project_Period` as `Project_Period`,
   `bidding_scheme`.`Project_Amout` as `Project_Amout`,
   `bidding_scheme`.`Project_Superiority` as `Project_Superiority`,
   `bidding_scheme`.`Bidding_Example` as `Bidding_Example`,
   `bidding_scheme`.`User_Employee_Name` as `User_Employee_Name`,
   `bidding_scheme`.`User_Employee_Tel` as `User_Employee_Tel`,
   `bidding_scheme`.`Bidding_Status` as `Bidding_Status`,
   Project.`Project_Name` as `Project_Name`
from
   `bidding_scheme`
   join Project on  (( `bidding_scheme`.`Project_ID` = Project.`Project_ID`));

/*==============================================================*/
/* View: UserRolePermission                                     */
/*==============================================================*/
create  VIEW      UserRolePermission

  as

select `User`.`User_ID` AS `User_ID`,
`User`.`User_Name` AS `User_Name`,
`User`.`Password` AS `Password`,
`user_role`.`User_Role_ID` AS `User_Role_ID`,
`user_role`.`Role_ID` AS `Role_ID`,
`role`.`Role_Name` AS `Role_Name`,
`role`.`Role_Description` AS `Role_Description`,
`permission`.`permission_ID` AS `permission_ID`,
`permission`.`Permission_Name` AS `Permission_Name`,
`permission`.`Permission_Description` AS `Permission_Description`
from
((((`User`
join `user_role` on((`User`.`User_ID` = `user_role`.`User_ID`)))
join `role` on((`user_role`.`Role_ID` = `role`.`Role_ID`)))
join `role_permission` on((`role_permission`.`Role_ID` = `role`.`Role_ID`)))
join `permission` on((`permission`.`permission_ID` = `role_permission`.`Permission_ID`)))
order by `User`.`User_ID`;

alter table Admin_For_Project add constraint FK_Reference_26 foreign key (User_Project_Admin_ID)
      references User_Role (User_Role_ID);

alter table Bidding_Scheme add constraint FK_Reference_12 foreign key (User_Employee_ID)
      references User_Employee (User_employee_ID);

alter table Bidding_Scheme add constraint FK_Reference_13 foreign key (Project_ID)
      references Project (Project_ID);

alter table Bill add constraint FK_Reference_7 foreign key (User_ID)
      references User (User_ID);

alter table Case_Project add constraint FK_Reference_9 foreign key (User_employee)
      references User_Employee (User_employee_ID);

alter table Cash_Flow add constraint FK_Reference_31 foreign key (Money_ID)
      references Money_Notification (Money_ID);

alter table Cash_Flow add constraint FK_Reference_33 foreign key (Money_Admin_ID)
      references Money_Admin (Money_Admin_ID);

alter table Cash_Flow add constraint FK_Reference_34 foreign key (Order_Type_ID)
      references Transaction_Type (Order_Type_ID);

alter table Employee_Skills add constraint FK_Reference_10 foreign key (User_Employee)
      references User_Employee (User_employee_ID);

alter table Evaluation add constraint FK_Reference_18 foreign key (Order_ID)
      references Orders (Order_ID);

alter table Evaluation add constraint FK_Reference_37 foreign key (User_Role_ID)
      references User_Role (User_Role_ID);

alter table Message add constraint FK_Reference_5 foreign key (User_ID)
      references User (User_ID);

alter table Message add constraint FK_Reference_6 foreign key (Role_ID)
      references Role (Role_ID);

alter table Money_Admin add constraint FK_Reference_36 foreign key (Money_Admin_ID)
      references User_Role (User_Role_ID);

alter table Money_Notification add constraint FK_Reference_30 foreign key (Order_Admin_ID)
      references Order_Admin (Order_Admin_ID);

alter table Money_Notification add constraint FK_Reference_32 foreign key (Order_ID)
      references Orders (Order_ID);

alter table Money_Notification add constraint FK_Reference_38 foreign key (User_ID)
      references User (User_ID);

alter table Money_Notification add constraint FK_Reference_39 foreign key (Money_Type)
      references Transaction_Type (Order_Type_ID);

alter table Order_Admin add constraint FK_Reference_35 foreign key (Order_Admin_ID)
      references User_Role (User_Role_ID);

alter table Orders add constraint FK_Reference_16 foreign key (Project_ID)
      references Project (Project_ID);

alter table Orders add constraint FK_ORDERS_REFERENCE_USER_EMP2 foreign key (User_employee_ID)
      references User_Employee (User_employee_ID);

alter table Orders add constraint FK_Reference_23 foreign key (User_Employer_ID)
      references User_Employer (User_Employer_ID);

alter table Orders add constraint FK_Reference_40 foreign key (Order_State)
      references Orders_State (Orders_State_ID);

alter table Project add constraint FK_Reference_15 foreign key (User_Employer_ID)
      references User_Employer (User_Employer_ID);

alter table Project add constraint FK_Reference_27 foreign key (Equipment_ID)
      references Client_Support (Equipment_ID);

alter table Project add constraint FK_Reference_28 foreign key (Project_Type_ID)
      references Project_Type (Project_Type_ID);

alter table Project add constraint FK_Reference_29 foreign key (Project_Admin_ID)
      references Admin_For_Project (User_Project_Admin_ID);

alter table Role_Permission add constraint FK_Reference_3 foreign key (Role_ID)
      references Role (Role_ID);

alter table Role_Permission add constraint FK_Reference_4 foreign key (Permission_ID)
      references Permission (permission_ID);

alter table User_Employee add constraint FK_Reference_24 foreign key (User_employee_ID)
      references User_Role (User_Role_ID);

alter table User_Employer add constraint FK_USER_EMP_REFERENCE_USER_ROL2 foreign key (User_Employer_ID)
      references User_Role (User_Role_ID);

alter table User_Role add constraint FK_Reference_1 foreign key (User_ID)
      references User (User_ID);

alter table User_Role add constraint FK_Reference_2 foreign key (Role_ID)
      references Role (Role_ID);

