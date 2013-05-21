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
	
 <link type="text/css" href="<rootPath:rootPath/>/frontstage/css/menu.css" rel="stylesheet" />
    <script type="text/javascript" src="<rootPath:rootPath/>/frontstage/js/jquery.js"></script>
    <script type="text/javascript" src="<rootPath:rootPath/>/frontstage/js/menu.js"></script>

<script type="text/javascript">
	$(function() {
		loadFrontMenuBeans();
	});
	function loadFrontMenuBeans() {
		$.ajax({url : '<rootPath:rootPath/>/frontmenumg/loadFrontMenuList?rand='
							+ Math.random(),
					contentType : "application/json;charset=utf-8",
					dateType : "json",
					cache : false,
					success : function(data) {
						$("#nuw").html(data);
					}
				});
	}
</script>

<script type="text/javascript">
<!--
	var num = 0;
	$("#nav").hide();
	$("li img").load(function() {
		num++;
		if (num == 4) {
			$("#nav").show();
		}
	}).click(
			function() {
				//如果已经处于active状态，return
				if (this.className.indexOf("active") != -1)
					return;
				//正文文字渐隐
				$("#frontText").fadeOut();
				$("#frontTextBack").fadeOut();
				$("#frontTextSub").fadeOut();
				$("li img.active").fadeTo(200, 0.6).removeClass("active")
						.animate({
							top : 5,
							width : 70,
							left : 1
						}, 300).parent().css({
							"color" : "#aaa"
						}); //

				//获取数据
				var i = $(this).attr("pic");
				var t = $(this).attr("text").split("|");
				//当前
				$(this).animate({
					top : -5,
					width : 70,
					height : 40,
					left : 1
				}, 100).addClass("active").fadeTo(200, 1).parent().css({
					"color" : "white"
				});

				$("#back").children().addClass("gray").end().fadeTo(
						500,
						0.1,
						function() {
							//var IMG = new Image();
							//IMG.s
							$(this).children("img").attr(
									"src",
									"<rootPath:rootPath/>/frontstage/images/images/"
											+ i + ".jpg").removeClass("gray"); //更改图片
							$(this).fadeTo(500, 1, function() {
								$("#frontText").html(t[0]).fadeIn(200); //更改正文文字
								$("#frontTextBack").html(t[0]).fadeIn(200); //阴影文字
								$("#frontTextSub").html(t[1]).fadeIn(200)
							} //副标题
							);
						})
			})

	//初始第一张图片
	var i = 0;
	show();
	function show() {
		if (i == $("li img").size())
			i = 0
		$("li img").eq(i).click();
		i++;
		//setTimeout(show(),1000);
	}
	document.oncontextmenu = function(e) {
		return false
	}
	if (self.location.search != "") {
		var V = self.location.search;
		V = V.substr(1, V.length);
		eval(V);
		var json = "{";
		if (option.skin == 0)
			$("#mask").hide();
		if (option.animate == 0) {
			$("#nav ul").hide();
		}
		$("#nav").width(option.width ? option.width : 685);
		$("#nav").height(option.height ? option.height : 255);
		$("#back img").width($("#nav").width());
		$("#back img").height($("#nav").height());
		$(self.parent.document.getElementById("splash")).children().height(
				$("#nav").height()).width($("#nav").width());
	}
//-->
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
						

<div id="menu">
    <ul class="menu">
        <li><a href="#" class="parent"><span>Home</span></a>
            <div><ul>
                <li><a href="#"><span>Sub Item 1</span></a></li>
                <li><a href="#"><span>Sub Item 2</span></a></li>
                <li><a href="#"><span>Sub Item 3</span></a></li>
            </ul></div>
        </li>
        <li><a href="#" class="parent"><span>Product Info</span></a>
            <div class="columns two">
                <ul class="one">
                    <li><a href="#"><span>Sub Item 1.1</span></a></li>
                    <li><a href="#"><span>Sub Item 1.2</span></a></li>
                    <li><a href="#"><span>Sub Item 1.3</span></a></li>
                    <li><a href="#"><span>Sub Item 1.4</span></a></li>
                    <li><a href="#"><span>Sub Item 1.5</span></a></li>
                    <li><a href="#"><span>Sub Item 1.6</span></a></li>
                    <li><a href="#"><span>Sub Item 1.7</span></a></li>
                </ul>
                <ul class="two">
                    <li><a href="#"><span>Sub Item 2.1</span></a></li>
                    <li><a href="#"><span>Sub Item 2.2</span></a></li>
                    <li><a href="#"><span>Sub Item 2.3</span></a></li>
                    <li><a href="#"><span>Sub Item 2.4</span></a></li>
                    <li><a href="#"><span>Sub Item 2.5</span></a></li>
                    <li><a href="#"><span>Sub Item 2.6</span></a></li>
                </ul>
            </div>
        </li>
        <li><a href="#"><span>Help</span></a></li>
        <li class="last"><a href="#"><span>Contacts</span></a></li>
    </ul>
</div>
					</div>
				</div>
				<div data-options="region:'east',border:true" style="width: 280px">
					<div class="easyui-layout" data-options="fit:true,border:false">
						<div data-options="region:'north',border:false"
							style="height: 272px;">
							<div id="calender_id" class="easyui-panel" title="当前日期"
								style="width: 278px; height: 270px"
								data-options="iconCls:'icon-save',modal:true,border:false">
								<div class="easyui-calendar"
									style="width: 278px; height: 220px;"></div>
							</div>
						</div>
						<div data-options="region:'center',border:false"
							style="height: 280px;">
							<div id="calender_id" class="easyui-panel" title="运动咨询"
								style="width: 278px; height: 270px"
								data-options="iconCls:'icon-save',modal:true,border:false">
								<div class="easyui-calendar"
									style="width: 278px; height: 220px;"></div>
							</div>
						</div>
						<div data-options="region:'south',border:false"
							style="height: 280px;">
							<div id="calender_id" class="easyui-panel" title="健康咨询"
								style="width: 278px; height: 270px"
								data-options="iconCls:'icon-save',modal:true,border:false">
								<div class="easyui-calendar"
									style="width: 278px; height: 220px;"></div>
							</div>
						</div>
					</div>
				</div>
				<div data-options="region:'center'">
					<div class="easyui-layout" data-options="fit:true,border:false">
						<div data-options="region:'north',border:false"
							style="height: 272px;" title="运动汇（运动资讯、图片新闻）">
							<!-- 焦点图切换开始 更多请访问懒人图库 -->
							<DIV id=nav>
								<UL>
									<LI><IMG
										src="<rootPath:rootPath/>/frontstage/images/images/01.jpg"
										text="健全的法律制度是现代社会的基石|陆欣律师事务所" pic="1">
										<DIV>一个海岛</DIV></LI>
									<LI><IMG
										src="<rootPath:rootPath/>/frontstage/images/images/02.jpg"
										text="美景如画的海景|天蓝海蓝" pic="2">
										<DIV>一片麦穗</DIV></LI>
									<LI><IMG
										src="<rootPath:rootPath/>/frontstage/images/images/03.jpg"
										text="郁郁葱葱的生命|生生不息的生命" pic="3">
										<DIV>一树绿叶</DIV></LI>
									<LI><IMG
										src="<rootPath:rootPath/>/frontstage/images/images/04.jpg"
										text="孤独的一棵老树|等谁呢？" pic="4">
										<DIV>一棵大树</DIV></LI>
									<LI><IMG
										src="<rootPath:rootPath/>/frontstage/images/images/05.jpg"
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
								<!-- 焦点图切换结束-->
						</div>

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