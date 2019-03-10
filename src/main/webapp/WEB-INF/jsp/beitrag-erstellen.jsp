<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Create Contribution</title>
</head>
<body>
<h1>${heading}</h1>
<br/>
<form action="createPost" method="post">
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
        <input name="titel" type="text" />
      </td>
    </tr>
    <tr>
      <td>Beitrag:</td>
      <td><textarea cols="100" rows="10" name="inhalt"></textarea></td>
    </tr>
    <tr>
      <td></td>
      <td>
        <input type="submit" value="Speichern" />
      </td>
    </tr>
  </tbody>
</table>
</form>
<br/>
<hr>
<br/>
 <a href="/">Übersicht</a> 

</body>
</html>