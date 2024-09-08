package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main{

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Factura factura1 = new Factura();

            factura1.setNumero(91);
            factura1.setFecha("08/09/2024");

            Cliente cliente = new Cliente("Mateo", "Pineda", 44480611);
            Domicilio domicilio = new Domicilio("Avenida Godoy Cruz", 277);
            cliente.setDomicilio(domicilio);
            factura1.setCliente(cliente);

            Categoria perecederos = new Categoria("Perecederos");
            Categoria lacteos = new Categoria("Lácteos");
            Categoria limpieza = new Categoria("Limpieza");

            Articulo art1 = new Articulo(200, "Yogurt Ser Sabor Frutilla", 900);
            Articulo art2 = new Articulo(300, "Detergente Magistral", 1700);

            art1.getCategorias().add(perecederos);
            art1.getCategorias().add(lacteos);
            art2.getCategorias().add(limpieza);


            DetalleFactura det1 = new DetalleFactura();

                det1.setArticulo(art1);
                det1.setCantidad(2);
                det1.setSubtotal(1800);

                factura1.getDetalles().add(det1);

            DetalleFactura det2 = new DetalleFactura();

                det2.setArticulo(art2);
                det2.setCantidad(1);
                det2.setSubtotal(1700);

                factura1.getDetalles().add(det2);

                factura1.setTotal(3500);

            em.persist(factura1);
            em.persist(cliente);

            em.flush();

            em.getTransaction().commit();
        }
        catch (Exception e){

            em.getTransaction().rollback();
        }

        em.close();
        emf.close();
    }

}
