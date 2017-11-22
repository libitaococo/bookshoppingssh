<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>商品介绍</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/Home/style/reset.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/Home/style/main.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/Home/style/page.css">

<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript" src="js/ie6Fixpng.js"></script>
<![endif]-->
</head>

<body class="grey">
<div class="headerBar">
	<div class="topBar">
		<div class="comWidth">
			<div class="leftArea">
				<a href="#" class="collection">收藏</a>
			</div>
			<div class="rightArea">
				欢迎来到二手交易书城！<a href="${pageContext.request.contextPath}/Home/login.jsp">[登录]</a><a href="${pageContext.request.contextPath}/Home/registe.jsp">[免费注册]</a>
			</div>
		</div>
	</div>
	<div class="logoBar">
		<div class="comWidth">
			<div class="logo fl">
			</div>
			<div class="search_box fl">
				<input type="text" class="search_text fl">
				<input type="button" value="搜 索" class="search_btn fr">
			</div>
			<div class="shopCar fr">
				<span class="shopText fl" ><a href="cart_listcart.action">购物车</a></span>
				<span class="shopNum fl">0</span>
			</div>
		</div>
	</div>
	<div class="navBox">
		<div class="comWidth clearfix">
			<div class="shopClass fl">
				<h3>全部商品分类<i class="shopClass_icon"></i></h3>
				<div class="shopClass_show hide">
					<dl class="shopClass_item">
						<dt><a href="#" class="b">手机</a> <a href="#" class="b">数码</a> <a href="#" class="aLink">合约机</a></dt>
						<dd><a href="#">荣耀3X</a> <a href="#">单反</a> <a href="#">智能设备</a></dd>
					</dl>
					<dl class="shopClass_item">
						<dt><a href="#" class="b">手机</a> <a href="#" class="b">数码</a> <a href="#" class="aLink">合约机</a></dt>
						<dd><a href="#">荣耀3X</a> <a href="#">单反</a> <a href="#">智能设备</a></dd>
					</dl>
					<dl class="shopClass_item">
						<dt><a href="#" class="b">手机</a> <a href="#" class="b">数码</a> <a href="#" class="aLink">合约机</a></dt>
						<dd><a href="#">荣耀3X</a> <a href="#">单反</a> <a href="#">智能设备</a></dd>
					</dl>
					<dl class="shopClass_item">
						<dt><a href="#" class="b">手机</a> <a href="#" class="b">数码</a> <a href="#" class="aLink">合约机</a></dt>
						<dd><a href="#">荣耀3X</a> <a href="#">单反</a> <a href="#">智能设备</a></dd>
					</dl>
					<dl class="shopClass_item">
						<dt><a href="#" class="b">手机</a> <a href="#" class="b">数码</a> <a href="#" class="aLink">合约机</a></dt>
						<dd><a href="#">荣耀3X</a> <a href="#">单反</a> <a href="#">智能设备</a></dd>
					</dl>
				</div>
				<div class="shopClass_list hide">
					<div class="shopClass_cont">
						<dl class="shopList_item">
							<dt>电脑装机</dt>
							<dd>
								<a href="#">文字啊</a><a href="#">文字字啊</a><a href="#">文字字字啊</a><a href="#">文字啊</a><a href="#">文字</a><a href="#">文字啊</a>
							</dd>
						</dl>
						<dl class="shopList_item">
							<dt>电脑装机</dt>
							<dd>
								<a href="#">文字啊</a><a href="#">文字字啊</a><a href="#">文字字字啊</a><a href="#">文字啊</a><a href="#">文字</a><a href="#">文字啊</a><a href="#">文字啊</a><a href="#">文字字啊</a><a href="#">文字字字啊</a><a href="#">文字啊</a><a href="#">文字</a><a href="#">文字啊</a><a href="#">文字啊</a>
							</dd>
						</dl>
						<dl class="shopList_item">
							<dt>电脑装机</dt>
							<dd>
								<a href="#">文字啊</a><a href="#">文字字啊</a><a href="#">文字字字啊</a><a href="#">文字啊</a><a href="#">文字</a><a href="#">文字啊</a><a href="#">文字啊</a><a href="#">文字字啊</a><a href="#">文字字字啊</a><a href="#">文字啊</a><a href="#">文字</a><a href="#">文字啊</a><a href="#">文字啊</a>
							</dd>
						</dl>
						<dl class="shopList_item">
							<dt>电脑装机</dt>
							<dd>
								<a href="#">文字啊</a><a href="#">文字字啊</a><a href="#">文字字字啊</a><a href="#">文字啊</a><a href="#">文字</a><a href="#">文字啊</a><a href="#">文字啊</a><a href="#">文字字啊</a><a href="#">文字字字啊</a><a href="#">文字啊</a><a href="#">文字</a><a href="#">文字啊</a><a href="#">文字啊</a>
							</dd>
						</dl>
						<dl class="shopList_item">
							<dt>电脑装机</dt>
							<dd>
								<a href="#">文字啊</a><a href="#">文字字啊</a><a href="#">文字字字啊</a><a href="#">文字啊</a><a href="#">文字</a><a href="#">文字啊</a><a href="#">文字啊</a><a href="#">文字字啊</a><a href="#">文字字字啊</a><a href="#">文字啊</a><a href="#">文字</a><a href="#">文字啊</a><a href="#">文字啊</a>
							</dd>
						</dl>
						<div class="shopList_links">
							<a href="#">文字测试内容等等<span></span></a><a href="#">文字容等等<span></span></a>
						</div>
					</div>
				</div>
			</div>
			<ul class="nav fl">
				<li><a href="index_list.action" class="active">首页</a></li>
				<li><a href="#">新品排行版</a></li>
				<li><a href="#">团购</a></li>
				<li><a href="#">发现</a></li>
				<li><a href="#">销售排行榜</a></li>
				<li><a href="#">收藏夹</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="userPosition comWidth">
	<strong><a href="index_list.action">首页</a></strong>
	<span>&nbsp;&gt;&nbsp;</span>
	<a href="#"><s:property value="#p.cate.cname"/></a>
	<span>&nbsp;&gt;&nbsp;</span>
	<em><s:property value="#p.pid"/></em>
</div>
<div class="description_info comWidth">
	<div class="description clearfix">
		<div class="leftArea">
			<div class="description_imgs">
				<div class="big">
					<img width="300px" height="340px" src="<s:property value="#p.image"/>"  alt="">
				</div>
				<ul class="des_smimg clearfix">

				</ul>
			</div>
		</div>
		<div class="rightArea">
		<!-- 隐藏域-->
             <input name="pid" type="hidden"  value="<s:property value="#p.pid"/>"/>
             <!-- 隐藏域-->
             <input name="cid" type="hidden"  value="<s:property value="#p.cate.cid"/>"/>
			<div class="des_content">
				<h3 class="des_content_tit"><s:property value="#p.pname"/></h3>
				<div class="dl clearfix">
					<div class="dt">商品价</div>
					<div class="dd clearfix"><span class="des_money"><em>￥</em><s:property value="#p.mprice"/></span></div>
				</div>
				<div class="dl clearfix">
					<div class="dt">会员价</div>
					<div class="dd clearfix"><span class="des_money"><em>￥</em><s:property value="#p.vprice"/></span></div>
				</div>
				<div class="des_position">
					<div class="dl clearfix">
						<div class="dt">送到</div>
						<div class="dd clearfix">
							<div class="select">
								<h3>海淀区五环内</h3><span></span>
								<ul class="show_select">
									<li>上帝</li>
									<li>五道口</li>
									<li>上帝</li>
								</ul>
							</div>
							<span class="theGoods">有货，可当日出货</span>
						</div>
					</div>
					<div class="dl">
						<div class="dt des_num">数量</div>
						<div class="dd clearfix">
							<div class="des_number">
								<div class="reduction">-</div>
	                <form action="cart_add" method="post" enctype="multipart/form-data" name="form1">
								<input type="hidden" name="pid" value="<s:property value="#p.pid"/>">
								<input type="hidden" name="uid" value="<s:property value="#session.existUser.uid"/>">
								<div class="des_input">
									<input type="text" name="cnum"  value="<s:property value="1"/>">
								</div>
								
								<div class="plus">+</div>
							</div>
							<span class="xg">限购<em>9</em>件</span>
						</div>
					</div>
				</div>
					<div class="dl clearfix">
					<div class="dt">库存</div>
					<div class="dd clearfix"><span class="des_money"><s:property value="#p.pnum"/></span></div>
				</div>
				<div class="shop_buy">
					<!--  <a href="cart_add.action?pid=<s:property value="#p.pid"/>&uid=<s:property value="#session.existUser.uid"/>&cnum=<s:property value="#ct.cnum"/>" class="shopping_btn" name="sub"></a>-->
				 <input type="submit"  class="shopping_btn" name="sub" value="" onclick="if (confirm('确定要加入购物车吗？')) return true; else return false;">
				</div>
               </form>
				<br/>
				<div class="notes">
					注意：此商品可提供普通发票，不提供增值税发票。
				</div>
			</div>
		</div>
	</div>
</div>
<div class="hr_15"></div>
<div class="des_info comWidth clearfix">
	<div class="leftArea">
		<div class="recommend">
			<h3 class="tit">相似书籍</h3>
			<div class="item">
				<div class="item_cont">
					<div class="img_item">
						<a href="#"><img src="${pageContext.request.contextPath}/Home/images/tupian1.jpg" alt=""></a>
					</div>
					<p><a href="#">文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</a></p>
					<p class="money">￥23</p>
				</div>
			</div>
			<div class="item">
				<div class="item_cont">
					<div class="img_item">
						<a href="#"><img src="${pageContext.request.contextPath}/Home/images/tupian1.jpg" alt=""></a>
					</div>
					<p><a href="#">文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</a></p>
					<p class="money">￥23</p>
				</div>
			</div>
		
		</div>
		<div class="hr_15"></div>
		<div class="recommend">
			<h3 class="tit">热门书籍</h3>
			<div class="item">
				<div class="item_cont">
					<div class="img_item">
						<a href="#"><img src="${pageContext.request.contextPath}/Home/images/tupian1.jpg" alt=""></a>
					</div>
					<p><a href="#">文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</a></p>
					<p class="money">￥23</p>
				</div>
			</div>
	       	<div class="item">
				<div class="item_cont">
					<div class="img_item">
						<a href="#"><img src="${pageContext.request.contextPath}/Home/images/tupian1.jpg" alt=""></a>
					</div>
					<p><a href="#">文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</a></p>
					<p class="money">￥23</p>
				</div>
			</div>

			<div class="item">
				<div class="item_cont">
					<div class="img_item">
						<a href="#"><img src="${pageContext.request.contextPath}/Home/images/tupian1.jpg" alt=""></a>
					</div>
					<p><a href="#">文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</a></p>
					<p class="money">￥23</p>
				</div>
			</div>	
		</div>
	</div>
	
	
	<div class="rightArea">
		<div class="des_infoContent">
			<ul class="des_tit">
				<li class="active"><span>书籍介绍</span></li>
				<li><span>书籍评价(12312)</span></li>
			</ul>
			<div class="ad">
				<s:property value="#p.pdesc"/>
			</div>
			
		<div class="hr_15"></div>
		
		<div class="des_infoContent">
			<h3 class="shopDes_tit">商品评价</h3>
			<div class="score_box clearfix">
				<div class="score">
					<span>4.7</span><em>分</em>
				</div>
				<div class="score_speed">
					<ul class="score_speed_text">
						<li class="speed_01">非常不满意</li>
						<li class="speed_02">不满意</li>
						<li class="speed_03">一般</li>
						<li class="speed_04">满意</li>
						<li>非常满意</li>
					</ul>
					<div class="score_num">
						4.7<i></i>
					</div>
					<p>共18939位慕课网友参与评分</p>
				</div>
			</div>
			<div class="review_tab">
				<ul class="review fl">
					<li><a href="#" class="active">全部</a></li>
					<li><a href="#">满意（3121）</a></li>
					<li><a href="#">一般（321）</a></li>
					<li><a href="#">不满意（1121）</a></li>
				</ul>
				<div class="review_sort fr">
					<a href="#" class="review_time">时间排序</a><a href="#" class="review_reco">推荐排序</a>
				</div>
			</div>
			
			<div class="review_listBox">
			<s:iterator value="#p.comments" var="co">
			  <!-- 隐藏域-->
						<input type="hidden"  name="pid" value="<s:property value="#co.pro.pid"/>">
				<div class="review_list clearfix">
					<div class="review_userHead fl">
						<div class="review_user">	
							<img src="${pageContext.request.contextPath}/Home/images/userhead.jpg" alt="">
							<p><s:property value="#co.user.user"/></p>
						</div>
					</div>
					<div class="review_cont">
						<div class="review_t clearfix">
							<div class="starsBox fl">
							
							
							
							
							</div>
							<span class="stars_text fl"><s:property value="#co.score"/></span>
							<!--<span><input type="button" style="background-image: url(${pageContext.request.contextPath}/Home/graphics/bt2.gif);background-repeat: no-repeat;text-align: center;padding: 2px;height: 19px;width: 37px;border: 0;" name="button2" value="删除" onClick="javascript:window.location.href='comment_delete.action?coid=<s:property value="#co.coid"/>&pid=<s:property value="#co.pro.pid"/>&uid=<s:property value="#co.user.uid"/>'"></span>-->
							<s:if test="#co.user.user==#session.existUser.user">
						    <span><a style="background-image: url(${pageContext.request.contextPath}/Home/graphics/bt2.gif);background-repeat: no-repeat;text-align: center;padding: 2px;height: 19px;width: 37px;border: 0;" href="comment_delete.action?coid=<s:property value="#co.coid"/>&pid=<s:property value="#co.pro.pid"/>&uid=<s:property value="#co.user.uid"/>" onClick="if(window.confirm('确定删除？'));else return false">删除</a></span>
						    </s:if>
						    <s:else>
						     <span><a style="background-image: url(${pageContext.request.contextPath}/Home/graphics/bt2.gif);background-repeat: no-repeat;text-align: center;padding: 2px;height: 19px;width: 37px;border: 0;" href="#" onClick="if(window.confirm('无权删除'));else return false">删除</a></span>
						    </s:else>
						</div>
						<p><s:property value="#co.content"/></p>
						  <!-- 隐藏域-->
						<input type="hidden"  name="coid" value="<s:property value="#co.coid"/>">
						<p><a href="#" class="ding">顶(0)</a><a href="#" class="cai">踩(0)</a></p>
					</div>
				</div>
			</s:iterator>
				
				
			
			</div>
			
			<div class="yahoo2">
			</div>
			
			<div class="hr_25"></div>
			
			<div class="review_listBox" style="font-size:17px;">用户名：<s:property value="#session.existUser.user"/>
			
				<div class="hr_25"></div>
			
			<div class="review_listBox">
					<table width="770" border="0" cellpadding="0" cellspacing="0" class="main" >
<tr valign="top">
<td><form action="comment_handle" method="post" enctype="multipart/form-data" name="form1">
  <table width="100%" border="0" cellpadding="2" cellspacing="1" class="inputTable" align="center">
  <!-- 隐藏域-->
   <input type="hidden" name="pid" value="<s:property value="#p.pid"/>">
<!-- 隐藏域-->
   <!-- <input type="hidden" name="cid" value="<s:property value="#p.cate.cid"/>"> -->
    <tr>
      <td style="color: #FFFFFF;background-color: #71A7DA;font-weight: bold;padding: 3px;background-image: url(${pageContext.request.contextPath}/Home/graphics/loginbar1.gif);font-size: 12px; align: center;">添加评论</td>
    </tr>
    <tr>
      <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="1" style="border: 1px solid #CCCED8;background-color: #FAFAFA;">
          <tr>
            <td width="56" style="	color: #000000;padding: 2px;">打分：</td>
            <td width="103" style="color: #000000;padding: 2px;"><label>
              <input type="radio" name="score" value="1">
              <img src="${pageContext.request.contextPath}/Home/graphics/1star.JPG" alt="1星" width="13" height="13">很不喜欢
            </label></td>
            <td width="108" class="inputHeader"><input type="radio" name="score"  value="2">
              <img src="${pageContext.request.contextPath}/Home/graphics/2star.JPG" alt="2星" width="23" height="11">不喜欢 </td>
            <td width="107" class="inputHeader"><input type="radio" name="score" value="3">
              <img src="${pageContext.request.contextPath}/Home/graphics/3star.JPG" alt="3星" width="36" height="11">还行</td>
            <td width="116" class="inputHeader"><input type="radio" name="score" value="4">
              <img src="${pageContext.request.contextPath}/Home/graphics/4star.JPG" alt="4星" width="48" height="13">喜欢 </td>
            <td width="137" class="inputHeader"><input type="radio" name="score" value="5">
              <img src="${pageContext.request.contextPath}/Home/graphics/5star.JPG" alt="5星" width="62" height="11">              很喜欢 </td>
            <td width="127" class="inputHeader">&nbsp;</td>
          </tr>
				  <tr>
            <td width="56" style="color: #000000;padding: 2px;">评论：</td>
            <td colspan="5" style="color: #000000;padding: 2px;"><textarea style="tbackground-color: #FFFFFF;border: 1px solid #606060; width:560px;" name="content" rows="6" value="" ></textarea></td>
            <td class="inputHeader">&nbsp;</td>
            </tr>
            
              <tr>
            <td width="4%" style="color: #000000;padding: 2px;">&nbsp;</td>
            <td width="17%" style="inputHeader">&nbsp;</td>
            <td width="39%" style="color: #000000;padding: 2px;">
<input type="submit" style="background-image: url(${pageContext.request.contextPath}/Home/graphics/bt2.gif);background-repeat: no-repeat;text-align: center;padding: 2px;height: 19px;width: 37px;border: 0;" name="button2" value="提交" onClick="checkcommentform()"></td>
            <td width="40%" style="color: #000000;padding: 2px;">&nbsp;</td>
          </tr>
        </table>
 
				</td>
				</tr>
				</table>
				</form>
				</td>
				</tr>
				</table>
			</div>
			
		</div>
	</div>
</div>
</div>
</div>

<div class="hr_25"></div>
<div class="footer">
	<p><a href="#">简介</a><i>|</i><a href="#">公告</a><i>|</i> <a href="#">招纳贤士</a><i>|</i><a href="#">联系我们</a><i>|</i>客服热线：400-675-1234</p>
	<p>Copyright &copy; 2006 - 2014 版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373号&nbsp;&nbsp;&nbsp;某市公安局XX分局备案编号：123456789123</p>
	<p class="web"><a href="#"><img src="${pageContext.request.contextPath}/Home/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="__PUBLIC__/Home/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="${pageContext.request.contextPath}/Home/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="${pageContext.request.contextPath}/Home/images/webLogo.jpg" alt="logo"></a></p>
</div>
</body>
</html>
