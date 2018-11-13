<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>ユーザ情報詳細参照</title>
</head>
<body>

 <div class ="box">
	<table>

		<tr>
			<td>
				<h1>ユーザ情報詳細参照</h1>
			</td>
		</tr>


		<tr>
			<td>ログインID:</td>
			<td>${userList.loginId}</td>
			<td>(${userList})</td>
		</tr>

		<tr>

		</tr>
		<tr>
			<td>ユーザー名:</td>
			<td>${userList.name}</td>
		</tr>

		<tr>
			<td>生年月日:</td>
			<td>${userList.birthDate}</td>

		</tr>

		<tr>
			<td>アカウント作成した日付:</td>
			<td>${userList.createDate}</td>
		</tr>
		<tr>
			<td>アカウント更新した日付:</td>
			<td>${userList.updateDate}</td>
		</tr>

		<tr>

			<td><br>
			<p><a href = "UserListServlet"><small>戻る</small></a></p></td>
		</tr>
	</table>
 </div>

</body>
</html>
