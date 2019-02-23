<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="bitirme.model.ClassicExam" %>
<%@ page import="bitirme.service.ExamServiceWeb" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>

body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
}


.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}
.header a.logo {
  font-size: 25px;
  font-weight: bold;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

.header a.active {
  background-color: dodgerblue;
  color: white;
}

.header-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
    
  }
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
   }
  .header-right {
    float: none;
  }
  .container {
   width: 25%;
  }
}

table {
  border-collapse: collapse;
  width: 60%;
  float: right;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover {background-color:#f5f5f5;}


input[type=text], select, textarea {
  width: 50%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
  float: right;
}
input[type=date], select, datearea {
  width: 50%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
  float: right;
}
input[type=int], select, intarea {
  width: 50%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
  float: right;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
  float: left;
}

input[type=submit] {
  background-color: dodgerblue;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: left;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

.col-100 {
  float: left;
  width: 75%;
  margin-top: 6px;
  visibility: hidden;
}
/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
.rowquest {
  content: "";
  display: table;
  clear: both;
}
form {
	width: 35%;
}
.btn{

  margin-top: 20px;
  background-color: dodgerblue;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: left;
  margin-left: 20px;
}

</style>
<title>Insert title here</title>
</head>
<body>

<div class="header">
  <a href="#default" class="logo">CompanyLogo</a>
  <div class="header-right">
    <a href="/home">Ana sayfa</a>
    <a href="/exams">Sınavlar</a>
    <a class="active" href="/candidates">Adaylar</a>
    <a href="/results">Sonuçlar</a>
    <a href="#about">Hesabım</a>
    <a href="/index">Çıkış</a>
  </div>
</div>

<div class="container">
  <form action="/candidates/new" method="post" commandName="user">
  <div class="row">
    <div class="col-25">
      <label for="name">Aday adı</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="username" placeholder=".." path= "name">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="surname">Soyadı</label>
    </div>
    <div class="col-75">
      <input type="text" id="surname" name="surname" placeholder=".." path= "surname">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="password">Aday şifresi</label>
    </div>
    <div class="col-75">
      <input type="password" id="password" name="password" placeholder=".." path= "password">
    </div>
  </div>
	<input type="submit" value="Submit">
  </form>

  </div>


</body>
</html>