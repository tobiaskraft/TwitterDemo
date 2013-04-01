package de.juka

class Tweet {

	String message
	Date created
	String location

    User author

    static constraints = {
		message nullable:false, size: 10..150
		created nullable: false
		location nullable:true
    }
}
