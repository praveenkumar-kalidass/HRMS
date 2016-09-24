<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${Valid==0}" >
    <input type="hidden" id="userNameValidInput" value="inCorrect" >
</c:if>
<c:if test="${Valid==1}" >
    <input type="hidden" id="userNameValidInput" value="correct" >
</c:if>
