function search()
{
	document.getElementById("bd").innerHTML='<img src="search.png" width=1250 height=650 usemap="#wmap"/>'+
			'<map id="wmap">'+
				'<area shape="rect" coords="0 20 50 60" href="javascript:desktop()" title="desktop">'+
				'<area shape="rect" coords="370 220 420 270" href="javascript:desktop();" title="desktop">'+
			'</map>';
}
function desktop()
{
	document.getElementById("bd").innerHTML='<img src="desktop.png" width=1250 height=650 usemap="#wmap"/>'+
			'<map id="wmap">'+
				'<area shape="rect" coords="0 20 50 60" href="javascript:search()" title="search">'+
				'<area shape="rect" coords="0 65 50 105" href="javascript:firefox()" title="firefox">'+
				'<area shape="rect" coords="0 110 50 150" href="javascript:file();" title="file browser">'+
			'</map>';
}
function firefox()
{
	document.getElementById("bd").innerHTML='<img src="firefox.png" width=1250 height=650 usemap="#wmap"/>'+
			'<map id="wmap">'+
				'<area shape="rect" coords="0 20 50 60" href="javascript:search()" title="search">'+
				'<area shape="rect" coords="0 65 50 105" href="javascript:desktop()" title="minimize">'+
				'<area shape="rect" coords="0 110 50 150" href="javascript:file();" title="file browser">'
			'</map>';
}
function file()
{
	document.getElementById("bd").innerHTML='<img src="files.png" width=1250 height=650 usemap="#wmap"/>'+
			'<map id="wmap">'+
				'<area shape="rect" coords="0 20 50 60" href="javascript:search()" title="search">'+
				'<area shape="rect" coords="0 65 50 105" href="javascript:firefox()" title="firefox">'+
				'<area shape="rect" coords="0 110 50 150" href="javascript:desktop();" title="minimize">'+
			'</map>';
}
