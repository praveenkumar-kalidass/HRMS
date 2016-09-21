 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <div id="dialog-confirm" title="Alert" style="display:none;">
        <p>
            <c:if test="${message!=null}">
                <c:out value="${message}" /></c:if>
        </p>
    </div>