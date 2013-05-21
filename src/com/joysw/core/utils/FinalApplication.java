package com.joysw.core.utils;

public class FinalApplication {
	/**
	 * 条件(MAP)中的查询条条的KEY值
	 * */
	public static final String CASE_KEY_VALUE_NAME = "filedKey";
	/**
	 * 条件(MAP)中的值的KEY值
	 * */
	public static final String CASE_VALUE_KEY_NAME = "filedValue";
	/**
	 * 日期格式
	 */
	public static final String SIMPLEDATEFORMAT = "yyyy-MM-dd";
	public static final String LONGSIMPLEDATEFORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 日期格式
	 */
	public static final String FullDATEFORMAT = "yyyy-MM-dd HH:mm";
	/***
	 * 条件组合参数操作符KEY
	 * */
	public static final String CASE_GROUP_OPER_KEY = "group";

	public static final String CASE_GROUP_OPER_AND = " and ";

	public static final String CASE_GROUP_OPER_OR = " or ";

	/***
	 * 条件比较参数操作符KEY
	 * */
	public static final String CASE_OPER_KEY = "operator";

	/***
	 * 等于
	 * */
	public static final String CASE_OPER_EQ = " = ";
	/***
	 * 小于
	 * */
	public static final String CASE_OPER_LT = " < ";
	/***
	 * 小于等于
	 * */
	public static final String CASE_OPER_LT_EQ = " <= ";

	/***
	 * 大于等于
	 * */
	public static final String CASE_OPER_RT_EQ = " >= ";
	/***
	 * LIKE
	 * */
	public static final String CASE_OPER_LIKE = " like ";

	/**
	 * 排序(MAP)中的查询条条的KEY值
	 * */
	public static final Object SORT_KEY_VALUE_NAME = "filedKey";

	/**
	 * 排序(MAP)中的值的KEY值
	 * */
	public static final Object SORT_VALUE_KEY_NAME = "filedSortValue";

	/**
	 * 列表最大显示行数
	 * */
	public static final int PAGE_SHOW_MAX_ROW = 5;
	/**
	 * 列表最大显示行数
	 * */
	public static final int PAGE_SHOW_MAX_10ROW = 10;
	public static final int PAGE_SHOW_MAX_15ROW = 15;
	/**
	 * 列表最大显示行数
	 * */
	public static final int PAGE_SHOW_MAX_25ROW = 16;
	/**
	 * 列表最大显示行数
	 * */
	public static final int PAGE_SHOW_MAX_4ROW = 4;
	/**
	 * session中存的登录用户KEY值
	 */
	public static final String LOGIN_USER = "loginUser";
	public static final String LOGIN_DEPART = "loginDepart";

	/**
	 * 系统名称KEY值
	 */
	public static final String SYS_PROJECT_NAME = "sysName";

	/**
	 * 系统名称KEY值
	 */
	public static final String PRE_SYS_PROJECT_NAME = "pre_sysName";

	/**
	 * 系统名称KEY值
	 */
	public static final String APP_PROJECT_NAME = "app_sysName";

	/**
	 * session中存的登录用户所对应的角色信息
	 */
	public static final String LOGIN_USER_ROLES = "loginUserRoles";

	/**
	 * 条件中实体别名
	 * */
	public static final String CASE_DOMAIN_ALIAS = "domainAlias";

	public static final String dbName = "tomuse_develop";
	public static final String dbUserName = "postgres";
	public static final String dbPath = "C:\\Program Files (x86)\\PostgreSQL\\9.2\\bin\\";
}
