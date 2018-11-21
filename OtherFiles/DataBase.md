# DataBase Base Infors
    Data Base : MySql
    Data Base UserName : Root
    Data Base Password : a123456
    Data Base for this project name : tradingmanagerdata
    Data Base Version : 5.5.36
# Trading Manager Data:
## Tables:
   | Table Name | Table Desc |
   |:---------- | ----------:|
   |t_user_infos|用户表|
   |t_product_infos|产品表|
   |t_obill_info|每一次结账账单表|
   |t_log_base|日志基础表|
   |t_log_change_product_count|产品数量修改日志|
   |t_log_change_product_price|产品价格修改日志|
   |t_log_operation_obill|由产品数量修改造成的账单日志|
   |t_log_operation_obill_res|一次结账所关联的产品|
   
## TablesInfo
### t_user_infos
    user_id
    user_name
    user_password
    user_power
### t_product_infos
    product_id
    product_name
    product_desc
    product_pic
    product_price
    product_count
    product_max_count
    product_min_count
### t_obill_info
    obill_id
    obill_time
    obill_money
### t_log_base
    log_id
    log_time
    log_about_user
    log_type
    log_what
### t_log_change_product_count
    t_lcpc_id
    log_id
    product_id
    product_old_count
    product_old_price
    product_new_count
### t_log_change_product_price
    t_lcpp_id
    log_id
    product_id
    product_old_count
    product_old_price
    product_new_price
### t_log_operation_obill
    t_loo_id
    parent_log_id
    t_lcpc_id
### t_log_operation_obill_res
    t_lobr_id
    t_obill_id
    t_product_id
    t_loo_id
    