Este proyecto se desarrolla utilizando Java y JPA (Java Persistence API) para gestionar la persistencia de datos con una base de datos en memoria H2, utilizando IntelliJ IDEA como entorno de desarrollo. A continuación, se describen las principales características del proyecto y cómo se han mapeado las entidades:
1. Configuración de la Base de Datos

    Base de Datos: H2
    Propósito: Utilizar una base de datos en memoria para pruebas y desarrollo, que se inicializa automáticamente al ejecutar la aplicación.
    URL de Conexión: jdbc:h2:~/test

2. Entidades y Relaciones
2.1 Articulo

  Descripción: Representa un artículo con atributos como cantidad, denominación y precio.
    Relaciones:
      Many-to-Many con Categoria:
      Unidireccional: Articulo tiene una colección de Categoria a la que está asociado.
      One-to-Many con DetalleFactura:
      Unidireccional: Articulo puede estar asociado con múltiples DetalleFactura.

2.2 Categoria

  Descripción: Representa una categoría de artículos.
  Relaciones:
      Many-to-Many con Articulo:
      Unidireccional: Categoria no tiene una referencia a Articulo en este mapeo.

2.3 Cliente

  Descripción: Representa un cliente con nombre, apellido y DNI.
  Relaciones:
      One-to-One con Domicilio:
      Unidireccional: Cliente tiene una referencia a Domicilio.

2.4 Domicilio

  Descripción: Representa la dirección del cliente.
  Relaciones:
      One-to-One con Cliente:
      Unidireccional: Domicilio no tiene una referencia a Cliente.

2.5 Factura

  Descripción: Representa una factura con número, fecha y total.
  Relaciones:
      Many-to-One con Cliente:
      Unidireccional: Factura tiene una referencia al Cliente que realizó la compra.
      One-to-Many con DetalleFactura:
      Unidireccional: Factura tiene una colección de DetalleFactura asociada.

2.6 DetalleFactura

  Descripción: Representa los detalles de los artículos en una factura, incluyendo cantidad y subtotal.
  Relaciones:
      Many-to-One con Articulo:
      Unidireccional: DetalleFactura tiene una referencia al Articulo asociado.

3. Configuración y Persistencia 

    Archivo de Configuración: persistence.xml define la unidad de persistencia y la configuración de conexión a H2.
    Inicialización del Repositorio: Las entidades se mapean utilizando anotaciones JPA, y se realiza la persistencia de datos a través de un EntityManager.
