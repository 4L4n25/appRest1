package apprest

import grails.gorm.services.Service

@Service(Precio)
interface PrecioService {

    Precio get(Serializable id)

    List<Precio> list(Map args)

    Long count()

    void delete(Serializable id)

    Precio save(Precio precio)

}