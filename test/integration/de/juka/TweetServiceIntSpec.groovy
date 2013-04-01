package de.juka

import grails.plugin.spock.IntegrationSpec
import spock.lang.Unroll

class TweetServiceIntSpec extends IntegrationSpec {

    def tweetService

    def setup() {

    }

    @Unroll
    def "check tweets for author #account"() {
        given:
            def params = [:]
        when:
            def result = tweetService.getMyTweets(account, params)
        then:
            result.totalCount == count
        where:
            account         | count
            'tobias'        | 1
            'grails'        | 4
            'grailsplugins' | 10
    }

}
