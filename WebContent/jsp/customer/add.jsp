﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
/*页面加载  */
/* $(function(){
	//利用ajax发请求 客户级别
	var url = "${pageContext.request.contextPath}/dict_findByCode.action";
	var param = {"dict_type_code":"006"};
	$.post(url,param,function(data){
		//i 索引 n对象
		$(data).each(function(i,n){ // i 是索引 ， n是对象 i和n只是随便取的一个名字
			$("#levelId").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
		});
	},"json");
	//客户来源
	var param = {"dict_type_code":"002"};
	$.post(url,param,function(data){
		//i 索引 n对象
		$(data).each(function(i,n){
			$("#sourceId").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
		});
	},"json");
}); */



$(function(){
	//客户级别
	var url = "${pageContext.request.contextPath}/dict_findByCode.action";
	var param = {"dict_type_code":"006"};
	$.post(url,param,function(data){
		$(data).each(function(i,n){
			$("#levelId").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
		});
	},"json");
	
	//信息来源
	var url = "${pageContext.request.contextPath}/dict_findByCode.action";
	var param = {"dict_type_code":"002"};
	$.post(url,param,function(data){
			$(data).each(function(i,n){
				
				$("#sourceId").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
			});
	},"json");
	
	
	//所属行业
	var url = "${pageContext.request.contextPath}/dict_findByCode.action";
	var param = {"dict_type_code":"001"};
	$.post(url,param,function(data){
			$(data).each(function(i,n){
				
				$("#industryId").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
			});
	},"json");
	
	
});








</script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/customer_save.action" method="post" enctype="multipart/form-data">
		
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 添加客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_name">
								</td>
								<td>客户级别 ：</td>
								<td>
									<select name="level.dict_id" id="levelId"></select>
								</td>
							</TR>
							
							<TR>
								
								<td>信息来源 ：</td>
								<td>
									<select name="source.dict_id" id="sourceId"></select>
								</td>
								
								<td>所属行业 ：</td>
								<td><select name="industry.dict_id" id="industryId"></select></td>
								
								<td>联系人：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_linkman">
								</td>
							</TR>
							
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_phone">
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_mobile">
								</td>
							</TR>
							
							<TR>
								<!-- <td>联系地址 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custAddress">
								</td>
								<td>邮政编码 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custZip">
								</td> -->
							</TR>
							<TR>
								<!-- <td>客户传真 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custFax">
								</td> -->
								<td>上传资质 ：</td>
								<td>
									<input type="file" name="upload"/>
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
