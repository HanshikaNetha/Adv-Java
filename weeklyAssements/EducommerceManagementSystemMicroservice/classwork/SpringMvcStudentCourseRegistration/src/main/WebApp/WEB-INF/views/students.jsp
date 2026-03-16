<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table border="1">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Course</th>
    <th>Age</th>
    <th>Action</th>
</tr>

<c:forEach var="student" items="${students}">
<tr>
    <td>${student.id}</td>
    <td>${student.name}</td>
    <td>${student.email}</td>
    <td>${student.course}</td>
    <td>${student.age}</td>
    <td>
        <a href="delete/${student.id}">Delete</a>
    </td>
</tr>
</c:forEach>

</table>