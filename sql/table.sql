-- 建表sql
-- 用户表
create table sys_user (
    user_id varchar(32) not null default '0',
    login_name varchar(16) not null default '',
    user_name varchar(30) not null default '',
    user_type smallint,
    email varchar(64),
    phone_number varchar(11),
    gender smallint not null default 0,
    password varchar(50) not null default '',
    salt varchar(20) not null default '',
    status integer not null,
    description varchar(256),
    create_by varchar(32) not null default '',
    create_time timestamp not null default current_timestamp,
    update_by varchar(32),
    update_time timestamp,
    primary key (user_id)
);

comment on table sys_user is '用户信息表';
comment on column sys_user.user_id is '用户标识';
comment on column sys_user.login_name is '登录名';
comment on column sys_user.user_name is '用户名';
comment on column sys_user.user_type is '用户类型';
comment on column sys_user.email is '邮箱';
comment on column sys_user.phone_number is '电话号码';
comment on column sys_user.gender is '性别';
comment on column sys_user.password is '登录密码';
comment on column sys_user.salt is '盐加密';
comment on column sys_user.status is '状态';
comment on column sys_user.description is '描述';
comment on column sys_user.create_by is '创建用户';
comment on column sys_user.create_time is '创建时间';
comment on column sys_user.update_by is '更新用户';
comment on column sys_user.update_time is '更新时间';

-- 菜单表
create table sys_menu (
    menu_id varchar(32) not null default '',
    name varchar(16) not null default '',
    parent_id varchar(32),
    menu_order integer not null default 0,
    url varchar(200) not null default '',
    target integer not null default 0,
    type integer not null default 0,
    status integer not null default 0,
    permission varchar(100),
    icon varchar(100),
    description varchar(256),
    create_by varchar(32) not null default '',
    create_time timestamp not null default now(),
    update_by varchar(32),
    update_time timestamp,
    primary key (menu_id)
);

comment on table sys_menu is '菜单表';
comment on column sys_menu.menu_id is '菜单ID';
comment on column sys_menu.name is '菜单名称';
comment on column sys_menu.parent_id is '父菜单ID';
comment on column sys_menu.menu_order is '显示顺序';
comment on column sys_menu.url is '请求地址';
comment on column sys_menu.target is '打开方式';
comment on column sys_menu.type is '菜单类型';
comment on column sys_menu.status is '菜单状态';
comment on column sys_menu.permission is '权限';
comment on column sys_menu.icon is '菜单图标';
comment on column sys_menu.description is '描述';
comment on column sys_menu.create_by is '创建用户';
comment on column sys_menu.create_time is '创建时间';
comment on column sys_menu.update_by is '更新用户';
comment on column sys_menu.update_time is '更新时间';

-- 用户-角色关联表
create table sys_user_role (
    user_role_id varchar(32) not null default '',
    user_id varchar(32) not null default '',
    role_id varchar(32) not null default '',
    create_time timestamp not null default now(),
    primary key (user_role_id)
);

comment on table sys_user_role is '用户-角色关联表';
comment on column sys_user_role.user_role_id is '关联标识';
comment on column sys_user_role.user_id is '用户标识';
comment on column sys_user_role.role_id is '角色标识';
comment on column sys_user_role.create_time is '分配时间';

-- 角色-菜单关联表
create table sys_menu_role (
    menu_role_id varchar(32) not null default '',
    role_id varchar(32) not null default '',
    menu_id varchar(32) not null default '',
    create_time timestamp not null default now(),
    primary key (menu_role_id)
);

comment on table sys_menu_role is '角色-菜单关联表';
comment on column sys_menu_role.menu_role_id is '关联标识';
comment on column sys_menu_role.role_id is '角色标识';
comment on column sys_menu_role.menu_id is '菜单标识';
comment on column sys_menu_role.create_time is '分配时间';

-- 枚举类型表
create table sys_enum (
    enum_type varchar(16) not null default '',
    enum_name varchar(16) not null default '',
    enum_description varchar(256) not null default '',
    enum_status integer not null default 1,
    primary key (enum_type)
);

comment on table sys_enum is '枚举类型表';
comment on column sys_enum.enum_type is '枚举类型';
comment on column sys_enum.enum_name is '枚举名';
comment on column sys_enum.enum_description is '类型描述';
comment on column sys_enum.enum_status is '状态';

-- 枚举值表
create table sys_enum_value (
    enum_type varchar(16) not null default '',
    enum_value varchar(16) not null default '',
    enum_name varchar(16) not null default '',
    enum_sort integer not null default 0,
    enum_default boolean not null default false,
    enum_status integer not null default 1,
    enum_description varchar(256) not null default '',
    primary key (enum_type, enum_value)
);

comment on table sys_enum_value is '枚举值表';
comment on column sys_enum_value.enum_type is '类型代码';
comment on column sys_enum_value.enum_value is '类型值';
comment on column sys_enum_value.enum_name is '枚举值的翻译';
comment on column sys_enum_value.enum_sort is '排序';
comment on column sys_enum_value.enum_default is '是否默认值';
comment on column sys_enum_value.enum_status is '状态';
comment on column sys_enum_value.enum_description is '描述';

-- 配置表
create table sys_config (
    config_code varchar(16) not null default '',
    config_name varchar(16) not null default '',
    config_value varchar(256) not null default '',
    config_description varchar(256) not null default '',
    primary key (config_code)
);

comment on table sys_config is '配置表';
comment on column sys_config.config_code is '参数代码';
comment on column sys_config.config_name is '参数名';
comment on column sys_config.config_value is '参数值';
comment on column sys_config.config_description is '描述';

-- 提示消息表
create table sys_message (
    message_code varchar(10) not null default '',
    message_text varchar(64) not null default '',
    message_type integer not null default 1,
    message_status integer not null default 1,
    message_description varchar(256) not null default '',
    primary key (message_code)
);

comment on table sys_message is '提示消息表';
comment on column sys_message.message_code is '错误码';
comment on column sys_message.message_text is '提示文本';
comment on column sys_message.message_type is '提示类型';
comment on column sys_message.message_status is '状态';
comment on column sys_message.message_description is '描述';
