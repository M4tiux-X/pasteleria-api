# Resumen de Endpoints - Pastelería API

## 🔐 Endpoints Públicos (No requieren autenticación)

### Autenticación
- **POST** `/api/usuario/register` - Registrar nuevo usuario
- **POST** `/api/usuario/login` - Iniciar sesión
- **POST** `/api/usuario/refresh` - Refrescar token de acceso

---

## 🔒 Endpoints Protegidos (Requieren JWT Token)

### 👤 Usuarios (`/api/usuarioNormal`)
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/usuarioNormal` | Listar todos los usuarios |
| GET | `/api/usuarioNormal/{id}` | Obtener usuario específico |
| POST | `/api/usuarioNormal` | Crear nuevo usuario |
| POST | `/api/usuarioNormal/login` | Login alternativo |
| PUT | `/api/usuarioNormal/{id}` | Actualizar usuario |
| DELETE | `/api/usuarioNormal/{id}` | Eliminar usuario |

### 🏷️ Tipos de Usuario (`/api/tipo_usu`)
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/tipo_usu` | Listar tipos de usuario |
| GET | `/api/tipo_usu/{id}` | Obtener tipo específico |
| POST | `/api/tipo_usu` | Crear tipo de usuario |
| PUT | `/api/tipo_usu/{id}` | Actualizar tipo |
| DELETE | `/api/tipo_usu/{id}` | Eliminar tipo |

### 🍰 Productos (`/api/productos`)
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/productos` | Listar todos los productos |
| GET | `/api/productos/{id}` | Obtener producto específico |
| POST | `/api/productos` | Crear nuevo producto |
| PUT | `/api/productos/{id}` | Actualizar producto |
| DELETE | `/api/productos/{id}` | Eliminar producto |

### 📁 Categorías (`/api/categoria`)
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/categoria` | Listar categorías |
| GET | `/api/categoria/{id}` | Obtener categoría específica |
| POST | `/api/categoria` | Crear categoría |
| PUT | `/api/categoria/{id}` | Actualizar categoría |
| DELETE | `/api/categoria/{id}` | Eliminar categoría |

### 🛒 Carrito (`/api/carrito`)
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/carrito` | Listar carritos |
| GET | `/api/carrito/{id}` | Obtener carrito específico |
| POST | `/api/carrito` | Crear carrito |
| PUT | `/api/carrito/{id}` | Actualizar carrito |
| DELETE | `/api/carrito/{id}` | Eliminar carrito |

### 📝 Carrito Detalle (`/api/carrito_detalle`)
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/carrito_detalle` | Listar detalles de carritos |
| GET | `/api/carrito_detalle/{id}` | Obtener detalle específico |
| POST | `/api/carrito_detalle` | Crear detalle |
| PUT | `/api/carrito_detalle/{id}` | Actualizar detalle |
| DELETE | `/api/carrito_detalle/{id}` | Eliminar detalle |

### 📦 Pedidos (`/api/pedido`)
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/pedido` | Listar pedidos |
| GET | `/api/pedido/{id}` | Obtener pedido específico |
| POST | `/api/pedido` | Crear pedido |
| PUT | `/api/pedido/{id}` | Actualizar pedido |
| DELETE | `/api/pedido/{id}` | Eliminar pedido |

### 🧾 Boletas (`/api/boleta`)
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/boleta` | Listar boletas |
| GET | `/api/boleta/{id}` | Obtener boleta específica |
| POST | `/api/boleta` | Crear boleta |
| PUT | `/api/boleta/{id}` | Actualizar boleta |
| DELETE | `/api/boleta/{id}` | Eliminar boleta |

### 💰 Descuentos (`/api/descuento`)
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/descuento` | Listar descuentos |
| GET | `/api/descuento/{id}` | Obtener descuento específico |
| POST | `/api/descuento` | Crear descuento |
| PUT | `/api/descuento/{id}` | Actualizar descuento |
| DELETE | `/api/descuento/{id}` | Eliminar descuento |

### 👨‍💼 Administración (`/api/admin`)
| Método | Endpoint | Descripción | Rol Requerido |
|--------|----------|-------------|---------------|
| GET | `/api/admin/only` | Endpoint exclusivo admin | ROLE_ADMIN |
| GET | `/api/admin/user-or-admin` | Endpoint admin o usuario | ROLE_ADMIN o ROLE_USER |

---

## 📋 Notas Importantes

### Headers Requeridos para Endpoints Protegidos
```
Authorization: Bearer <tu_token_jwt>
Content-Type: application/json
```

### Roles de Usuario
- **ROLE_ADMIN** (id_tipo_usu = 1): Administradores
- **ROLE_USER** (id_tipo_usu = 2): Usuarios normales

### Formato de Respuesta
Todas las respuestas son en formato JSON.

### Códigos de Estado HTTP
- `200 OK` - Operación exitosa
- `201 Created` - Recurso creado exitosamente
- `400 Bad Request` - Error en la solicitud
- `401 Unauthorized` - No autorizado (token inválido o expirado)
- `403 Forbidden` - Prohibido (sin permisos suficientes)
- `404 Not Found` - Recurso no encontrado
- `500 Internal Server Error` - Error del servidor

---

## 🌐 URL Base
```
http://localhost:8080
```

## 📌 CORS
La API está configurada para aceptar peticiones desde cualquier origen (`*`).
