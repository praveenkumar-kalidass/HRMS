 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<c:if test="${noof!=0}">
    <spring:form method="post" action="certification_insert" modelAttribute="User" class="form-group">
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

            <c:forEach items="${User.certification}" var="certification" varStatus="status">
                <tr>
                    <td>
                        <c:out value="${status.index+1}" />

                        <spring:input path="certification[${status.index}].user.id" type="hidden" class="form-control" value="${User.id}" />
                    </td>
                    <td>
                        <spring:input path="certification[${status.index}].courseName" class="form-control" required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Data Minimum 5 Characters" />

                    </td>
                    <td>
                        <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input1<c:out value='${status.index}' />" data-link-format="yyyy-mm-dd">
                            <input class="form-control readonly" size="16" type="text" required="required" placeholder="From Date">
                            <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                        </div>
                        <spring:input path="certification[${status.index}].fromDate" id="dtp_input1${status.index}" type="hidden" class="form-control" />
                    </td>
                    <td>
                        <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2<c:out value='${status.index}' />" data-link-format="yyyy-mm-dd">
                            <input class="form-control readonly" size="16" type="text" required="required" placeholder="To Date">
                            <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                        </div>
                        <spring:input path="certification[${status.index}].toDate" id="dtp_input2${status.index}" type="hidden" class="form-control" placeHolder="Date of Birth" />

                    </td>
                    <td>
                        <spring:input path="certification[${status.index}].institution" class="form-control" required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Data Minimum 5 Characters" />
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5" align="center">
                    <input class="btn btn-primary btn-lg" type="submit" id="example-text-input" value="Save">
                </td>
            </tr>

        </table>
    </spring:form>
</c:if>
