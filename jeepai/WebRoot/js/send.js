var xHRObject = false;
if (window.XMLHttpRequest)
{
xHRObject = new XMLHttpRequest();
}
else if (window.ActiveXObject)
{
xHRObject = new ActiveXObject("Microsoft.XMLHTTP");
}

function getData()
{
   
    if (xHRObject.readyState == 4)
    {
     
        if (xHRObject.status == 200)
        {
            var serverResponse = xHRObject.responseXML;

          var header = serverResponse.getElementsByTagName("NICKNAME");
           
            var spantag = document.getElementById("mynickname");
      
        
                if (window.ActiveXObject)
                {  var result=header[0].firstChild.text;
             
            
                	if(result>0){
                    spantag.innerHTML="<input type=\"button\" value=\"检查用户名\" onclick=\"checknickname()\"/><font color=\"#FF0000\">该用户名不可用</font>";}
                	else { spantag.innerHTML ="<input type=\"button\" value=\"检查用户名\" onclick=\"checknickname()\"/><font color=\"#FF0000\">该用户名可用</font>";}
                  
                }
                else
                {   var result=header[0].firstChild.textContent;
              
               
                	if(result>0){
                    spantag.innerHTML ="<input type=\"button\" value=\"检查用户名\" onclick=\"checknickname()\"/><font color=\"#FF0000\">该用户名不可用</font>";}
                	else { spantag.innerHTML ="<input type=\"button\" value=\"检查用户名\" onclick=\"checknickname()\"/><font color=\"#FF0000\">该用户名不可用</font>";}
                   
                }
        }
        }
    
}

function pingbikongge(){
	 //屏蔽空格键
	
}
function checknickname()
{
	      
          var nickname  = document.getElementById("nickname").value;
          
           
          xHRObject.open("GET", "ChecknickName?nickname=" + nickname + "&value=" + Number(new Date), true);
  
          xHRObject.onreadystatechange = getData;
          xHRObject.send(null);   
}


