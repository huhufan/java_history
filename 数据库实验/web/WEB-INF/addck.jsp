<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@ page import="mypackage.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>���賬�й���ϵͳ--��Ʒ����</title>
<%
  ypxxop ypop=new ypxxop();
%>
<script language="javascript">
 	function check(){
		var myReg=new RegExp("^[0-9]+(\.[0-9]{1,4})?$");
		var identityCard = /^(\d{15}|\d{18})$/;
		var agetest=/^(\d{1,3})$/;
		if(document.opform.sl.value==""){
			alert("������������");
			return false;
		}
		if(document.opform.dj.value==""){
			alert("�����뵥�ۣ�");
			return false;
		}
		if(document.opform.je.value==""){
			alert("��������������");
			return false;
		}
	   document.all.regButton.disabled = true;
		 
	 	
	}
</script>
<script language = "JavaScript">
function changelocation()
    {
    document.opform.je.value=document.opform.sl.value*document.opform.dj.value
    
    }
	
</script>	
	
<style type="text/css">
<!--
.STYLE1 {
	color: #FF0000;
	font-size: 14px;
}
-->
</style>
</head>

<body>
<form name="opform" method="post" action="addck2.jsp" onSubmit="javascript:return check();">
    <table width="433" border="0" align="center" cellpadding="0" cellspacing="1" bordercolor="1" bgcolor="#00cccc" style="font-size:12px">
    <!--DWLayoutTable-->
    <tr>
      <td height="44" colspan="2" align="left" valign="middle" bgcolor="#00cccc"><div align="center"><span class="STYLE3 STYLE1"><strong>��Ʒ����ǰ̨</strong></span></div></td>
    </tr>
    
    <tr>
      <td width="115" height="34" align="center" valign="middle" bgcolor="#F9FCFF">��Ʒ��</td>
      <td width="427" align="left" valign="middle" bgcolor="#F9FCFF"><select name="ypid" id="ypid">
        <%
 
  
  ArrayList al2=new ArrayList();
   al2=ypop.getypxxbyall();
  ypxx yp=new ypxx();
  for(int i=0;i<al2.size();i++){
	  yp=(ypxx)al2.get(i);
	  
  %>
        <option value="<%=yp.getId()%>"><%=yp.getMc()%></option>
        <%}%>
      </select>
        *</td>
    </tr>
    
    <tr>
      <td height="63" align="center" valign="middle" bgcolor="#F9FCFF">����</td>
      <td align="left" valign="middle" bgcolor="#F9FCFF"><input name="sl" type="text" id="sl" value="1"  /></td>
    </tr>
  </table>
  
 

  <table width="551" border="0" cellpadding="0" cellspacing="0" align="center">
    <!--DWLayoutTable-->
    <tr>
      <td width="551" height="30" align="center" valign="middle"><input name="regButton" type="submit" id="regButton" value="ȷ��" />
      &nbsp;</td>
    </tr>
  </table>
   <input type="hidden" name="op" value="add" />
   
 

</form>
</body>
</html>
