package de.juka

import grails.test.mixin.TestFor

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserTests {

    void testValidateUser() {

        // validation should fail if email is null
        def user = new User()

        assert !user.validate()
        assert "nullable" == user.errors["email"].code
    }

}
