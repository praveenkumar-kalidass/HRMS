<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <c:if test="${EmployeeList!=null}" >
     <option value="0"> -- Select -- </option>	
     <c:forEach items="${EmployeeList}" var="employee">
          <option value="<c:out value='${employee.employeeId}' /> "><c:out value='${employee.employeeFirstName}' /></option>
    </c:forEach>							
    </c:if>   
