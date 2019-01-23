<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leggi l'allegato della fattura</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
</script>
<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>

<input id="file-input" type="file" name="name" accept=".xml"/>
<button onclick="leggiAllegato()">Leggi Allegato</button>
<p id="p1"> </p>
</body>
</html>