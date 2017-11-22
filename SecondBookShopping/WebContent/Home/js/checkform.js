// JavaScript Document
function checkregform(){
if(document.form1.email.value===""){
window.alert("请输入有效的邮箱地址！");
document.form1.name.focus();
return false;
}if(!checkEmail(document.form1.email.value)){
window.alert("邮箱地址格式不正确");
return false;
}
if(document.form1.user.value===""){
window.alert("请输入用户名！");
document.form1.user.focus();
return false;
}
if(document.form1.password.value===""){
window.alert("请输入密码！");
document.form1.password.focus();
return false;
}if(document.form1.passwordConfirm.value===""){
window.alert("请再次输入密码！");
document.form1.passwordConfirm.focus();
return false;
}if(document.form1.passwordConfirm.value.length<6||document.form1.password.value<6){
window.alert("密码长度必须大于6位！");
document.form1.passwordConfirm.value="";
document.form1.password.value="";
document.form1.password.focus();
return false;
}
if((document.form1.passwordConfirm.value)!=(document.form1.password.value)){
window.alert("两次密码不一致，请重新输入！");
document.form1.passwordConfirm.value="";
document.form1.password.value="";
document.form1.password.focus();
return false;
}else{
return true;
}
}

function checkregform_order(){
if(document.form1.email.value===""){
window.alert("��������Ч�������ַ��");
document.form1.email.focus();
return false;
}if(!checkEmail(document.form1.email.value)){
window.alert("�����ַ��ʽ����ȷ");
return false;
}if(document.form1.password1.value===""){
window.alert("���������룡");
document.form1.password1.focus();
return false;
}if(document.form1.passwordConfirm.value===""){
window.alert("���ٴ��������룡");
document.form1.passwordConfirm.focus();
return false;
}if((document.form1.passwordConfirm.value)!=(document.form1.password1.value)){
window.alert("�������벻һ�£����������룡");
document.form1.passwordConfirm.value="";
document.form1.password1.value="";
document.form1.password1.focus();
return false;
}if(document.form1.passwordConfirm.value.length<6||document.form1.password1.value<6){
window.alert("���볤�ȱ������6λ��");
document.form1.passwordConfirm.value="";
document.form1.password1.value="";
document.form1.password1.focus();
return false;
}
else{
window.location.href="order_confirm_new.htm";
}
}

function checkloginform(){
if(document.form1.name.value===""){
window.alert("�������û�����");
document.form1.name.focus();
return false;
}if(document.form1.password.value===""){
window.alert("���������룡");
document.form1.password.focus();
return false;
}else{
window.location.href="home.htm";
} 

}

function checkloginform_order(){
if(document.form1.name.value===""){
window.alert("�������û�����");
document.form1.name.focus();
return false;
}if(document.form1.password.value===""){
window.alert("���������룡");
document.form1.password.focus();
return false;
}else{
window.location.href="order_confirm.htm";
} 

}

function checkaddressform(){
if(document.form1.name.value===""){
window.alert("�������û�����");
document.form1.name.focus();
return false;
}if(document.form1.address.value===""){
window.alert("�������ַ��");
document.form1.address.focus();
return false;
}if(document.form1.phone.value===""){
window.alert("�������ֻ����룡");
document.form1.phone.focus();
return false;
}if(!checkTel(document.form1.phone.value)){
 window.alert("�ֻ������ʽ���ԣ�");
 document.form1.phone.value="";
document.form1.phone.focus();
return false;
}
else{
window.location.href="address.htm";
} 

}

function checkaddressnew(){
if(document.form1.name.value===""){
window.alert("�������û�����");
document.form1.name.focus();
return false;
}if(document.form1.address.value===""){
window.alert("�������ַ��");
document.form1.address.focus();
return false;
}if(document.form1.phone.value===""){
window.alert("�������ֻ����룡");
document.form1.phone.focus();
return false;
}if(!checkTel(document.form1.phone.value)){
 window.alert("�ֻ������ʽ���ԣ�");
 document.form1.phone.value="";
document.form1.phone.focus();
return false;
}else{
window.location.href="order_confirm.htm";
} 

}


function checkcommentform(){
var k=0;
	for(i=0;i<document.form1.radiobutton.length;i++){
		if(document.form1.radiobutton[i].checked)
		   k=1;
		}
if(k===0){
window.alert("���֣�");
return false;
}else{
window.location.href="item_info.htm";
} 

}

function checkpwdform(){
if(document.form1.email.value===""){
window.alert("���������䣡");
document.form1.email.focus();
return false;
}else{
window.alert("�����ѷ��͵��������䣬����գ�");	
window.location.href="pwd_find.htm";
	}

}

function checkinfoeditform(){
if(document.form1.passwordold.value===""){
window.alert("������ԭʼ���룡");
document.form1.passwordold.focus();
return false;
}if(document.form1.passwordnew.value===""){
window.alert("�����������룡");
document.form1.passwordnew.focus();
return false;
}if(document.form1.passwordConfirm.value===""){
window.alert("���ٴ����������룡");
document.form1.passwordConfirm.focus();
return false;
}else{
window.location.href="home.htm";
} 
}

function checkcredit(){
var creditVal=trim(document.form1.credit.value);
if(creditVal===""){
		window.alert("�������������");
		return false;
}	
if(checkIsNum(creditVal)){
	window.alert("��ʹ����"+creditVal+"�����֣�");
	}else{
		window.alert("����������Ϊ����0��������");	
		document.form1.credit.value="";
		document.form1.credit.focus();
	}
/*var creditVal=trim(document.form1.credit.value);
var zero=0;
if(creditVal===""){
		return true;
}
if(creditVal!=""&& creditVal<=0){
	window.alert("���������0�����֣�");
	document.form1.credit.value="";
	document.form1.credit.focus();
	return false;
	}if(creditVal!=""&& creditVal>0){
		if(!isInteger(creditVal)){
		  window.alert("������������ ");
		 document.form1.credit.value="";
	      document.form1.credit.focus();
	      return false;
		}if(creditVal.indexOf("0")===zero){
		window.alert("��ʽ����ȷ��");
		document.form1.credit.value="";
	      document.form1.credit.focus();
		return false;
		}else{
		   window.alert("��ʹ���� "+creditVal+"�����֣�");
	       return true;	
		}	
	
	}
	else{
		window.alert("���������֣�");
		document.form1.credit.value="";
		document.form1.credit.focus();
		return false;
	}*/
}

function checkitemno(){
	var itemNo1=trim(document.form1.itemNo1.value);
	var itemNo2=trim(document.form1.itemNo2.value);
if(itemNo1===""||itemNo2===""){
		window.alert("��������Ʒ������");
		return false;
}	
if(checkIsNum(itemNo1)&&checkIsNum(itemNo2)){
	window.alert("���³ɹ���");
	}else{
		window.alert("��Ʒ��������Ϊ����0��������");			
	}
}

function checkaddressdaohang(){
if(document.form1.name.value===""){
window.alert("�������û�����");
document.form1.name.focus();
return false;
}if(document.form1.address.value===""){
window.alert("�������ַ��");
document.form1.address.focus();
return false;
}if(document.form1.phone.value===""){
window.alert("�������ֻ����룡");
document.form1.phone.focus();
return false;
}if(!checkTel(document.form1.phone.value)){
 window.alert("�ֻ������ʽ���ԣ�");
 document.form1.phone.value="";
document.form1.phone.focus();
return false;
}else{
window.location.href="address_daohang.htm";
} 

}

//�����Ǹ�������

//�ж��ǲ�������
function isDigit(num) {

    var string="1234567890";

    if (string.indexOf(num) != -1) {

        return true;

    }

    return false;

}

//�ж��ǲ�������
function isInteger(val) {

    for (var i=0; i < val.length; i++) {

    if (!isDigit(val.charAt(i))) { return false; }

    }

    return true;

}
//ȥ��ո�; 
function ltrim(s){ 
return s.replace( /^\s*/, ""); 
} 
//ȥ�ҿո�; 
function rtrim(s){ 
return s.replace( /\s*$/, ""); 
} 
//ȥ���ҿո�; 
function trim(s){ 
return rtrim(ltrim(s)); 
}

//�����ύ������ȥ���ո���ж������Ƿ�Ϊ����0������
function checkIsNum(str){
var strTrim=trim(str);
var zero=0;
if(strTrim!=""&& strTrim<=0){
	
	return false;
	}if(strTrim!=""&& strTrim>0){
		if(!isInteger(strTrim)){
         return false;
		}if(strTrim.indexOf("0")===zero){
		
		return false;
		}else{		
	       return true;	
		}	
	
	}else{
			return false;
	}
}
// �ж��ַ����Ƿ�ÿ���ַ���Ϊ����
function checkNumStr(msg ){

 var norma = "0123456789"; 

 //msg = trim(msg); 

 for (var i=0; i<msg.length; i++) 

 {

  var temp = "" + msg.substring(i, i+1);

  if (norma.indexOf(temp) <0)

  {

   return  false;

  }

 }

 return true;

 

}



//����ֻ������ʽ�Ƿ���ȷ
function checkTel(tel){
//var str1="13";
//var str2="15";
if(!checkNumStr(tel)){		
		return false;
}//�����������ֵ��ַ�
if(tel.length!=11){
  return false;
}//λ����Ϊ11
if(tel.substring(0,2).indexOf("13",0)<0&&tel.substring(0,2).indexOf("15",0)<0){
   return false;//������13����15��ͷ
}else{
   return true;
}

}
//�ж������ַ�Ƿ���Ч
function checkEmail(email){
var pos1=email.indexOf("@",0);
 var   pos2 = email.indexOf(".",0);
//var   pos3 = email.lastIndexOf("@");
    // var   pos4 = email.lastIndexOf(".");
	if ((pos1 <= 0)||(pos1 === email.length)||(pos2 <= 0)||(pos2 === email.length))                
         return false;
       else
	     return true;

/*if(email.indexOf("@",0)<0){
	return false;
}
if(email.indexOf)
*/

}