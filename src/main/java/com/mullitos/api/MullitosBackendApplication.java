package com.mullitos.api;

import com.mullitos.api.entity.*;
import com.mullitos.api.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDateTime;
import java.util.ArrayList; // Importante para inicializar listas si es necesario

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

		// 1. Limpiando datos (En orden inverso)
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

		// 4. Agregando Actores
		Cliente clienteKevin = clienteRepository.save(
				Cliente.builder()
						.nombre("Kevin")
						.apellido("Leon")
						.dni("12345678")
						.telefono("789456123")
						.email("kevinleo@gmail.com")
						.build()
		);

		Empleado meseroRudy = empleadoRepository.save(
				Empleado.builder()
						.nombre("Rudy")
						.apellido("Rudiar")
						.rol("Mesero")
						.sueldo(450.00)
						.turno("Tarde")
						.build()
		);

		// 5. Creando un Pedido
				Pedido pedido1 = pedidoRepository.save(
				Pedido.builder()
						.fecha(LocalDateTime.now()) // Cambiado de fechaHora a fecha
						.cliente(clienteKevin)
						.empleado(meseroRudy)
						.total(23.50)
						.detalles(new ArrayList<>()) // Inicializamos la lista para evitar NullPointerException
						.build()
		);

		// 6. Agregando los Detalles
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

		System.out.println("Datos cargados correctamente.");
	}
}
