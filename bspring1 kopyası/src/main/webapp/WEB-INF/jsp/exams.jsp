<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="bitirme.model.ClassicExam" %>
<%@ page import="bitirme.model.TestExam" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
  * {
    box-sizing: border-box;
  }
  body {
     margin: 0;
     font-family: Arial, Helvetica, sans-serif;
   }
  input[type=text], select, textarea {
    width: 20%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    resize: vertical;
  }

  label {
    padding: 12px 12px 12px 0;
    display: inline-block;
  }

  input[type=submit] {
    background-color: dodgerblue;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    float: right;
    padding: 20px;
  }

  input[type=submit]:hover {
    background-color: #45a049;

    padding: 20px;
  }

  container {
    border-radius: 5px;
    padding: 20px;
  }
  /* Container for flexboxes */
  section {
    display: -webkit-flex;
    display: flex;
  }

filter {

}

/* Style the left table */
tableleft {
  -webkit-flex: 3;
  -ms-flex: 3;
  flex: 3;
  padding: 20px;
}

/* Style the right table */
tableright {
  -webkit-flex: 3;
  -ms-flex: 3;
  flex: 3;
  padding: 20px;
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
  section {
    -webkit-flex-direction: column;
    flex-direction: column;
  }

}

table {
  border-collapse: collapse;
  width: 90%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover {background-color:#f5f5f5;}



form {
	width: 80%;
    padding: 20px;
}
  .btn{

    margin-top: 0px;
    background-color: dodgerblue;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    float: left;
    margin-left: 00px;
  }
</style>
<title>Insert title here</title>
</head>
<body>

<div class="header">
  <a href="#default" class="logo">CompanyLogo</a>
  <div class="header-right">
    <a href="/home">Ana sayfa</a>
    <a class="active" href="/exams">Sınavlar</a>
    <a href="/candidates">Adaylar</a>
    <a href="/results">Sonuçlar</a>
    <a href="#about">Hesabım</a>
    <a href="/index">Çıkış</a>
  </div>
</div>



<div class="container">
  <p font-size="15px">Sınav ara</p>
  <form action="/exams" method="post">
    <div>
      <label for="id">Sınav no</label>
      <input type="text" name="id" placeholder="..">

      <!--
      <label for="type">Sınav Tipi</label>
      <input type="text" id="type" name="Sınav Tipi" placeholder="Y..">
      -->


      <label for="examtype">Sınav tipi</label>
      <select id="examtype" name="examtype">
        <option value="test">Test</option>
        <option value="classic">Klasik</option>
      </select>

      <input type="submit" value="Sınav Ara">

    </div>
  </form>
  
  <form action="/exams" method="GET">
    <div>
      <input type="submit" value="Test Sınav ekle" formaction="/exams/new/test">
      <input type="submit" value="Klasik Sınav ekle" formaction="/exams/new/classic">

    </div>
  </form>


</div>

<section>
<tableleft>
  <p>Klasik sınavlar</p>
<table>
<tr>
    <th>Numara</th>
    <th>Sınav Başlangıç Tarihi</th>
    <th>Sınav Bitiş Tarihi</th>
    <th>Sınav Süresi</th>
  </tr>

	<c:forEach items="${clsexam}" var="exams"> 

  <tr>
    <th>${exams.examId}</th>
    <th>${exams.duration}</th>
    <th>${exams.examStartingDate}</th>
    <th>${exams.examFinishingDate}</th>
  </tr>
  </c:forEach>
 </table>
</tableleft>


<tableright>

  <p>Test sınavlar</p>
  <table>
    <tr>
      <th>Numara</th>
      <th>Sınav Başlangıç Tarihi</th>
      <th>Sınav Bitiş Tarihi</th>
      <th>Sınav Süresi</th>
    </tr>
<c:forEach items="${tstexam}" var="texams"> 

  <tr>
    <th>${texams.examId}</th>
    <th>${texams.duration}</th>
    <th>${texams.examStartingDate}</th>
    <th>${texams.examFinishingDate}</th>
  </tr>
  </table>
</tableright>

</section>
</body>
</html>
