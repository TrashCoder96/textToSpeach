<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<body>

Введи текст на английком языке:

<form method="get" action="/send" >

    <input type="text" name="text" id="text" value="Let me speak from my heart in english" width="500px" />

    <input type="submit" value="Зачитать бред!" />

</form>

<img src="/img/picture.jpg" />

</body>

</html>