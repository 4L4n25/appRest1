package apprest

class Producto {
    String codigo
    String descripcion
    Categoria categoria
    static constraints = {
        codigo [20]
        descripcion[60]
    }
}
