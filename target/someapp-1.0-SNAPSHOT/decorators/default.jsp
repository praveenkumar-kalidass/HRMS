<!DOCTYPE html>
<%@ include file="/common/taglibs.jsp"%>

<%@page import="com.ideas2it.model.User"%>
<%@page import="com.ideas2it.model.Role"%>
<%@page import="com.ideas2it.model.Team"%>
<%@page import="org.springframework.security.authentication.AnonymousAuthenticationToken"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<html lang="en">
<head>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="<c:url value="images/logo1.png"/>"/>
    <title><decorator:title/></title>    
    <decorator:head/>
</head>
<body> 
<% 
   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
   if(!(auth instanceof AnonymousAuthenticationToken)){
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
       session.setAttribute("currentUserFullName", user.getFullName());
       session.setAttribute("currentUserId", user.getId());
       session.setAttribute("currentUserPicture", user.getPicture());
       session.setAttribute("currentUser", user);
       if(user.getTeam()!=null){
           session.setAttribute("currentProjectId", user.getTeam().getProject().getProjectId());
       }
       for(Role role : user.getRoles()){
    	   session.setAttribute("currentRole", role.getName());
       }
   }
%>
<decorator:getProperty property="body.id" writeEntireProperty="true"/>
<decorator:getProperty property="body.class" writeEntireProperty="true"/>
<decorator:body/>
<decorator:getProperty property="meta.menu"/>
</body>
</html>
