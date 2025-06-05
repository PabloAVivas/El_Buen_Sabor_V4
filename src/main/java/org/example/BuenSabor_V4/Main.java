package org.example.BuenSabor_V4;

import org.example.BuenSabor_V4.DAO.*;
import org.example.BuenSabor_V4.Entities.*;
import org.example.BuenSabor_V4.Entities.Enums.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Conexion con Base de datos
        String url = "jdbc:mysql://localhost:3306/javabuensa";
        String user = "root";
        String password = "";
        try (Connection conexion = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ ¡Conexión exitosa!");
        // Instancias

        // Empresa
        Empresa empresa = Empresa.builder()
                .nombre("Empresa 1")
                .razonSocial("SRL")
                .cuil(1234566)
                .build();

        // Sucursal
        Sucursal sucursal1 = Sucursal.builder()
                .nombre("Sucursal 1")
                .horarioApertura(LocalTime.of(8, 30))
                .horarioCierre(LocalTime.of(20, 0))
                .build();
        Sucursal sucursal2 = Sucursal.builder()
                .nombre("Sucursal 2")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(21, 0))
                .build();

        // Domicilio
        Domicilio domicilio1 = Domicilio.builder()
                .calle("Calle 1")
                .numero(123)
                .cp(4567)
                .build();
        Domicilio domicilio2 = Domicilio.builder()
                .calle("Calle 2")
                .numero(456)
                .cp(8910)
                .build();

        // Localidad
        Localidad localidad1 = Localidad.builder()
                .nombre("Localidad 1")
                .build();
        Localidad localidad2 = Localidad.builder()
                .nombre("Localidad 2")
                .build();

        // Provincia
        Provincia provincia1 = Provincia.builder()
                .nombre("Provincia 1")
                .build();
        Provincia provincia2 = Provincia.builder()
                .nombre("Provincia 2")
                .build();

        // País
        Pais pais = Pais.builder()
                .nombre("Argentina")
                .build();

        // Categorías
        Categoria categoriaPadre = Categoria.builder()
                .denominacion("Categoría Padre")
                .build();
        Categoria subCategoria1 = Categoria.builder()
                .denominacion("Subcategoría 1")
                .build();
        Categoria subCategoria2 = Categoria.builder()
                .denominacion("Subcategoría 2")
                .build();

        // Artículos
        ArticuloInsumo insumo1 = ArticuloInsumo.builder()
                .denominacion("Insumo 1")
                .precioVenta(100.0)
                .precioCompra(50.0)
                .stockActual(20)
                .stockMaximo(100)
                .esParaElaborar(true)
                .build();
        ArticuloManufacturado manufacturado1 = ArticuloManufacturado.builder()
                .denominacion("Manufacturado 1")
                .precioVenta(200.0)
                .descripcion("Descripción 1")
                .tiempoEstimadoMinutos(30)
                .preparacion("Preparación 1")
                .build();

        //ArticuloManufacturadoDetalle
        ArticuloManufacturadoDetalle detalle1 = ArticuloManufacturadoDetalle.builder()
                .cantidad(2)
                .build();

        ArticuloManufacturadoDetalle detalle2 = ArticuloManufacturadoDetalle.builder()
                .cantidad(3)
                .build();


        // Unidad de Medida
        UnidadMedida unidadMedida = UnidadMedida.builder()
                .denominacion("Kilogramos")
                .build();

        // Imagen
        Imagen imagen1 = Imagen.builder()
                .denominacion("Imagen 1")
                .build();
        Imagen imagen2 = Imagen.builder()
                .denominacion("Imagen 2")
                .build();

        // Cliente
        Cliente cliente = Cliente.builder()
                .nombre("Juan")
                .apellido("Pérez")
                .telefono("123456789")
                .email("juan.perez@example.com")
                .fechaNacimiento(LocalDate.of(1990, 1, 1))
                .build();

        // Usuario
        Usuario usuario = Usuario.builder()
                .auth0Id("auth0Id123")
                .userName("juanperez")
                .build();

        // Pedido
        Pedido pedido = Pedido.builder()
                .horaEstimadaFinalizacion(LocalTime.of(12, 0))
                .costo(500.0)
                .costoTotal(550.0)
                .estado(Estado.PENDIENTE)
                .tipoEnvio(TipoEnvio.DELIVERY)
                .formaPago(FormaPago.EFECTIVO)
                .FechaPedido(LocalDate.now())
                .build();

        // Factura
        Factura factura = Factura.builder()
                .fechaFacturacion(LocalDate.now())
                .mpPaymentId(12345)
                .mpMerchantOrderId(67890)
                .mpPreferenceId("pref123")
                .mpPaymentType("MercadoPago")
                .formaPago(FormaPago.MERCADOPAGO)
                .totalVenta(550.0)
                .build();

        // Detalle de Pedido
        DetallePedido detallePedido = DetallePedido.builder()
                .cantidad(2)
                .subTotal(200.0)
                .build();

        // Promoción
        Promocion promocion = Promocion.builder()
                .denominacion("Promoción 1")
                .FechaDesde(LocalDate.of(2023, 1, 1))
                .FechaHasta(LocalDate.of(2023, 12, 31))
                .HoraDesde(LocalDate.of(2023, 1, 1))
                .HoraHasta(LocalDate.of(2023, 12, 31))
                .descripcionDescuento("Descuento 10%")
                .precioPromocional(180.0)
                .tipoPromocion(TipoPromocion.HAPPYHOUR)
                .build();



    // Relaciones

        // Empresa a Sucursal
        empresa.agregarSucursal(sucursal1);
        empresa.agregarSucursal(sucursal2);
        sucursal1.setEmpresa(empresa);
        sucursal2.setEmpresa(empresa);

        // Sucursal a Domicilio
        sucursal1.setDomicilio(domicilio1);
        sucursal2.setDomicilio(domicilio2);

        // Domicilio a Localidad
        domicilio1.setLocalidad(localidad1);
        domicilio2.setLocalidad(localidad2);

        // Localidad a Provincia
        localidad1.setProvincia(provincia1);
        localidad2.setProvincia(provincia2);

        // Provincia a Pais
        provincia1.setPais(pais);
        provincia2.setPais(pais);

        // Categoria a Subcategorias
        categoriaPadre.agregarSubcategoria(subCategoria1);
        categoriaPadre.agregarSubcategoria(subCategoria2);
        subCategoria1.setCategoriaPadre(categoriaPadre);
        subCategoria2.setCategoriaPadre(categoriaPadre);

        // Sucursal a Categoria
        sucursal1.agregarCategoria(categoriaPadre);

        // ArticuloInsumo a UnidadMedida
        insumo1.setUnidadMedida(unidadMedida);

        // ArticuloManufacturado a Imagen
        manufacturado1.agregarImagen(imagen1);
        manufacturado1.agregarImagen(imagen2);

        // ArticuloManufacturado a ArticuloManufacturadoDetalle
        manufacturado1.agregarArticuloManufacturadoDetalle(detalle1);
        manufacturado1.agregarArticuloManufacturadoDetalle(detalle2);

        // ArticuloManufacturadoDetalle a ArticuloManufacturado
        detalle1.setArticuloInsumo(insumo1);
        detalle2.setArticuloInsumo(insumo1);

        // ArticuloManufacturadoDetalle a ArticuloInsumo
        detalle1.setArticuloInsumo(insumo1);
        detalle2.setArticuloInsumo(insumo1);

        // Relación entre Categoria y Articulo
        categoriaPadre.agregarArticulo(insumo1);
        categoriaPadre.agregarArticulo(manufacturado1);
        insumo1.setCategoria(categoriaPadre);
        manufacturado1.setCategoria(categoriaPadre);

        // Cliente a Usuario
        cliente.setUsuario(usuario);

        // Pedido a Cliente
        pedido.setCliente(cliente);

        // Pedido a DetallePedido
        pedido.agregarDetallePedido(detallePedido);
        detallePedido.setPedido(pedido);

        // Factura a Pedido
        factura.setPedido(pedido);
        pedido.setFactura(factura);

        // Sucursal a Promoción
        sucursal1.agregarPromocion(promocion);

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido al Buen Sabor");

        System.out.println("Existe la empresa:\n");

        System.out.println(empresa);

        System.out.println("Quieres mostrar mas datos de esta empresa? 1=si / cualquier tecla para no");
        String primeraP = sc.nextLine();

        if (primeraP.equals("1")) {
            System.out.println(sucursal1);
            System.out.println(domicilio1);
            System.out.println(localidad1);
            System.out.println(provincia1);
            System.out.println(pais);
        }

        System.out.println("Quieres mostrar la categorias e insumos? 1=si / cualquier tecla para no");
        String segundaP = sc.nextLine();

        if (segundaP.equals("1")) {
            System.out.println(categoriaPadre);
            System.out.println(insumo1);
            System.out.println(manufacturado1);
        }

        System.out.println("Quieres ver las promociones? 1=si / cualquier tecla para no");
        String terceraP = sc.nextLine();

        if (terceraP.equals("1")) {
            System.out.println(promocion);
        }

        System.out.println("Quieres hacer un pedido? 1=si / cualquier tecla para no");
        String cuartaP = sc.nextLine();

        if (cuartaP.equals("1")) {
            System.out.println(cliente);
            System.out.println(pedido);
            System.out.println(factura);
        }

        //querys
            EmpresaDAO empresaDAO = new EmpresaDAO();
            empresaDAO.save(conexion, empresa);

            SucursalDAO sucursalDAO = new SucursalDAO();
            sucursalDAO.save(conexion, sucursal1);

        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a la base de datos.");
            e.printStackTrace();
        }

    }
}
