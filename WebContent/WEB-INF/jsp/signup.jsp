<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<link rel="stylesheet" href="css/style.css">

<title>ユーザー新規登録</title>
</head>
<body>
		<form action="SignupServlet" method="post">
			<table>
				<thead>
					<th colspan="2">
						<p style="background-color: #ff8080; color: white;">
							<c:if test="${errMsg != null}">
								${errMsg}
							</c:if>
						</p>
					</th>
				</thead>
				<tr>
					<td>
						<h1>ユーザー新規登録</h1>
					</td>
				</tr>
				<tr>
					<td>ログインID</td>
					<td><input type="text" name="loginId"></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>パスワード（確認）</td>
					<td><input type="password" name="confirm"></td>
				</tr>
				<tr>
					<td>ユーザー名</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>生年月日</td>
					<td><input type="text" name="birthDay" id="date"
						placeholder="例）1990-01-01"></td>
				</tr>
				<tr>
					<td><br>
					<a href="UserListServlet">戻る</a></td>
					<td><br> <input type="submit" value="登録"
						class="button button1"></td>
				</tr>
			</table>
		</form>
</body>
</html>

<script>
	$(document).ready(function() {

		$.datepicker.setDefaults({
			dateFormat : 'yy-mm-dd'
		});
		$(function() {
			$("#date").datepicker();

		});

	});
</script>



