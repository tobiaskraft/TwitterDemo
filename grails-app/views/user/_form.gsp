<%@ page import="de.juka.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'account', 'error')} required">
	<label for="account">
		<g:message code="user.account.label" default="Account" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="account" maxlength="30" required="" value="${userInstance?.account}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'firstname', 'error')} ">
	<label for="firstname">
		<g:message code="user.firstname.label" default="Firstname" />
		
	</label>
	<g:textField name="firstname" value="${userInstance?.firstname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'lastname', 'error')} ">
	<label for="lastname">
		<g:message code="user.lastname.label" default="Lastname" />
		
	</label>
	<g:textField name="lastname" value="${userInstance?.lastname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="user.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${userInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'followers', 'error')} ">
	<label for="followers">
		<g:message code="user.followers.label" default="Followers" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.followers?}" var="f">
    <li><g:link controller="follower" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="follower" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'follower.label', default: 'Follower')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'following', 'error')} ">
	<label for="following">
		<g:message code="user.following.label" default="Following" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.following?}" var="f">
    <li><g:link controller="follower" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="follower" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'follower.label', default: 'Follower')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'tweets', 'error')} ">
	<label for="tweets">
		<g:message code="user.tweets.label" default="Tweets" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.tweets?}" var="t">
    <li><g:link controller="tweet" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="tweet" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'tweet.label', default: 'Tweet')])}</g:link>
</li>
</ul>

</div>

