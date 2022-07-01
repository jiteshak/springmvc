<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="width: 300px;">
		<fieldset>
			<form action="updateprofile" method="post">
				<table>
					<tr>
						<td><input type="number" placeholder="Enter Employee Id"
							name="employeeId"></td>
					</tr>
					<tr>
						<td><input type="text" placeholder="Enter Name" name="name"></td>
					</tr>
					<tr>
						<td><input type="email" placeholder="Enter Email"
							name="email"></td>
					</tr>
					<tr>
						<td><input type="number" placeholder="Enter Age" name="age"></td>
					</tr>
					<tr>
						<td><button type="submit">SUBMIT</button></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
</body>
</html>