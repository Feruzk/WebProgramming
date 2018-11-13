<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Login</title>
</head>
<body>
	<div class="box">
		<form class="LoginServlet" action="" method="post">
			<table>
				<tr>
					<c:if test="${errMsg != null}">
						<p style="alert alert-danger">${errMsg}</p>
					</c:if>
				</tr>
				<tr>
					<td><h1>ログイン画面</h1></td>
					<td></td>
				</tr>
				<tr>
					<td>ログインID</td>
					<td><input type="text" name="uname"></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type="password" name="pass"></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><input type="submit" value="ログイン" class="button button1">
					</td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>
