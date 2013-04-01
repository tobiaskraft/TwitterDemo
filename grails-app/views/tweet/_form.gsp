<%@ page import="de.juka.Tweet" %>



<div class="fieldcontain ${hasErrors(bean: tweetInstance, field: 'message', 'error')} ">
	<label for="message">
		<g:message code="tweet.message.label" default="Message" />
		
	</label>
	<g:textField name="message" maxlength="150" value="${tweetInstance?.message}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tweetInstance, field: 'created', 'error')} required">
	<label for="created">
		<g:message code="tweet.created.label" default="Created" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="created" precision="day"  value="${tweetInstance?.created}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: tweetInstance, field: 'location', 'error')} ">
	<label for="location">
		<g:message code="tweet.location.label" default="Location" />
		
	</label>
	<g:textField name="location" value="${tweetInstance?.location}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tweetInstance, field: 'author', 'error')} required">
	<label for="author">
		<g:message code="tweet.author.label" default="Author" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="author" name="author.id" from="${de.juka.User.list()}" optionKey="id" required="" value="${tweetInstance?.author?.id}" class="many-to-one"/>
</div>

