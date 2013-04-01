<%@ page import="de.juka.Follower" %>



<div class="fieldcontain ${hasErrors(bean: followerInstance, field: 'since', 'error')} required">
	<label for="since">
		<g:message code="follower.since.label" default="Since" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="since" precision="day"  value="${followerInstance?.since}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: followerInstance, field: 'follow', 'error')} required">
	<label for="follow">
		<g:message code="follower.follow.label" default="Follow" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="follow" name="follow.id" from="${de.juka.User.list()}" optionKey="id" required="" value="${followerInstance?.follow?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: followerInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="follower.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${de.juka.User.list()}" optionKey="id" required="" value="${followerInstance?.user?.id}" class="many-to-one"/>
</div>

