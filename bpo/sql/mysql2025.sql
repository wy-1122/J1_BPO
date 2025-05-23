INSERT INTO `orders_state`(`Orders_State_ID`, `Order_State`) VALUES (1, '支付定金');
INSERT INTO `orders_state`(`Orders_State_ID`, `Order_State`) VALUES (2, '支付尾款');
INSERT INTO `orders_state`(`Orders_State_ID`, `Order_State`) VALUES (3, '违约扣款');
INSERT INTO `orders_state`(`Orders_State_ID`, `Order_State`) VALUES (4, '违约赔偿');
INSERT INTO `orders_state`(`Orders_State_ID`, `Order_State`) VALUES (5, '定金退还');
INSERT INTO `orders_state`(`Orders_State_ID`, `Order_State`) VALUES (6, '全额转付');

INSERT INTO `client_support`(`Equipment_ID`, `Equipment_Name`) VALUES (1, '网站');
INSERT INTO `client_support`(`Equipment_ID`, `Equipment_Name`) VALUES (2, '桌面软件');
INSERT INTO `client_support`(`Equipment_ID`, `Equipment_Name`) VALUES (3, '小程序');
INSERT INTO `client_support`(`Equipment_ID`, `Equipment_Name`) VALUES (4, '微信公众号');
INSERT INTO `client_support`(`Equipment_ID`, `Equipment_Name`) VALUES (5, 'H5页面');
INSERT INTO `client_support`(`Equipment_ID`, `Equipment_Name`) VALUES (6, 'IOS');
INSERT INTO `client_support`(`Equipment_ID`, `Equipment_Name`) VALUES (7, '安卓');
INSERT INTO `client_support`(`Equipment_ID`, `Equipment_Name`) VALUES (8, '其他形式');
INSERT INTO `client_support`(`Equipment_ID`, `Equipment_Name`) VALUES (9, NULL);

INSERT INTO `project_type`(`Project_Type_ID`, `Project_Type_Name`) VALUES (1, '视频图像类');
INSERT INTO `project_type`(`Project_Type_ID`, `Project_Type_Name`) VALUES (2, '虚拟现实类');
INSERT INTO `project_type`(`Project_Type_ID`, `Project_Type_Name`) VALUES (3, '人工智能类');
INSERT INTO `project_type`(`Project_Type_ID`, `Project_Type_Name`) VALUES (4, '电商应用类');
INSERT INTO `project_type`(`Project_Type_ID`, `Project_Type_Name`) VALUES (5, '游戏娱乐类');
INSERT INTO `project_type`(`Project_Type_ID`, `Project_Type_Name`) VALUES (6, '办公管理类');
INSERT INTO `project_type`(`Project_Type_ID`, `Project_Type_Name`) VALUES (7, '金融交易类');
INSERT INTO `project_type`(`Project_Type_ID`, `Project_Type_Name`) VALUES (8, '物联网应用类');
INSERT INTO `project_type`(`Project_Type_ID`, `Project_Type_Name`) VALUES (9, '工具支持类');
INSERT INTO `project_type`(`Project_Type_ID`, `Project_Type_Name`) VALUES (10, '底层研发类');
INSERT INTO `project_type`(`Project_Type_ID`, `Project_Type_Name`) VALUES (11, '嵌入式开发类');
INSERT INTO `project_type`(`Project_Type_ID`, `Project_Type_Name`) VALUES (12, '视图设计类');
INSERT INTO `project_type`(`Project_Type_ID`, `Project_Type_Name`) VALUES (13, '其他项目类');
INSERT INTO `project_type`(`Project_Type_ID`, `Project_Type_Name`) VALUES (14, NULL);

INSERT INTO `role`(`Role_ID`, `Role_Name`, `Role_Description`) VALUES (1, '发包方', NULL);
INSERT INTO `role`(`Role_ID`, `Role_Name`, `Role_Description`) VALUES (2, '承包方', NULL);
INSERT INTO `role`(`Role_ID`, `Role_Name`, `Role_Description`) VALUES (3, '项目管理员', NULL);
