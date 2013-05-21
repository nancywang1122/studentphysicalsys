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
					alert(menuV1);
					//$("#frontmenu_id").html("");
					$("#frontmenu_id").html(menuV1);
					$("#mmm_id").html(mmm_id);
				}
			});
}
</script>
</head>
<body>
	<div class="juzhong">
		<div class="top">
			<div class="top_top">
				<span style="float: left; margin-left: 14px;">欢迎访问某律师团队专业法律服务网！
					建站咨询热线: 15886674344</span><span style="float: right; margin-right: 6px;">今天是:
					2008.10.22. 星期三</span>
				<div class="clear"></div>
			</div>
			<div class="logo_bg">
				<img src="<rootPath:rootPath/>/frontstage/images/logo.jpg"
					style="float: left; margin: 18px 0 0 25px;" width="420" height="64"><img
					src="<rootPath:rootPath/>/frontstage/images/logo_bg2.gif"
					width="502" height="100" style="float: right;">
				<div class="clear"></div>
			</div>
			<div class="muen">
				<div class="subnav">
					<ul id="nuw">
						<li class="one"><a href="index.html">&nbsp;&nbsp;&nbsp;&nbsp;首页</a></li>
						<li class="one"><a href="lvshijieshao.html">关于我们</a>
							<ul>
								<li><a href="lvshijieshao.html">律师介绍</a></li>
								<li><a href="lvsuojieshao.html">律所介绍</a></li>
								<li><a href="shoufeibiaozhun.html">收费标准</a></li>
							</ul></li>
						<li class="one"><a href="jiaonidaguanshi.html">法律服务</a>
							<ul>
								<li><a href="jiaonidaguanshi.html">教您打官司</a></li>
								<li><a href="http://www.865171.cn">请律师指南</a></li>
								<li><a href="http://www.865171.cn">法律援助</a></li>
							</ul></li>
						<li class="one"><a href="xingfa.html">法律文书</a>
							<ul>
								<li><a href="xingfa.html">刑法专栏</a></li>
								<li><a href="http://www.865171.cn">公司法专栏</a></li>
								<li><a href="http://www.865171.cn">婚姻法专栏</a></li>
								<li><a href="http://www.865171.cn">民商法专栏</a></li>
								<li><a href="http://www.865171.cn">房地产法专栏</a></li>
								<li><a href="http://www.865171.cn">知识产权专栏</a></li>
							</ul></li>
						<li class="one"><a href="shouji.html">律师手记</a></li>
						<li class="one"><a href="anlie.html">经典案例</a>
							<ul>
								<li><a href="http://www.865171.cn">我们的法律服务好在哪里</a></li>
								<li><a href="anlie.html">经典案例</a></li>
								<li><a href="http://www.865171.cn">案例详解</a></li>
							</ul></li>
						<li class="one"><a href="zaixianfalv.html"
							style="background-image: none;">在线服务</a>
							<ul>
								<li><a href="zaixianfalv.html">在线法律咨询</a></li>
								<li><a href="http://www.865171.cn">办案进度查询</a></li>
							</ul></li>
					</ul>
				</div>
				<div class="sousuo">
					<input name="" type="text" class="input" value="站内搜索"> <input
						name="Submit" type="image" id="Submit" value="提交"
						src="<rootPath:rootPath/>/frontstage/images/fangda.gif"
						style="float: left; margin: 0 8px;"> <select name=""
						class="select">
						<option>中文版</option>
						<option>英文版</option>
					</select>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="main">
			<div class="left">
				<div class="banner">
					<div align="center">
						<!-- 焦点图切换开始 更多请访问懒人图库 -->
						<DIV id=nav>
							<UL>
								<LI><IMG
									src="<rootPath:rootPath/>/frontstage/images/01.jpg"
									text="健全的法律制度是现代社会的基石|陆欣律师事务所" pic="1">
									<DIV>一个海岛</DIV></LI>
								<LI><IMG
									src="<rootPath:rootPath/>/frontstage/images/02.jpg"
									text="美景如画的海景|天蓝海蓝" pic="2">
									<DIV>一片麦穗</DIV></LI>
								<LI><IMG
									src="<rootPath:rootPath/>/frontstage/images/03.jpg"
									text="郁郁葱葱的生命|生生不息的生命" pic="3">
									<DIV>一树绿叶</DIV></LI>
								<LI><IMG
									src="<rootPath:rootPath/>/frontstage/images/04.jpg"
									text="孤独的一棵老树|等谁呢？" pic="4">
									<DIV>一棵大树</DIV></LI>
								<LI><IMG
									src="<rootPath:rootPath/>/frontstage/images/05.jpg"
									text="明媚的向日葵花|生生不息的生命" pic="5">
									<DIV>一地葵花</DIV></LI>
							</UL>
							<DIV id=BG></DIV>
							<DIV id=mask></DIV>
							<DIV id=back>
								<IMG height=255 src="" width=685>
							</DIV>
						</DIV>
						<p>
							<SCRIPT type=text/javascript>
 <!--
 var num = 0;
 $("#nav").hide();
	$("li img").load(function(){
		num++;
		if (num==4)
		{
			$("#nav").show();
		}
	})
		.click(function(){
		
		//如果已经处于active状态，return
		if (this.className.indexOf("active")!=-1) return;
		
		//正文文字渐隐
		$("#frontText").fadeOut();
		$("#frontTextBack").fadeOut();
		$("#frontTextSub").fadeOut();

		//active状态的图片恢复原样
		$("li img.active").fadeTo(200,0.6)
		.removeClass("active")
		.animate({top:5,width:70,left:1},300)
		.parent().css({"color":"#aaa"});  //
		
		//获取数据
		var i = $(this).attr("pic");
		var t = $(this).attr("text").split("|");
		
		//当前
		$(this).animate({top:-5,width:70,height:40,left:1},100)
		.addClass("active")
		.fadeTo(200,1)
		.parent().css({"color":"white"});

		$("#back").children().addClass("gray").end()
					.fadeTo(500,0.1,function(){
										//var IMG = new Image();
										//IMG.s
										$(this).children("img").attr("src","<rootPath:rootPath/>/frontstage/images/"+i+".jpg").removeClass("gray");	  //更改图片
										$(this).fadeTo(500,1,function(){
																$("#frontText").html(t[0]).fadeIn(200);	//更改正文文字
																$("#frontTextBack").html(t[0]).fadeIn(200);	//阴影文字
																$("#frontTextSub").html(t[1]).fadeIn(200)}	//副标题
																);
										})
		})

	//初始第一张图片
	
	var i =0;

	show();

	function show(){
		if (i==$("li img").size()) i = 0
		$("li img").eq(i).click();
		i++;
		//setTimeout(show(),1000);
	}

	document.oncontextmenu   =  function(e){return false}
	
	if (self.location.search!=""){
		var V = self.location.search;
		V = V.substr(1,V.length);
		eval(V);
		var json ="{";
		if (option.skin==0)
			$("#mask").hide();
		if (option.animate == 0){
		$("#nav ul").hide();
		}
		$("#nav").width(option.width?option.width:685);
		$("#nav").height(option.height?option.height:255);
		$("#back img").width($("#nav").width());
		$("#back img").height($("#nav").height());
		$(self.parent.document.getElementById("splash")).children().height($("#nav").height()).width($("#nav").width());
	}
		
 //-->
  </SCRIPT>
							<!-- 焦点图切换结束-->
					</div>
				</div>
				<div class="zaixian" style="margin-top: 269px;">
					<div class="title_top">
						<div class="title">在线法律资讯</div>
						<a href="http://www.865171.cn"><img
							src="<rootPath:rootPath/>/frontstage/images/more2.gif" border="0"></a>
						<div class="clear"></div>
					</div>
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
				<div class="jianjie" style="margin-top: 269px;">
					<div class="title_top">
						<div class="title">陆欣律师简介</div>
						<a href="http://www.865171.cn"><img
							src="<rootPath:rootPath/>/frontstage/images/more2.gif" border="0"></a>
						<div class="clear"></div>
					</div>
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
				<div class="clear"></div>
			</div>
			<div class="right">
				<div class="yewulingyu">
					<span style="float: left;">业务领域</span><a href="#"
						style="float: right; margin-top: 4px;"><img
						src="<rootPath:rootPath/>/frontstage/images/more1.gif" width="28"
						height="13" border="0"></a>
				</div>
				<div class="clear"></div>
				<div class="lingyu_nr">
					<ul>
						<li>民商诉讼业务</li>
						<li>公司业务</li>
						<li>证券业务</li>
						<li>国际业务</li>
						<li>民商诉讼业务</li>
						<li>民商诉讼业务</li>
						<li>证券业务</li>
						<li>国际业务</li>
						<li>民商诉讼业务</li>
						<li>民商诉讼业务</li>
					</ul>
				</div>
				<div class="tu_1">
					<img src="<rootPath:rootPath/>/frontstage/images/tu_1.gif"
						border="0">
				</div>
				<div class="youqing">
					<div class="youqinglianjie">友情链接</div>
					<div class="youqinglianjie_2">
						<select name="select" class="search">
							<option value="auction" selected="selected">-------------友情链接------------</option>
							<option value="shop">搜索店铺</option>
							<option value="nick">搜索掌柜</option>
							<option value="info">搜索资讯</option>
							<option value="web">搜索网页</option>
						</select>
					</div>
					<div class=" clear"></div>
				</div>
				<div class="clear"></div>
				<div class="tu_1">
					<img src="<rootPath:rootPath/>/frontstage/images/tu_2.gif"
						width="295" height="51" border="0">
				</div>
				<div class="dongtai">
					<div class="dongtai_top_left">网站动态</div>
					<div class="dongtai_top_right">
						<a href="http://www.865171.cn"><img
							src="<rootPath:rootPath/>/frontstage/images/more2.gif" border="0"></a>
					</div>
					<div class="clear"></div>
					<div class="dongtai_nr">
						<a href="http://www.865171.cn">京都律师事务所2007年大事记回顾</a><br> <a
							href="http://www.865171.cn">我所田文昌律师赴澳门科技大学讲学…</a><br> <a
							href="http://www.865171.cn">陈登富涉嫌贪污行贿、挪用公款一案开庭… </a>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="bottom">
			<div class="bottom_left">
				<a href="http://www.865171.cn">联系我们</a> | <a
					href="http://www.865171.cn">在线咨询</a> | <a
					href="http://www.865171.cn">网站地图</a> | <a
					href="http://www.865171.cn">官方博客</a> | <a
					href="http://www.865171.cn">隐私声明</a>
			</div>
			<div class="bottom_right">地址：中国上海 邮政编码：200000 沪ICP备案号00000000号
			</div>
		</div>
	</div>
</body>
</html>