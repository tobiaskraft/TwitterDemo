package de.juka

class User {

    String account
    String firstname
    String lastname
    String email

    static hasMany = [tweets: Tweet, followers: Follower, following: Follower]

    static constraints = {
        account(nullable: false, blank: false, unique: true, size: 4..30)
        firstname(nullable: true, blank: false)
        lastname(nullable: true, blank: false)
        email(nullable: false, blank: false, email: true)
    }

}
