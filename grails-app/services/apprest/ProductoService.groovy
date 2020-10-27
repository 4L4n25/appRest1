package apprest

import grails.gorm.services.Service

@Service(Precio)
interface ProductoService {

    Producto get(Serializable id)

    List<Producto> list(Map args)

    Long count()

    void delete(Serializable id)

    Producto save(Producto producto)

}