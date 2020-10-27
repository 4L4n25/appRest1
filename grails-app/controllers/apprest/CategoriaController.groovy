package apprest

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CategoriaController {

    CategoriaService categoriaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond categoriaService.list(params), model:[categoriaCount: categoriaService.count()]
    }

    def show(Long id) {
        respond categoriaService.get(id)
    }

    def save(Categoria categoria) {
        if (categoria == null) {
            render status: NOT_FOUND
            return
        }

        try {
            categoriaService.save(categoria)
        } catch (ValidationException e) {
            respond categoria.errors, view:'create'
            return
        }

        respond categoria, [status: CREATED, view:"show"]
    }

    def update(Categoria categoria) {
        if (categoria == null) {
            render status: NOT_FOUND
            return
        }

        try {
            categoriaService.save(categoria)
        } catch (ValidationException e) {
            respond categoria.errors, view:'edit'
            return
        }

        respond categoria, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        categoriaService.delete(id)

        render status: NO_CONTENT
    }
}
