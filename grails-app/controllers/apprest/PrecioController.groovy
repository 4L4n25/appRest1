package apprest

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PrecioController {

    PrecioService precioService

   static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond precioService.list(params), model:[precioCount: precioService.count()]
    }

    def show(Long id) {
        respond precioService.get(id)
    }

    def save(Precio precio) {
        if (precio == null) {
            render status: NOT_FOUND
            return
        }

        try {
            precioService.save(precio)
        } catch (ValidationException ignored) {
            respond precio.errors, view:'create'
            return
        }

        respond precio, [status: CREATED, view:"show"]
    }

    def update(Precio precio) {
        if (precio == null) {
            render status: NOT_FOUND
            return
        }

        try {
            precioService.save(precio)
        } catch (ValidationException ignored) {
            respond precio.errors, view:'edit'
            return
        }

        respond precio, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        precioService.delete(id)

        render status: NO_CONTENT
    }
}
