  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
  <c:if test="${same==1}">
 <div class="form-group row">
         <label for="example-text-input" class="col-md-4 col-form-label">Address</label>
                                   <div class="col-md-8">
                                            <textarea name="addresses[1].street" class="form-control" placeHolder="Address" readonly="readonly"  ><c:out value="${address}" /></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Country</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" name="addresses[1].country" value="<c:out value="${countries}" />" readonly="readonly" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">State</label>
                                        <div class="col-md-8">
                                           <input class="form-control" type="text" name="addresses[1].state" value="<c:out value="${states}" />" readonly="readonly" />
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">City</label>
                                        <div class="col-md-8">
                                           <input  class="form-control" type="text" name="addresses[1].city" value="<c:out value="${cities}" />" readonly="readonly" />
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Pincode</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" name="addresses[1].pincode" placeHolder="Pincode" value="<c:out value="${pincode}" />" readonly="readonly">
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Mobile Number</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" name="addresses[1].phoneNumber" placeHolder="Mobile Number" value="<c:out value="${mobile}" />" readonly="readonly">
                                        </div>
                                    </div><script src="js/location.js"></script>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Email Address</label>
                                        <div class="col-md-8">
                                            <input class="form-control" type="email" name="addresses[1].eMail" placeHolder="Email Address" value="<c:out value="${email}" />" readonly="readonly">
                                        </div>
                                    </div>
                                    
                                     <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Type</label>
                                        <div class="col-md-8">
                                            <input  name="addresses[1].addressType" type="text" class="form-control" value="Perment" readonly="readOnly"  />
                                        </div>
                                    </div> 
                                        
                                    </c:if>
                                    <c:if test="${same==0}">
                                    
                                            <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Address</label>
                                        <div class="col-md-8">
                                        <textarea name="addresses[1].street" class="form-control" id="address" placeHolder="Address"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Country</label>
                                        <div class="col-md-8">
                                            <select name="addresses[1].country" class="countries1 form-control" id="countryId1">
                                                <option value="">Select Country</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">State</label>
                                        <div class="col-md-8">
                                             <select name="addresses[1].state" class="states1 form-control" id="stateId1">
												<option value="">Select State</option>
                                           </select>
                                        
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">City</label>
                                        <div class="col-md-8">
                                          <select name="addresses[1].city" class="cities1 form-control" id="cityId1">
												<option value="">Select City</option>
											</select>
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Pincode</label>
                                        <div class="col-md-8">
                                              <input type="text"  name="addresses[1].pincode" class="form-control"  id="pincode" placeHolder="Pincode" />
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Mobile Number</label>
                                        <div class="col-md-8">
                                            <input type="text"   name="addresses[1].phoneNumber" class="form-control"  id="mobile" placeHolder="Mobile Number" />
                                        </div>
                                    </div><script src="js/location.js"></script>


                                    <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Email Address</label>
                                        <div class="col-md-8">
                                             <input type="text"  name="addresses[1].eMail" class="form-control"  id="email" placeHolder="Email Address" />
                                        </div>
                                    </div>
                                    
                                    
                                      <div class="form-group row">
                                        <label for="example-text-input" class="col-md-4 col-form-label">Type</label>
                                        <div class="col-md-8">
                                            <input type="text" name="addresses[1].addressType" class="form-control" value="Perment" readonly="readOnly"  />
                                        </div>
                                    </div> 
                                    </c:if>
