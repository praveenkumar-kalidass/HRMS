<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${DesignationList!=null}">
    <option value="0"> -- Select -- </option>
    <c:forEach items="${DesignationList}" var="designation">
        <option value="<c:out value='${designation.designationId}' />">
            <c:out value='${designation.designationName}' />
        </option>
    </c:forEach>
</c:if>    
