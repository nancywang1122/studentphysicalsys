<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ include file="common/easyui.jsp"%>
<link href="<rootPath:rootPath/>/frontstage/css/css.css"
	rel="stylesheet" type="text/css">
<link href="<rootPath:rootPath/>/frontstage/css/css2.css"
	rel="stylesheet" type="text/css">
<script src="<rootPath:rootPath/>/frontstage/js/muen.js"
	type="text/javascript"></script>
<style type="text/css">

body 
{
	/*外补丁如果被设置了，将是用于计算环绕内联对象的边框区域的。它们的值不会影响内联对象所在行的高度( height )。外补丁总是透明( transparent )的。*/
	margin:0;
	/*内补丁对于 td 和 th 对象而言默认值为 1 。其他对象的默认值为 0 。*/
	padding:0;
	/*字体粗细，大小，行距，字体*/
	font: bold 11px/150% Verdana;
}
/*设置标题样式*/

/*取消所有图片边框*/
img 
{
	border: none;
} 
 
/*- Menu Tabs 1--------------------------- */ 

#tabs1
{
	/*当float<>none，则display=block */
	float: left;
	width:100%;
	background:#F4F7FB;
	font-size:93%;
	line-height:normal;
	/*menu下方的蓝色细线 */ 
	border-bottom:1px solid #BCD2E6;
}
#tabs1 ul
{
	margin: 0;
	padding: 10px 10px 0 50px;
	/*list-style-type=none，取消列表前的圆点 */ 
	list-style:none;
}
#tabs1 li
{
	/*将对象强制作为内联对象呈递，从对象中删除行*/
	display:inline;
    margin:0;
    padding:0;
}
#tabs1 a
{
	float:left;
	/*背景不重复，从左上角开始*/
    background:url("tableft1.gif") no-repeat left top;
    margin:0;
    /*离背景左边4px距离*/
    padding:0 0 0 4px;
    /*有链接的时候删除下划线*/
    text-decoration:none;
}
#tabs1 a span
{
	float:left;
	/*在属性值设为 block 的对象后面添加新行*/
	display:block;
    /*背景不重复，从右上角开始*/
    background:url("tabright1.gif") no-repeat right top;
    padding:5px 15px 4px 6px;
    /*字体颜色*/
    color:#627EB7;
}
    /* Commented Backslash Hack hides rule from IE5-Mac \*/
#tabs1 a span
{
	float: none;
}
    /* End IE5-Mac hack */
#tabs a:hover span
{
	color: #627EB7;
}
#tabs1 a:hover
{
	/* 背景向上42px */
	background-position: 0% -42px;
}
#tabs1 a:hover span
{
	background-position: 100% -42px;
}

</style>
<script type="text/javascript">
$(function() {
	loadFrontMenuBeans();
});
function loadFrontMenuBeans() {
	$.ajax( {
				url : '<rootPath:rootPath/>/frontmenumg/loadFrontMenuList?rand=' + Math.random(),
				contentType : "application/json;charset=utf-8",
				dateType : "json",
				cache : false,
				success : function(data) {
					var result = eval(data);
					var menuV1='';
					var mmm_idV='';
					for(var i =0;i<1;i++){
						var menuId1 = "'#mm_"+i+"'";
						var menuId2 = "'mm_"+i+"'";
						menuV1 = "<a href='#' class='easyui-menubutton' data-options='plain:false'>Edit</a>";
						mmm_idV='<div id="11" style="width: 150px;"><div>Undo</div>';
					}
					//alert(menuV1);
					//$("#frontmenu_id").html("");
					$("#mmm_id").html(mmm_idV);
					$("#frontmenu_id").html(menuV1);
				}
			});
}
</script>
</head>
<body>
	<div style="width: auto;" align="center">
		<div class="easyui-layout" data-options="border:false"
			style="width: 1100px; height: 1000px;">
			<div data-options="region:'north',border:false"
				style="width: 1100px;">
				<div class="easyui-layout" data-options="fit:true">
					<div data-options="region:'north',border:false"
						style="width: auto; height: 104px; overflow: hidden;">
						<div class="logo_bg">
							<img src="<rootPath:rootPath/>/frontstage/images/logo.jpg"
								style="float: left; margin: 18px 0 0 25px;" width="420"
								height="64"><img
								src="<rootPath:rootPath/>/frontstage/images/logo_bg2.gif"
								width="502" height="100" style="float: right;">
						</div>
					</div>
					<div data-options="region:'south',border:false"
						style="width: 1100px; height: 60px; overflow: hidden;">
						<div style="margin: 10px 0;"></div>

						<div id="tabs1">
							  <ul>
							    <li><a href="#" title="Link 1"><span>Link 1</span></a></li>
							    <li><a href="#" title="Link 2"><span>Link 2</span></a></li>
							    <li><a href="#" title="Link 3"><span>Link 3</span></a></li>
							    <li><a href="#" title="Longer Link Text"><span>Longer Link Text</span></a></li>
							    <li><a href="#" title="Link 5"><span>Link 5</span></a></li>
							    <li><a href="#" title="Link 6"><span>Link 6</span></a></li>
							    <li><a href="#" title="Link 7"><span>Link 7</span></a></li>
							  </ul>
							</div> 

						</div>
					</div>
				</div>
			</div>
			<div data-options="region:'east',border:true" style="width: 280px">
				<div class="easyui-layout" data-options="fit:true,border:false">
					<div data-options="region:'north',border:false"
						style="height: 272px;">
						<div id="calender_id" class="easyui-panel" title="用户登陆"
							style="width: 278px; height: 270px"
							data-options="iconCls:'icon-save',modal:true,border:false">
							<table>
								<tr>
									<td>用户名:</td>
									<td><input type="text" name="sysUserBean.userAccount"
										style="width: 150px;" class="easyui-validatebox"
										data-options="required:true" /></td>
								</tr>
								<tr>
									<td>密码:</td>
									<td><input type="text" name="sysUserBean.userPassword"
										style="width: 150px;" class="easyui-validatebox"
										data-options="required:true" /></td>
								</tr>
								<tr>
									<td colspan="2"><a class="easyui-linkbutton"
										data-options="iconCls:'icon-ok'" href="javascript:void(0)"
										id="submit_id" onclick="formSubmit()">登陆</a></td>
								</tr>
							</table>
						</div>
					</div>
					<div data-options="region:'center',border:false"
						style="height: 280px;">
						<div id="calender_id" class="easyui-panel" title="运动咨询"
							style="width: 278px; height: 270px"
							data-options="iconCls:'icon-save',modal:true,border:false">
							<div class="easyui-calendar" style="width: 278px; height: 220px;"></div>
						</div>
					</div>
					<div data-options="region:'south',border:false"
						style="height: 280px;">
						<div id="calender_id" class="easyui-panel" title="健康咨询"
							style="width: 278px; height: 270px"
							data-options="iconCls:'icon-save',modal:true,border:false">
							<div class="easyui-calendar" style="width: 278px; height: 220px;"></div>
						</div>
					</div>
				</div>
			</div>
			<div data-options="region:'center'">
				<div class="easyui-layout" data-options="fit:true,border:false">
					<div data-options="region:'north',border:false"
						style="height: 272px;" title="运动汇（运动资讯、图片新闻）"></div>
					<div data-options="region:'center',border:false"
						style="height: 272px;" title="健康咨询">
						<div class="zaixian_nr">
							<ul>
								<li><span>问</span>：浅议网络侵权责任之归属</li>
								<li>答：不动产登记与不动产物权变动的关系</li>
								<li><span>问</span>：对完善我国表见代理制度的思考</li>
								<li>答：产品侵权责任归责原则略论</li>
								<li><span>问</span>：浅谈离婚纠纷中按揭财产的分割</li>
								<li style="border: none;">答：离婚诉讼中如何认定夫妻分居</li>
							</ul>
						</div>
					</div>

					<div data-options="region:'south',border:false"
						style="height: 272px;" title="健康咨询">
						<div class="jianjie_nr">
							<div class="xuxian_bottom" style="padding: 16px 0;">
								<img src="<rootPath:rootPath/>/frontstage/images/tu_1.jpg"><span>欲修其身者，先正其心，欲正其心者，先
									诚其意。意诚而后心正。“健全的法律制度是 现代社会的基石”。</span>
								<div class="clear"></div>
							</div>
							<div style="margin-top: 6px;">作为一个普通的律师，以为人提供高质、高效的法律服务
								为自己的事业。我渴望看到当事人感谢的眼神，感谢的声 音，都是对自己辛勤劳动的肯定和对自己存在价值的认可。</div>
						</div>
					</div>
				</div>
			</div>
</body>
</html>