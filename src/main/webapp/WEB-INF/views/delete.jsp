<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Employee Page</title>
</head>
<body>
	<div style="width: 300px;">
		<fieldset>
			<form action="deleteemp" method="post">
				<table>
					<tr>
						<td><input type="number" placeholder="EnterEmployeeId"
							name="employeeId"></td>
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