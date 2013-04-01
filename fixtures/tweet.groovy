import de.juka.Tweet
import groovy.json.JsonSlurper


fixture {

    tweet01(Tweet, author: tobias, created: (new Date()).minus(20), location: 'Rüppurr', message: 'Der Grails-Vortrag findet am 10.04. statt.')

    // tweets from grails
    tweet02(Tweet, author: grails, created: (new GregorianCalendar(2013,2,25)).time, message: 'Grails 2.2.1 is released')
    tweet03(Tweet, author: grails, created: (new GregorianCalendar(2012,12,13)).time, message: 'Grails 2.2.0 RC4  is released')
    tweet04(Tweet, author: grails, created: (new GregorianCalendar(2012,9,12)).time, message: 'Grails 2.1.1 is released')
    tweet05(Tweet, author: grails, created: (new GregorianCalendar(2012,7,5)).time, message: 'Grails 2.1 is released')
    tweet06(Tweet, author: grails, created: (new GregorianCalendar(2011,12,15)).time, message: 'Grails 2.0 final is released')
    tweet07(Tweet, author: grails, created: (new GregorianCalendar(2011,5,24)).time, message: 'Grails 1.3.9 is released')

    // tweets from GrailsPlugins
    def reader = new BufferedReader(new FileReader(System.properties['base.dir']+"/fixtures/grailsplugins.json"))
    new JsonSlurper().parse(reader).eachWithIndex { t, i ->
        "tweetGrailsPlugins${i}"(Tweet, author: grailsplugins, created: new Date().parse("EEE MMM d HH:mm:ss Z yyyy", t.created_at), message: t.text)
    }

    // tweets from DailyGrailsTips
    reader = new BufferedReader(new FileReader(System.properties['base.dir']+"/fixtures/DailyGrailsTip.json"))
    new JsonSlurper().parse(reader).eachWithIndex { t, i ->
        "tweetDailyGrailsTip${i}"(Tweet, author: dailyGrailsTip, created: new Date().parse("EEE MMM d HH:mm:ss Z yyyy", t.created_at), message: t.text)
    }

}