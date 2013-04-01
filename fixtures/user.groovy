import de.juka.User

fixture {
    darius(User, account: "darius", firstname: 'Darius', lastname: 'Henkelmann', email: 'darius.henkelmann@unic.de')
    tobias(User, account: "tobias", firstname: 'Tobias', lastname: 'Kraft', email: 'tobias.kraft@exensio.de')
    grails(User, account: "grails", email: 'info@grails.org')
    grailsplugins(User, account: "grailsplugins", email: 'info@grails.org')
    dailyGrailsTip(User, account: "dailyGrailsTip", email: 'info@dailygrailstip.org')

}