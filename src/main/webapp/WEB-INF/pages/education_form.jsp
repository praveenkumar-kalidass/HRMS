 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
  <spring:form method="post" action="education_insert" modelAttribute="User" class="form-group">

    <c:forEach items="${User.education}" var="certification" varStatus="status">

        <div class="col-md-8" style="padding-top:50px;">

            <c:if test="${status.index==0}">
                <h4> SSLC Details </h4>
                <hr />
            </c:if>

            <c:if test="${status.index==1}">
                <h4> HSC Details </h4>
                <hr />
            </c:if>

            <c:if test="${status.index==2}">
                <h4> Under Graduation Details </h4>
                <hr />
            </c:if>
            <c:if test="${status.index==3}">
                <h4> Post Graduation Details </h4>
                <hr />
            </c:if>

            <div class="form-group row">

                <div class="col-md-8">
                    <spring:input path="education[${status.index}].user.id" type="hidden" class="form-control" value="${User.id}" />
                    <c:if test="${status.index==0}">
                        <spring:input path="education[${status.index}].type" type="hidden" class="form-control" value="SSLC" readonly="readOnly" />
                    </c:if>
                    <c:if test="${status.index==1}">
                        <spring:input path="education[${status.index}].type" type="hidden" class="form-control" value="HSC" readonly="readOnly" />
                    </c:if>
                    <c:if test="${status.index==2}">
                        <spring:input path="education[${status.index}].type" type="hidden" class="form-control" value="UG" readonly="readOnly" />
                    </c:if>
                    <c:if test="${status.index==3}">
                        <spring:input path="education[${status.index}].type" type="hidden" class="form-control" value="PG" readonly="readOnly" />
                    </c:if>
                </div>
            </div>

            <div class="form-group row">
                <label for="example-text-input" class="col-md-4 col-form-label">
                    <c:if test="${status.index==0}">
                        Course Name
                    </c:if>
                    <c:if test="${status.index==1}">
                        Course Name
                    </c:if>
                    <c:if test="${status.index==2}">
                        Degree & Course Name
                        <br> Ex : BE(CSE)
                    </c:if>
                    <c:if test="${status.index==3}">
                        Degree & Course Name
                        <br> Ex : ME(CSE)
                    </c:if>

                </label>
                <div class="col-md-8">

                    <c:if test="${status.index==0}">
                        <spring:input path="education[${status.index}].qualification" class="form-control" value="SSLC" readonly="readonly" />
                    </c:if>
                    <c:if test="${status.index==1}">
                        <spring:input path="education[${status.index}].qualification" class="form-control" value="HSC" readonly="readonly" />
                    </c:if>
                    <c:if test="${status.index==2}">
                        <spring:input path="education[${status.index}].qualification" class="form-control" />
                    </c:if>
                    <c:if test="${status.index==3}">
                        <spring:input path="education[${status.index}].qualification" class="form-control" />
                    </c:if>

                </div>
            </div>

            <div class="form-group row">
                <label for="example-text-input" class="col-md-4 col-form-label">From Date</label>
                <div class="col-md-8">
                    <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input1<c:out value='${status.index}' />" data-link-format="yyyy-mm-dd">
                        <input class="form-control readonly" size="16" type="text" required="required" placeholder="From Date">
                        <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                    </div>
                    <spring:input path="education[${status.index}].fromDate" id="dtp_input1${status.index}" type="hidden" class="form-control" />

                </div>
            </div>

            <div class="form-group row">
                <label for="example-text-input" class="col-md-4 col-form-label">To Date</label>
                <div class="col-md-8">
                    <div class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2<c:out value='${status.index}' />" data-link-format="yyyy-mm-dd">
                        <input class="form-control readonly" size="16" type="text" required="required" placeholder="To Date" >
                        <span class="input-group-addon"><span class="fa fa-calendar"></span></span>
                    </div>
                    <spring:input path="education[${status.index}].toDate" id="dtp_input2${status.index}" type="hidden" class="form-control" />

                </div>
            </div>

            <div class="form-group row">
                <label for="example-text-input" class="col-md-4 col-form-label">Name of the Institution</label>
                <div class="col-md-8">
                    <spring:input path="education[${status.index}].institution" class="form-control" required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Name Minimum 5 Characters" />
                </div>
            </div>

            <div class="form-group row">
                <label for="example-text-input" class="col-md-4 col-form-label">Board/ University</label>
                <div class="col-md-8">
                    <spring:input path="education[${status.index}].board" class="form-control" required="required" data-validation="length" data-validation-length="min5" data-validation-error-msg="Please Enter the Valid Data Minimum 5 Characters" />
                </div>
            </div>

            <div class="form-group row">
                <label for="example-text-input" class="col-md-4 col-form-label">Percentage</label>
                <div class="col-md-8">
                    <spring:input path="education[${status.index}].percentage" class="form-control" required="required" data-validation="number" data-validation-allowing="float" data-validation-error-msg="Enter valid Percentage" />
                </div>
            </div>

        </div>

    </c:forEach>

    <div class="form-group row">
        <div class="col-md-12" align="center">
            <input class="btn btn-primary btn-lg" type="submit" value="Submit">
        </div>
    </div>
</spring:form>
                               
                               
                               
                               
                
