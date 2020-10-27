package apprest

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PrecioServiceSpec extends Specification {

    PrecioService precioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Precio(...).save(flush: true, failOnError: true)
        //new Precio(...).save(flush: true, failOnError: true)
        //Precio precio = new Precio(...).save(flush: true, failOnError: true)
        //new Precio(...).save(flush: true, failOnError: true)
        //new Precio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //precio.id
    }

    void "test get"() {
        setupData()

        expect:
        precioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Precio> precioList = precioService.list(max: 2, offset: 2)

        then:
        precioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        precioService.count() == 5
    }

    void "test delete"() {
        Long precioId = setupData()

        expect:
        precioService.count() == 5

        when:
        precioService.delete(precioId)
        sessionFactory.currentSession.flush()

        then:
        precioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Precio precio = new Precio()
        precioService.save(precio)

        then:
        precio.id != null
    }
}
