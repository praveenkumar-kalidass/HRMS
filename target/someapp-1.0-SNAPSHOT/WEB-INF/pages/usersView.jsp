<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${UserList.size()!=0}">
    <option value=""> -- Select -- </option>
    <c:forEach items="${UserList}" var="user">
        <option value="<c:out value='${user.id}' /> ">
            <c:out value='${user.firstName}' />
        </option>
    </c:forEach>
</c:if>  

<c:if test="${UserList.size()==0}">
    <option value=""> No Members or all members are allocated to another projects  </option>
</c:if>  