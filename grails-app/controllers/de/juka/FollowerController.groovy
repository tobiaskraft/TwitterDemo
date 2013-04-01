package de.juka

import org.springframework.dao.DataIntegrityViolationException

class FollowerController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [followerInstanceList: Follower.list(params), followerInstanceTotal: Follower.count()]
    }

    def create() {
        [followerInstance: new Follower(params)]
    }

    def save() {
        def followerInstance = new Follower(params)
        if (!followerInstance.save(flush: true)) {
            render(view: "create", model: [followerInstance: followerInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'follower.label', default: 'Follower'), followerInstance.id])
        redirect(action: "show", id: followerInstance.id)
    }

    def show(Long id) {
        def followerInstance = Follower.get(id)
        if (!followerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'follower.label', default: 'Follower'), id])
            redirect(action: "list")
            return
        }

        [followerInstance: followerInstance]
    }

    def edit(Long id) {
        def followerInstance = Follower.get(id)
        if (!followerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'follower.label', default: 'Follower'), id])
            redirect(action: "list")
            return
        }

        [followerInstance: followerInstance]
    }

    def update(Long id, Long version) {
        def followerInstance = Follower.get(id)
        if (!followerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'follower.label', default: 'Follower'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (followerInstance.version > version) {
                followerInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'follower.label', default: 'Follower')] as Object[],
                          "Another user has updated this Follower while you were editing")
                render(view: "edit", model: [followerInstance: followerInstance])
                return
            }
        }

        followerInstance.properties = params

        if (!followerInstance.save(flush: true)) {
            render(view: "edit", model: [followerInstance: followerInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'follower.label', default: 'Follower'), followerInstance.id])
        redirect(action: "show", id: followerInstance.id)
    }

    def delete(Long id) {
        def followerInstance = Follower.get(id)
        if (!followerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'follower.label', default: 'Follower'), id])
            redirect(action: "list")
            return
        }

        try {
            followerInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'follower.label', default: 'Follower'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'follower.label', default: 'Follower'), id])
            redirect(action: "show", id: id)
        }
    }
}
