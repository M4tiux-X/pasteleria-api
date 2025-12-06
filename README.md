# Pastelería API - Proyecto Unificado

API REST unificada para el sistema de gestión de pastelería. Este proyecto consolida todos los microservicios anteriores en una única aplicación Spring Boot.

## 📋 Descripción

Este proyecto unifica los siguientes servicios que anteriormente estaban separados:
- Usuario Service (autenticación con JWT)
- Producto Service
- Categoría Service
- Carrito Service
- Carrito Detalle Service
- Pedido Service
- Boleta Service
- Descuento Service
- Tipo Usuario Service

## 🚀 Tecnologías Utilizadas

- **Java 21**
- **Spring Boot 3.5.7**
- **Spring Data JPA**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **MySQL 8**
- **Maven**

## 📦 Estructura del Proyecto

```
pasteleria-api/
├── src/main/java/com/pasteleria/api/
│   ├── config/              # Configuraciones (Security, JWT, CORS)
│   ├── controller/          # Controladores REST
│   ├── entidades/           # Entidades JPA
│   ├── repository/          # Repositorios JPA
│   ├── service/             # Servicios de negocio
│   └── PasteleriaApiApplication.java
├── src/main/resources/
│   └── application.properties
└── pom.xml
```

## 🔧 Configuración

### Base de Datos

1. Crear una base de datos MySQL llamada `pasteleria_db`:
```sql
CREATE DATABASE pasteleria_db;
```

2. Actualizar las credenciales en `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pasteleria_db
spring.datasource.username=root
spring.datasource.password=TU_PASSWORD
```

### JWT Secret

**IMPORTANTE:** Cambia el secreto JWT en `application.properties` por uno seguro:
```properties
jwt.secret=TU_SECRET_BASE64_AQUI
```

## 🎯 Endpoints Disponibles

### Autenticación (`/api/usuario`)
- `POST /api/usuario/register` - Registrar nuevo usuario
- `POST /api/usuario/login` - Iniciar sesión
- `POST /api/usuario/refresh` - Refrescar token de acceso

### Usuarios (`/api/usuarioNormal`)
- `GET /api/usuarioNormal` - Listar usuarios
- `GET /api/usuarioNormal/{id}` - Obtener usuario por ID
- `POST /api/usuarioNormal` - Crear usuario
- `PUT /api/usuarioNormal/{id}` - Actualizar usuario
- `DELETE /api/usuarioNormal/{id}` - Eliminar usuario
- `POST /api/usuarioNormal/login` - Login alternativo

### Tipo de Usuario (`/api/tipo_usu`)
- `GET /api/tipo_usu` - Listar tipos de usuario
- `GET /api/tipo_usu/{id}` - Obtener tipo por ID
- `POST /api/tipo_usu` - Crear tipo de usuario
- `PUT /api/tipo_usu/{id}` - Actualizar tipo
- `DELETE /api/tipo_usu/{id}` - Eliminar tipo

### Productos (`/api/productos`)
- `GET /api/productos` - Listar productos
- `GET /api/productos/{id}` - Obtener producto por ID
- `POST /api/productos` - Crear producto
- `PUT /api/productos/{id}` - Actualizar producto
- `DELETE /api/productos/{id}` - Eliminar producto

### Categorías (`/api/categoria`)
- `GET /api/categoria` - Listar categorías
- `GET /api/categoria/{id}` - Obtener categoría por ID
- `POST /api/categoria` - Crear categoría
- `PUT /api/categoria/{id}` - Actualizar categoría
- `DELETE /api/categoria/{id}` - Eliminar categoría

### Carrito (`/api/carrito`)
- `GET /api/carrito` - Listar carritos
- `GET /api/carrito/{id}` - Obtener carrito por ID
- `POST /api/carrito` - Crear carrito
- `PUT /api/carrito/{id}` - Actualizar carrito
- `DELETE /api/carrito/{id}` - Eliminar carrito

### Carrito Detalle (`/api/carrito_detalle`)
- `GET /api/carrito_detalle` - Listar detalles de carrito
- `GET /api/carrito_detalle/{id}` - Obtener detalle por ID
- `POST /api/carrito_detalle` - Crear detalle
- `PUT /api/carrito_detalle/{id}` - Actualizar detalle
- `DELETE /api/carrito_detalle/{id}` - Eliminar detalle

### Pedidos (`/api/pedido`)
- `GET /api/pedido` - Listar pedidos
- `GET /api/pedido/{id}` - Obtener pedido por ID
- `POST /api/pedido` - Crear pedido
- `PUT /api/pedido/{id}` - Actualizar pedido
- `DELETE /api/pedido/{id}` - Eliminar pedido

### Boletas (`/api/boleta`)
- `GET /api/boleta` - Listar boletas
- `GET /api/boleta/{id}` - Obtener boleta por ID
- `POST /api/boleta` - Crear boleta
- `PUT /api/boleta/{id}` - Actualizar boleta
- `DELETE /api/boleta/{id}` - Eliminar boleta

### Descuentos (`/api/descuento`)
- `GET /api/descuento` - Listar descuentos
- `GET /api/descuento/{id}` - Obtener descuento por ID
- `POST /api/descuento` - Crear descuento
- `PUT /api/descuento/{id}` - Actualizar descuento
- `DELETE /api/descuento/{id}` - Eliminar descuento

### Admin (`/api/admin`)
- `GET /api/admin/only` - Endpoint solo para administradores
- `GET /api/admin/user-or-admin` - Endpoint para usuarios y admins

## 🔐 Autenticación y Autorización

La API utiliza JWT para autenticación. Los endpoints públicos son:
- `/api/usuario/login`
- `/api/usuario/register`
- `/api/usuario/refresh`

Para acceder a los demás endpoints, incluye el token JWT en el header:
```
Authorization: Bearer <tu_token_jwt>
```

### Roles
- **ROLE_ADMIN** (id_tipo_usu = 1): Acceso completo
- **ROLE_USER** (id_tipo_usu = 2): Usuario normal

## 🏃 Ejecutar la Aplicación

### Con Maven
```bash
cd pasteleria-api
mvn spring-boot:run
```

### Con Maven Wrapper
```bash
cd pasteleria-api
./mvnw spring-boot:run  # Linux/Mac
mvnw.cmd spring-boot:run  # Windows
```

La aplicación estará disponible en: `http://localhost:8080`

## 📝 Ejemplo de Uso

### Registrar Usuario
```bash
curl -X POST http://localhost:8080/api/usuario/register \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan",
    "apellido": "Pérez",
    "correo": "juan@example.com",
    "pass": "password123"
  }'
```

### Login
```bash
curl -X POST http://localhost:8080/api/usuario/login \
  -H "Content-Type: application/json" \
  -d '{
    "correo": "juan@example.com",
    "pass": "password123"
  }'
```

### Obtener Productos (requiere autenticación)
```bash
curl -X GET http://localhost:8080/api/productos \
  -H "Authorization: Bearer <tu_token>"
```

## 🔄 Migración desde Microservicios

Este proyecto consolida 9 microservicios anteriores en una única aplicación. Los datos de cada servicio ahora se almacenan en una sola base de datos con las siguientes tablas:

- `usuarios`
- `refresh_tokens`
- `tipo_usuario`
- `producto`
- `categoria`
- `carrito`
- `carrito_detalle`
- `pedido`
- `boleta`
- `descuentos`

## 📄 Licencia

Este proyecto es parte de un sistema de gestión de pastelería.

## 👥 Contribuidores

Proyecto desarrollado como parte de la arquitectura de microservicios de Pastelería.
