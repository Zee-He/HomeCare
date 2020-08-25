function getQueryVariable(variable)
{
	var query = window.location.search.substring(1);
	var vars = query.split("&");
	for (var i=0;i<vars.length;i++) {
		var pair = vars[i].split("=");
		if(pair[0] == variable){return pair[1];}
	}
	return(false);
}

function getUrlParams() {
	o = {}
	for (const i of window.location.search.substring(1).split('&')) {
		p = i.split('=')
		o[p[0]] = p[1]
	}
	return o
}