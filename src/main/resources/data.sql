INSERT INTO categoria (id, nombre, prioridad) VALUES (1, 'Bebidas', 1);
INSERT INTO categoria (id, nombre, prioridad) VALUES (2, 'Postres', 2);

INSERT INTO empleados (nombre, apellido, rol, sueldo, turno)
VALUES ('Gianella', 'Torres', 'Barista', 1300.0, 'Tarde');

INSERT INTO clientes (nombre, apellido, dni, telefono, email)
VALUES ('Juan', 'Hoyos', '71234567', '987654321', 'juan@gmail.com');

INSERT INTO pedidos (fecha, cliente_id, empleado_id, total)
VALUES (CURRENT_TIMESTAMP, 1, 1, 23.50);

INSERT INTO detalles_pedido (pedido_id, producto_id, cantidad, precio_venta_momento)
VALUES (1, 1, 1, 8.50);