package de.juka

class Follower {

    User follow

    static belongsTo = [user:User]

    static mappedBy = [followers: "follow", following: "user"]

    Date since

    static constraints = {
        since nullable: false
    }

}
