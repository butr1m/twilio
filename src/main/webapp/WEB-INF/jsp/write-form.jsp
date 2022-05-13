<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="forrm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Twilio</title>
</head>
<body>
<h2> Write phone number and message</h2>
<br>
<br>
<form:form action="/sendMessage" modelAttribute="userDTO">

    Phone number <form:input path="phoneNumber"/>
    <br><br>
    Message <form:input path="message"/>
    <br><br>
    <input type="submit" value="Send message">
</form:form>
</body>
</html>