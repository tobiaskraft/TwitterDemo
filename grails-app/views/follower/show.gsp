
<%@ page import="de.juka.Follower" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'follower.label', default: 'Follower')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-follower" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-follower" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list follower">
			
				<g:if test="${followerInstance?.since}">
				<li class="fieldcontain">
					<span id="since-label" class="property-label"><g:message code="follower.since.label" default="Since" /></span>
					
						<span class="property-value" aria-labelledby="since-label"><g:formatDate date="${followerInstance?.since}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${followerInstance?.follow}">
				<li class="fieldcontain">
					<span id="follow-label" class="property-label"><g:message code="follower.follow.label" default="Follow" /></span>
					
						<span class="property-value" aria-labelledby="follow-label"><g:link controller="user" action="show" id="${followerInstance?.follow?.id}">${followerInstance?.follow?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${followerInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="follower.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${followerInstance?.user?.id}">${followerInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${followerInstance?.id}" />
					<g:link class="edit" action="edit" id="${followerInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
