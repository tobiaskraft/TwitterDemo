package de.juka

class TweetService {

    def getMyMyStartPage(user, paginateParams) {
        def followtweets = Tweet.createCriteria().list() {
            gt('created', (new Date()).minus(10))
            author {
                followers {
                    eq('account', user)
                }
            }
        }
        return followtweets
    }

    def getMyTweets(user, paginateParams) {
        def tweets = Tweet.createCriteria().list(paginateParams) {
            gt('created', (new Date()).minus(365))
            author {
                eq('account', user)
            }
        }
        return tweets
    }

}
