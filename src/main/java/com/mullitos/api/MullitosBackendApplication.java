package com.mullitos.api;

import com.mullitos.api.entity.*;
import com.mullitos.api.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
public class MullitosBackendApplication implements CommandLineRunner {

	private final ICategoriaRepository categoriaRepository;
	private final IClienteRepository clienteRepository;
	private final IDetallePedidoRepository detallePedidoRepository;
	private final IEmpleadoRepository empleadoRepository;
	private final IPedidoRepository pedidoRepository;
	private final IProductoRepository productoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MullitosBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 1. Limpiando datos (En orden inverso a las llaves foráneas)
		detallePedidoRepository.deleteAll();
		pedidoRepository.deleteAll();
		productoRepository.deleteAll();
		categoriaRepository.deleteAll();
		clienteRepository.deleteAll();
		empleadoRepository.deleteAll();

        // 2. Agregando Categorías
		Categoria catBebidas = categoriaRepository.save(
				Categoria.builder().nombre("Bebidas").prioridad(1).build()
		);
		Categoria catPlatos = categoriaRepository.save(
				Categoria.builder().nombre("Postres").prioridad(2).build()
		);

		// 3. Agregando Productos
		Producto cafe = productoRepository.save(
				Producto.builder()
						.nombre("Café Americano")
						.precioBase(8.50)
						.tiempoPrepEstimado(5)
						.categoria(catBebidas)
						.build()
		);
		Producto postre = productoRepository.save(
				Producto.builder()
						.nombre("Torta de chocolate")
						.precioBase(15.00)
						.tiempoPrepEstimado(10)
						.categoria(catPlatos)
						.build()
		);

		// 4. Agregando Actores (Cliente y Empleado)
		Cliente clienteKevin = clienteRepository.save(
				Cliente.builder()
						.nombre("Kevin Leon")
						.horaLlegada(LocalDateTime.now())
						.estadoActual("Esperando Mesa")
						.build()
		);

		Empleado meseroRudy = empleadoRepository.save(
				Empleado.builder()
						.nombre("Rudy")
						.rol("Mesero")
						.turno("Tarde")
						.build()
		);

        // 5. Creando un Pedido (Cabecera)
		Pedido pedido1 = pedidoRepository.save(
				Pedido.builder()
						.fechaHora(LocalDateTime.now())
						.estadoPedido("EN PREPARACION")
						.cliente(clienteKevin)
						.empleado(meseroRudy)
						.total(23.50) // Suma de café + postre
						.build()
		);

        // 6. Agregando los Detalles del Pedido
		detallePedidoRepository.save(
				DetallePedido.builder()
						.pedido(pedido1)
						.producto(cafe)
						.cantidad(1)
						.precioVentaMomento(8.50)
						.build()
		);

		detallePedidoRepository.save(
				DetallePedido.builder()
						.pedido(pedido1)
						.producto(postre)
						.cantidad(1)
						.precioVentaMomento(15.00)
						.build()
		);
	}
}
