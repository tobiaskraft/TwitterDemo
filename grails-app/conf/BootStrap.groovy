class BootStrap {

    def fixtureLoader

    def init = { servletContext ->
        fixtureLoader.load("user", "follower", "tweet")
    }

    def destroy = {
    }
}
