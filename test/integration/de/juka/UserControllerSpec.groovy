package de.juka

import grails.plugin.spock.ControllerSpec
import spock.lang.Unroll

@Unroll
class UserControllerSpec extends ControllerSpec  {

    def "save new user #email -> success" () {
        setup:
            controller.metaClass.message = {args -> "mockMessage"}
        when:
            controller.params.account = account
            controller.params.email = email
            controller.params.firstname = 'first'
            controller.params.firstname = 'last'
        and:
            controller.save()
        then: 'flash message is shown'
            controller.flash.message != null
        and: "check view"
            controller.redirectArgs.action == "show"
        and: "check instance"
            controller.redirectArgs.id > 0
            def user = User.load(controller.redirectArgs.id)
            user.account == account
            user.version == 0
        where:
            account | email
            "TestAccount-1" | "account1@test.de"
            "TestAccount-2" | "account2@test.de"
    }

    def "edit - failure" () {
        setup:
            controller.metaClass.message = {args -> "mockMessage"}
        when:
            controller.params.id = 9999
        and:
            controller.edit()
        then:
            controller.flash.message != null
            controller.redirectArgs.action == "list"
    }

}
