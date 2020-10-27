package apprest

class Categoria {
    String codigo
    String descripcion
    boolean activo

    static constraints = {
        codigo [10]
        descripcion [40]
    }
}
