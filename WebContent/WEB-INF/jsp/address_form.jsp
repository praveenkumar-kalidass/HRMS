  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <c:if test="${same==1}">
 <div class="form-group row">
         <label for="example-text-input" class="col-md-4 col-form-label">Address</label>
                                   <div class="col-md-8">
                                            <textarea class="form-control" id="example-text-input" placeHolder="Address" readonly="readonly" ><c:out value="${address}" /></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Country</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" name="country1" value="<c:out value="${countries}" />" readonly="readonly" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">State</label>
                                        <div class="col-md-8">
                                           <input class="form-control" type="text" name="state1" value="<c:out value="${states}" />" readonly="readonly" />
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">City</label>
                                        <div class="col-md-8">
                                           <input  class="form-control" type="text" name="city1" value="<c:out value="${cities}" />" readonly="readonly" />
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Pincode</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" id="example-text-input" placeHolder="Pincode" value="<c:out value="${pincode}" />" readonly="readonly">
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Mobile Number</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" id="example-text-input" placeHolder="Mobile Number" value="<c:out value="${mobile}" />" readonly="readonly">
                                        </div>
                                    </div><script src="js/location.js"></script>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Email Address</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="email" id="example-text-input" placeHolder="Email Address" value="<c:out value="${email}" />" readonly="readonly">
                                        </div>
                                    </div>
                                    </c:if>
                                    <c:if test="${same==0}">
                                    
                                            <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Address</label>
                                        <div class="col-md-8">
                                            <textarea class="form-control" id="example-text-input" placeHolder="Address"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Country</label>
                                        <div class="col-md-8">
                                            <select name="country1" class="countries1 form-control" id="countryId1">
                                                <option value="">Select Country</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">State</label>
                                        <div class="col-md-8">
                                            <select name="state1" class="states1 form-control" id="stateId1">
												<option value="">Select State</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">City</label>
                                        <div class="col-md-8">
                                           <select name="city" class="cities1 form-control" id="cityId1">
												<option value="">Select City</option>
											</select>
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Pincode</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" id="example-text-input" placeHolder="Pincode">
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Mobile Number</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" id="example-text-input" placeHolder="Mobile Number">
                                        </div>
                                    </div><script src="js/location.js"></script>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Email Address</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="email" id="example-text-input" placeHolder="Email Address">
                                        </div>
                                    </div>
                                        
                                    </c:if>