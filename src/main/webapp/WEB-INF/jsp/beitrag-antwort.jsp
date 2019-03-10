<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Answer Contribution</title>
</head>
<body>
<h1>${heading}</h1>
<br/>
<form action="createAnswer/${id}" method="post">
<table>
  <tbody>
    <tr>
      <td>Name:</td>
      <td>
        <input name="name" type="text" />
      </td>
    </tr>
    <tr>
      <td>Email:</td>
      <td>
        <input name="email"  type="text" />
      </td>
    </tr>
    <tr>
      <td>Titel des Beitrages:</td>
      <td>
        <input name="titel" type="text" value="Titel AW:"/>
      </td>
    </tr>
    <tr>
      <td>Beitrag:</td>
      <td><textarea cols="100" rows="10" name="inhalt" id="inhalt"></textarea></td>
    </tr>
    <tr>
      <td></td>
      <td>
        <input type="submit" value="Speichern" /> <input type="button" value="Löschen" onclick="document.getElementById('inhalt').value = ''"/>
      </td>
    </tr>
  </tbody>
</table>
</form>
<hr>
<br/>
 <a href="/">Übersicht</a> 

</body>
</html>