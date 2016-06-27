/** 管理员信息表  t_admin */
CREATE TABLE t_admin (
  id INT NOT NULL auto_increment COMMENT 'id',
  user_name varchar(10) NOT NULL COMMENT '用户名',
  password varchar(200) NOT NULL COMMENT '登录密码',
  real_name varchar(20) DEFAULT NULL COMMENT '真实姓名',
  create_time datetime DEFAULT NULL COMMENT '创建时间',
  role_id varchar(2) not null comment '权限id'
);
alter table t_admin add primary key(id);
alter table t_admin add unique(user_name);


/** 权限信息表 */
create table t_role(
  id int primary key auto_increment comment 'id',
  role_name varchar(10) not null comment '权限名称',
  role_desc varchar(100) comment '描述',
  create_time datetime comment '创建时间',
  create_id int comment '创建人',
  `status` char(1) comment '状态（1.启用、2.停用）'
);

/** 权限与功能菜单对应表 */
create table t_role_menu(
  id int primary key auto_increment comment 'id',
  role_id int comment '角色id',
  menu_id int comment '菜单id'
);

/** 功能菜单信息表 */

create table t_menu(
  id varchar(10) not null comment 'id',
  menu_code varchar(10) not null comment '菜单编码',
  menu_desc varchar(200) comment '菜单描述',
  menu_isLeaf char(1) comment '是否为叶子节点,0不为叶子，1为叶子',
  menu_name varchar(20) comment '菜单名称',
  menu_seqno varchar(2) comment '排序',
  menu_parentId varchar(20) comment '父节点ID',
  menu_status char(1) comment '菜单状态：0：禁用，1：启用',
  menu_url varchar(100) comment '菜单url'
);
alter table t_menu add primary key(id);
alter table t_menu add unique(menu_url);

/** 用户功能权限对照表 */
create table t_admin_menu(
  id varchar(10) comment 'id',
  admin_id varchar(20) comment '管理员id',
  menu_id varchar(10) comment '菜单code'
);
alter table t_admin_menu add primary key(id);

/** 系统参数配置表 **/
create table pub_sysapr(
  id varchar(10) comment 'id',
  `code` varchar(30) comment '参数代码',
  showmsg varchar(60) comment '应用显示信息',
  `name` varchar(60) comment '应用参数名称',
  `value` varchar(60) comment '应用参数值'
);
alter table pub_sysapr add primary key(id);

/** 错误代码信息表 **/
create table pub_error(
  id int primary key auto_increment comment 'id',
  `code` varchar(10) comment '错误代码',
  showMsg varchar(200) comment '错误信息'
);

/** 游戏信息表 **/
create table t_appinfos(
  id int not null auto_increment comment 'id' ,
  app_name varchar(100) comment '应用名称，用于内部运营沟通的通用名称',
  show_name varchar(100) comment '应用名称，用于显示给用户看',
  pack_name varchar(100)	comment '安装包名称',
  issue_type char(1) comment '分发类型（1：不分渠道、2：分渠道）',
  dev_id 	varchar(50) comment '开发者ID',
  dev_name varchar(50) comment '开发者名称',
  app_class char(2) comment '应用分类（11：应用，12：游戏）',
  app_type varchar(30) comment '类型ID',
  evil_level int(1) comment '黄暴等级（0-5代表从危险至安全）' ,
  down_times int  comment '下载量',
  down_timesreal int comment '真实下载量' ,
  comment_score int  comment '用户评分',
  comment_times int  comment '用户评价次数',
  apptag varchar(30)  comment '标签',
  recomm_flag varchar(100) comment '推荐标志（角标1：推荐、2：热门、3：官方推荐）',
  recomm_level int  comment '推荐值（1-10代表不推荐到推荐）',
  recomm_word varchar(100) comment '推荐语',
  thumb_picurl varchar(200) comment '略缩图URL地址',
  main_iconpicurl varchar(200) comment 'ICON图URL地址',
  main_packid varchar(20) comment '主安装包ID',
  main_packsize int comment '主安装包大小',
  main_vercode varchar(20) comment '版本代码',
  main_vername varchar(20) comment '',
  main_signcode varchar(20) comment '签名特征码，签名特征码相同，则可以升级',
  search_keys varchar(50) comment '搜索关键字',
  appdesc varchar(1000) comment '应用描述',
  remarks varchar(1000) comment '备注',
  uapp_id 	varchar(20) comment '联运游戏ID',
  creat_time datetime comment '创建时间',
  create_admin varchar(20) comment '创建人',
  update_time datetime comment '更新时间',
  update_admin varchar(20) comment '更新人',
  `status` char(1) comment '状态（0：禁用、1：启用）',
  isOnline char(1) comment '是否为网游（1：网游、0：单机）',
  primary key(id)
);


/** 游戏类型表 **/
create table t_apptype(
  type_id int auto_increment comment '应用类型ID',
  type_class char(1) comment '应用类型',
  type_name varchar(20) comment '分组类型名称，分类时可以作为分类名称（优先取具体组的特定名称）',
  type_iconUrl varchar(200) comment 'icon图片路径',
  type_status char(1) comment '状态（1：启用、0：禁用）',
  primary key(type_id)
);
alter table t_apptype auto_increment = 10000;


/** 应用详细信息表(安装包) **/
create table t_packinfo(
  packid int  comment '安装包ID',
  appinfo_id int comment '应用ID',
  is_mainver char(1) comment '是否为主版本',
  show_name varchar(100) comment '显示名称，显示给用户看',
  issue_flag char(1) comment '分发标志',
  gains_type char(1) comment '盈利模式',
  down_times int comment '下载量',
  down_timesReal int comment '真实下载量',
  comment_times int comment '用户评价次数',
  comment_score int comment '用户评分',
  icon_picurl varchar(200) comment 'ICON图url地址',
  pack_from char(1) comment '安装包来源',
  pack_size int comment '安装包大小',
  ver_code int comment '版本代码',
  ver_name varchar(100) comment '版本名称',
  sign_code varchar(100) comment '签名特征码，签名特征码相同，则可以升级',
  pack_url varchar(200) comment '安装包地址',
  pack_md5 varchar(200) comment '安装包MD5校验码',
  comp_desc varchar(200) comment '适应性说明',
  update_desc varchar(1000) comment '更新说明',
  remarks varchar(1000) comment '备注',
  pack_url2 varchar(200) comment '接口所传url',
  dpi varchar(100) comment '使用分辨率',
  qrCode_url varchar(200) comment '二维码地址',
  hasad char(1) comment '是否有广告',
  plat_form char(1) comment '适用平台（1：手机、2：平板）',
  part_pack_md5 varchar(200) comment '安装包片段MD5',
  create_time datetime comment '创建日期',
  update_time datetime comment '更新日期',
  `status` char(1) comment '状态（1：启用、2：禁用）',
  primary key(packid)
);
alter table t_packinfo auto_increment = 10000;

/** 游戏图片列表 **/
create table t_app_picList(
  id int comment 'id',
  order_no int comment '排序',
  picurl varchar(200) comment '地址',
  appInfo_id int comment '游戏信息ID',
  primary key(id)
);
alter table t_app_picList auto_increment = 10000;

/** 游戏标签 **/
create table t_app_tab(
  id int primary key auto_increment   comment 'id',
  tab_name varchar(50) comment '标签名称',
  tab_status char(1) comment '标签状态（1：启用、0：禁用）'
);
alter table t_app_tab auto_increment = 10000;

/** 游戏批量上传任务 */
create table t_app_bath_info(
  id int primary key auto_increment comment 'id',
  create_time datetime comment '创建时间',
  create_id VARCHAR(20) comment '创建人ID',
  create_name varchar(20) comment '创建人名称',
  `status` char(1)	comment '任务状态（1：未开始、2：进行中、3：成功、4：部分成功,5:失败）',
  start_time datetime comment '执行时间'
);

/** 游戏批量上传任务详情 */
create table t_app_bath_info_detail(
  id int primary key auto_increment comment 'id',
  infoId int comment '批量任务id',
  app_name varchar(100)	comment '游戏名称',
  show_name varchar(100) comment '游戏名称（显示用户看）',
  search_keys varchar(100) comment '关键字',
  apptag varchar(50) comment '标签',
  app_type varchar(30) comment '分类',
  isonline char(1) comment '是否为网游（1：网游，2：单机）',
  piclist varchar(300) comment '游戏图片列表',
  apk_name varchar(50) comment 'pak包名',
  appdesc varchar(2000) comment '游戏描述' ,
  evil_level int(1) comment '黄暴等级（0-5代表从危险至安全）' ,
  recomm_flag varchar(100) comment '推荐标志（角标1：推荐、2：热门、3：官方推荐）',
  recomm_level int  comment '推荐值（1-10代表不推荐到推荐）',
  recomm_word varchar(100) comment '推荐语',
  `status` varchar(1) comment '状态',
  error_tips varchar(100) comment '错误原因'
)
