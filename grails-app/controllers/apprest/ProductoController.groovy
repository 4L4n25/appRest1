package apprest

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProductoController {

    ProductoService productoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond productoService.list(params), model:[productoCount: productoService.count()]
    }

    def show(Long id) {
        respond productoService.get(id)
    }

    def save(Producto producto) {
        if (producto == null) {
            render status: NOT_FOUND
            return
        }

        try {
            productoService.save(producto)
        } catch (ValidationException ignored) {
            respond producto.errors, view:'create'
            return
        }

        respond producto, [status: CREATED, view:"show"]
    }

    def update(Producto producto) {
        if (producto == null) {
            render status: NOT_FOUND
            return
        }

        try {
            productoService.save(producto)
        } catch (ValidationException ignored) {
            respond producto.errors, view:'edit'
            return
        }

        respond producto, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        productoService.delete(id)

        render status: NO_CONTENT
    }
}
