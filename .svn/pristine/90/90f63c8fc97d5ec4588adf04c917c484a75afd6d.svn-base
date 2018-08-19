function oculta (kpa) {
    document.getElementById(kpa).style.visibility="hidden";
}

function muestra (kpa) {
   document.getElementById(kpa).style.visibility="visible";
}

function get(id){
	return document.getElementById(id);
}

var options1 = {
		 displayNav: false,
	   	 modal: true
	    };

var options2 = {
		 displayNav: true,
	   	 modal: true
	    };

function showLoading(){
   Shadowbox.open({
       content:    '<div align="center" valign="center" style="font-family: Verdana, Helvetica;color:#BBBBBB"><br />Espere un momento ...<br /><img src="resources/images/ajax-loader.gif"/></div>',
       player:     "html",
       title:      "",
       height:     70,
       width:      300,
       options: options1
   });
}

function hideLoading(){
   Shadowbox.close();
}


function showMsg(msg,nRows) {
	Shadowbox.open({
       content:    '<div align="center" valign="center" style="font-family: Verdana, Helvetica;color:#BBBBBB;font-size:13px;">'+
       				'<table><tr><td width="60"rowspan="30" align="left"><img src="resources/images/errorPage.png" height="48" width="48"/></td><td width="120" align="center" ><br /><br />'
       				+msg+
       				'</td><tr><td align="center" ><br /><br />'+
       				'<input type="button" value="OK" onclick="hideMsg();"/></td></tr>'+
       				'</div>',
       player:     "html",
       title:      	 "",
       height:     100+(25*nRows),
       width:      300,
       options: options1
   });
}

function showMsgContent(msg,nRows) {
	Shadowbox.open({
       content:    msg,
       player:     "html",
       title:      "",
       height:     100+(25*nRows),
       width:      300,
       options: options1
   });
}

function showMsgFrame(url, ancho, alto){
	Shadowbox.open({
		content:    url,
		player:     "iframe",
		title:      "",
		height:     alto,
	    width:      ancho,
	    options: options2
	});
}

function hideMsg()
{
	Shadowbox.close();
}


function regresarPasoPrevio(_link, url)
{
	showLoading();
	_link.href = url;
	return true;
}
