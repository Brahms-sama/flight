<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="col-md-8" ng-controller="resaCtrl">
    -${vol }- {{test}}/{{id}}
</div>
<div class="col-md-4">
    <div class="panel panel-primary">
        <!-- Contenu avec la classe .panel-default -->
        <div class="panel-heading text-center">
            <h3>Vol nÂ°{{vol.num}}</h3>
        </div>

        <!-- List group -->
        <ul class="list-group">
            <li class="list-group-item">DÃ©part : <b>{{vol.depart.localite.ville}}
								({{vol.depart.localite.aeroport}})</b><br> Heure : {{vol.depart.dateTime}}
            </li>
            <li class="list-group-item">ArrivÃ©e : <b>{{vol.arrivee.localite.ville}}
								({{vol.arrivee.localite.aeroport}})</b><br> Heure : {{vol.arrivee.dateTime}}
            </li>
            <li class="list-group-item">Prix : <b>{{vol.prix}}â‚¬ TTC</b></li>
            <li class="list-group-item">
                <button class="btn btn-primary btn-lg btn-block">RÃ©server</button>
            </li>
        </ul>
    </div>
</div>

</body>
</html>