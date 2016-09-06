 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
                               <c:if test="${noof!=0}">
                               <table>
                               <tr>
                               <td>
                               S.no
                               </td>
                               <td>
                                Course Name
                               </td>
                               <td>
                               From Date
                               </td>
                               <td>
                               To Date
                               </td>
                               <td>
                               Institution Name 
                               </td>
                               </tr>
                               <form method="post"  class="form-group" >
                               <c:forEach begin="1" end="${noof}" varStatus="form">
                               <tr>
                               <td>
                               <c:out value="${form.index}" />
                               </td>
                               <td>
                               <input type="text"  class="form-control" id="example-text-input"  >
                               </td>
                               <td>
                               <input type="date"  class="form-control" id="example-text-input"  >
                               </td>
                               <td>
                               <input type="date"  class="form-control" id="example-text-input"  >
                               </td>
                               <td>
                               <input type="text"  class="form-control" id="example-text-input"  >
                               </td>                               
                               </tr>
                               </c:forEach>
                               <tr>
                               <td colspan="5" align="center">
                                <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Save">
                                </td>
                               </tr>
                                                              
                               </form>
                               
                               </table>
                               </c:if>
