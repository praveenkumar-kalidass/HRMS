<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${EmployeeList.size()!=0}">
    <option value="0"> -- Select -- </option>
    <c:forEach items="${EmployeeList}" var="employee">
        <option value="<c:out value='${employee.employeeId}' /> ">
            <c:out value='${employee.employeeFirstName}' />
        </option>
    </c:forEach>
</c:if>  

<c:if test="${EmployeeList.size()==0}">
    <option value="0"> No Members or all members are allocated to another projects  </option>
</c:if>  