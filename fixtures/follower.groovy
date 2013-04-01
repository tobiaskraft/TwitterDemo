import de.juka.Follower

fixture {
    followerGrails1(Follower, follow: grails, user: darius, since: (new Date()).minus(120))
    followerGrails2(Follower, follow: grails, user: tobias, since: (new Date()).minus(100))
    followerGrailsPlugin1(Follower, follow: grailsplugins, user: darius, since: (new Date()).minus(80))
    followerGrailsPlugin2(Follower, follow: grailsplugins, user: tobias, since: (new Date()).minus(60))
    followerDailyGrailsTip1(Follower, follow: dailyGrailsTip, user: darius, since: (new Date()).minus(40))
    followerDailyGrailsTip2(Follower, follow: dailyGrailsTip, user: tobias, since: (new Date()).minus(20))

}