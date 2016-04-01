<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表界面由freemarker生成</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>name</th>
				<th>age</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.age}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>