package de.juka

class TweetTagLib {

    static namespace = 'tweet'


    def formatDate = { attrs, body ->
        def date = attrs.date
        def dateFormat = 'dd.MM.yyyy'
        out << date.format(dateFormat)
    }

    def showAuthor = { attrs, body ->
        User author  = attrs.instance
        if (author.firstname && author.lastname) {
            out << "${author.firstname}  ${author.lastname} (${author.account})"
        }
        else {
            out << author.account
        }
    }

}
