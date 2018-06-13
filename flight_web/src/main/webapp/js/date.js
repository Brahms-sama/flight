function strDateTimeToJsDate(strDateTime) {
	var dateTime = Number(strDateTime);
	var d = new Date();
	d.setTime(dateTime);
	return d;
}

function formatJsAsString(jsDate) {
	var options = {
		weekday : 'long',
		year : 'numeric',
		month : 'long',
		day : 'numeric'
	};
	return jsDate.toLocaleDateString("fr-FR", options);
}

function strDateTimeToStrDate(strDateTime) {
	return formatJsAsString(strDateTimeToJsDate(strDateTime));
}