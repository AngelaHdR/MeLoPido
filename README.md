# Me Lo Pido
## En busca de una arquitectura limpia
Proyecto de investigación creado por Àngela Hermosilla del Rio. 

### Introducción
En el mundo del desarrollo de software, la evolución tecnológica es imparable. Cada nueva actualización de un framework o tecnología puede significar una mejora… o un verdadero dolor de cabeza para los desarrolladores. Todas las páginas web han sufrido en algún momento las consecuencias de estos cambios, viendo cómo parte de su trabajo se vuelve obsoleto o requiere grandes modificaciones para adaptarse. Sin embargo, optar por una arquitectura limpia no siempre es la solución definitiva, ya que su implementación puede volverse compleja y difícil de comprender rápidamente.

Es por eso que en este proyecto se analizarán las ventajas y desventajas de una arquitectura limpia de Java, aplicándola en un caso real para evaluar su viabilidad. Además se va a aprovechar el proyecto para estudiar patrones de programación como el CQRS (Command Query Responsibility Segregation). En este enfoque, las capas del sistema estarán completamente desacopladas entre sí y serán lo menos dependientes posible de frameworks externos como Spring Boot y JPA. La capa de dominio, donde reside la lógica del proyecto, será completamente independiente, sin dependencias externas ni internas. De este modo, si algún framework cambia o deja de ser compatible, sólo sería necesario modificar las capas periféricas sin que el núcleo del proyecto se vea afectado.


### Objetivo
El objetivo de este proyecto es investigar sobre la arquitectura limpia y su aplicación en el desarrollo de software. Aplicando los desafios y decisiones tomadas durante el proceso a un caso real diseñado por la autora.

### Herramientas utilizadas
Por un lado, se ha utilizado *Spring Boot*, un framework de desarrollo para aplicaciones Java que simplifica la creación de APIs RESTful. En este proyecto, su uso se ha restringido a la **capa de API**, concretamente en la configuración de los endpoints necesarios para permitir la comunicación entre el frontend y el backend. Sin embargo, no se ha usado ninguna anotación extra fuera del controlador, la creación de las capas se ha realizado manualmente en un archivo que permite gestionar la inversión de control (IoC) para asegurar que todo se configura correctamente.

Por otro lado, se ha incorporado JPA (Java Persistence API) a través de la implementación proporcionada por Hibernate, con el objetivo de facilitar la conexión con la base de datos. JPA es una especificación de Java que permite mapear objetos de la aplicación con tablas de una base de datos relacional y automatizar las sentencias SQL. Sin embargo, JPA permite la conexión mediante una implementación completamente personalizable con el uso de Entity Manager. Permite ejecutar sentencias JPQL (Java Persistence Query Language) que aprovechan todas las facilidades de la integración de los modelos en la sentencia SQL y además son completamente personalizables. Todo este acceso se ha mantenido encapsulado dentro de la capa de persistencia, respetando los principios de la arquitectura limpia.

Se ha evitado de manera intencionada el uso de Mapstruck y Lombok ya que, aunque podría facilitar mucho la programación, obliga al núcleo de la aplicación a tener dependencias externas. Con lo cual todos los mapeadores, y métodos básicos de los objetos (getter, setter, constructor…) se han realizado  manualmente.

La gestión de versiones se ha realizado con la técnica de git flow. Las ramas principales de esta técnica son la rama main (donde se encuentra el producto final funcional y ya probado), la rama release (usada para probar y arreglar el código antes de publicarlo en main) y la rama develop (donde se unen las implementaciones de nuevas características y refactorizaciones). Cada nueva feature se desarrolla en una rama propia para evitar que si algo falla afecte a todo el proyecto y una vez acabado se une a la rama de desarrollo (logongas, s. f.).

## Manual de usuario
A continuación se presentan todas los endpoints disponibles que permiten al usuario crear, actualizar, eliminar y buscar la información necesaria para crear su página. Todos los endpoints devuelven información en formato JSON.

## Controlador de cartas

### 🟦 GET `/letters` - Obtén todas las cartas

---
<div style="margin-left: 20px;">

### 🧾 Parámetros

- `page` *(opcional)*: número de página
- `size` *(opcional)*: tamaño de página

---

### 📄 Modelo

```json
[
  {
    "idLetter": "string",
    "description": "string",
    "user": "string",
    "group": "string",
    "link": "/letters/{idLetter}"
  }
]
```
</div>
<br>

### 🟦 GET `/letters/{idLetter}` - Obtén una carta por id

---
<div style="margin-left: 20px;">

### 🧾 Parámetros

- `idLetter` *(obligatorio)*: identificador de la carta

---

### 📄 Modelo

```json
{
  "idLetter": "string",
  "description": "string",
  "creationDate": "2025-05-07T12:00:00Z",
  "sendDate": "2025-05-08T09:00:00Z",
  "expirationDate": "2025-06-07T23:59:59Z",
  "user": "string",
  "group": "string",
  "products": [
    {
      "idProduct": "string",
      "name": "string",
      "detail": "string",
      "url": "https://example.com/image.png",
      "state": "string",
      "asignado": {
        "idUser": "string",
        "username": "string"
      },
      "idChat": "string"
    }
  ]
}
```
</div>
<br>

### 🟥 DELETE `/letters/{idLetter}` - Borra una carta por id

---
<div style="margin-left: 20px;">

### 🧾 Parámetros
- `idLetter` *(obligatorio)*: identificador de la carta

</div>
<br>

### 🟩 POST `/letters` - Crea una carta

---

<div style="margin-left: 20px;">

### 📦 Cuerpo de la solicitud

```json
{
  "idLetter": "string",
  "description": "string",
  "creationDate": "2025-05-07T12:00:00Z",
  "idUser": "string",
  "group": "string",
  "products": [
    {
      "idProduct": "string",
      "name": "string",
      "detail": "string",
      "url": "https://example.com/image.png",
      "state": "string"
    }
  ]
}
```

</div>
<br>

### 🟨 PUT `/letters/{idLetter}` - Modifica una carta por id

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `idLetter` *(obligatorio)*: identificador de la carta

---

### 📦 Cuerpo de la solicitud

```json
[
  {
    "idLetter": "string",
    "description": "string",
    "creationDate": "2025-05-07T12:00:00Z",
    "idUser": "string",
    "group": "string",
    "products": [
      {
        "idProduct": "string",
        "name": "string",
        "detail": "string",
        "url": "https://example.com/image.png",
        "state": "string"
      }
    ]
  }
]
```

</div>
<br>

### 🟨 PUT `/letters/{idLetter}/groups/{idGroup}` - Envía una carta a un grupo

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `idLetter` *(obligatorio)*: identificador de la carta
* `idGroup` *(obligatorio)*: identificador del grupo

---

### 📦 Cuerpo de la solicitud

```json
{
  "expirationDate": "string"
}
```

</div>
<br>

## Controlador de grupos

### 🟦 GET `/groups` - Obtén todos los grupos

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `page` *(opcional)*: número de página
* `size` *(opcional)*: tamaño de página

---

### 📄 Modelo

```json
[
  {
    "idGroup": "string",
    "name": "string",
    "icon": "string",
    "users": ["string", "string", "string"],
    "link": "/groups/{idGroup}"
  }
]
```

</div>
<br>

### 🟦 GET `/groups/{idGroup}` - Obtén un grupo por id

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `idGroup` *(obligatorio)*: identificador del grupo

---

### 📄 Modelo

```json
{
  "idGroup": "string",
  "name": "string",
  "icon": "string",
  "theme": "string",
  "description": "string",
  "users": ["string", "string", "string"],
  "letters": [
    {
      "idLetter": "string",
      "description": "string",
      "user": "string",
      "group": "string",
      "link": "/letters/{idLetter}"
    }
  ]
}
```

</div>
<br>

### 🟥 DELETE `/groups/{idGroup}` - Borra un grupo por id

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `idGroup` *(obligatorio)*: identificador del grupo

</div>
<br>

### 🟩 POST `/groups` - Crea un grupo

---

<div style="margin-left: 20px;">

### 📦 Cuerpo de la solicitud

```json
{
  "idGroup": "string",
  "name": "string",
  "icon": "string",
  "theme": "string",
  "description": "string"
}
```

</div>
<br>

### 🟨 PUT `/groups/{idGroup}` - Modifica un grupo por id

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `idGroup` *(obligatorio)*: identificador del grupo

---

### 📦 Cuerpo de la solicitud

```json
{
  "idGroup": "string",
  "name": "string",
  "icon": "string",
  "theme": "string",
  "description": "string"
}
```

</div>
<br>

### 🟦 GET `/groups/{idGroup}/letters` - Obtén todas las cartas de un grupo por id

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `page` *(opcional)*: número de página
* `size` *(opcional)*: tamaño de página
* `idGroup` *(obligatorio)*: identificador del grupo

---

### 📄 Modelo

```json
[
  {
    "idLetter": "string",
    "description": "string",
    "user": "string",
    "group": "string",
    "link": "/letters/{idLetter}"
  }
]
```

</div>
<br>

## Controlador de usuarios

### 🟦 GET `/users` - Obtén todos los usuarios

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

- `page` *(opcional)*: número de página
- `size` *(opcional)*: tamaño de página
---
### 📄 Modelo

```json
[
  {
    "idUser": "string",
    "nameComplete": "string",
    "link": "/users/{idUser}"
  }
]
```

</div>
<br>

### 🟦 GET `/users/{idUser}` - Obtén un usuario por id

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `idUser` *(obligatorio)*: identificador del usuario

---

### 📄 Modelo

```json
{
  "idUser": "string",
  "nameComplete": "string",
  "email": "string",
  "birthDate": "string",
  "groups": [
    {
      "idGroup": "string",
      "name": "string",
      "icon": "string",
      "users": ["string", "string"],
      "link": "/groups/{idGroup}"
    }
  ],
  "username": "string",
  "password": "string",
  "letters": [
    {
      "idLetter": "string",
      "description": "string",
      "user": "string",
      "group": "string",
      "link": "/letters/{idLetter}"
    }
  ],
  "products": [
    {
      "idProduct": "string",
      "name": "string",
      "detail": "string",
      "url": "string",
      "state": "string",
      "asignado": {
        "idUser": "string",
        "nameComplete": "string",
        "link": "/users/{idUser}"
      },
      "idChat": "string"
    }
  ]
}
```

</div>
<br>

### 🟥 DELETE `/users/{idUser}` - Borra un usuario por id

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `idUser` *(obligatorio)*: identificador del usuario

</div>
<br>

### 🟩 POST `/users` - Crea un usuario

---

<div style="margin-left: 20px;">

### 📦 Cuerpo de la solicitud

```json
{
  "idUser": "string",
  "name": "string",
  "surname1": "string",
  "surname2": "string",
  "email": "string",
  "birthDate": "string",
  "username": "string",
  "password": "string"
}
```

</div>
<br>

### 🟨 PUT `/users/{idUser}` - Modifica un usuario por id

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `idUser` *(obligatorio)*: identificador del usuario

---

### 📦 Cuerpo de la solicitud

```json
{
  "idUser": "string",
  "name": "string",
  "surname1": "string",
  "surname2": "string",
  "email": "string",
  "birthDate": "string",
  "username": "string",
  "password": "string"
}
```

</div>
<br>

### 🟨 PUT `/users/{idUser}/groups/{idGroup}` - Añade al usuario a un grupo

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `idUser` *(obligatorio)*: identificador del usuario
* `idGroup` *(obligatorio)*: identificador del grupo

</div>
<br>

### 🟥 DELETE `/users/{idUser}/groups/{idGroup}` - Borra un usuario de un grupo

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `idUser` *(obligatorio)*: identificador del usuario
* `idGroup` *(obligatorio)*: identificador del grupo

</div>
<br>

### 🟦 GET `/users/{idUser}/groups` - Obtén todos los grupos de un usuario por id

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `page` *(opcional)*: número de página
* `size` *(opcional)*: tamaño de página
* `idUser` *(obligatorio)*: identificador del usuario

---

### 📄 Modelo

```json
[
  {
    "idGroup": "string",
    "name": "string",
    "icon": "string",
    "users": ["string", "string", "string"],
    "link": "/groups/{idGroup}"
  }
]
```

</div>
<br>

### 🟦 GET `/users/{idUser}/letters` - Obtén todas las cartas de un usuario

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `page` *(opcional)*: número de página
* `size` *(opcional)*: tamaño de página
* `idUser` *(obligatorio)*: identificador del usuario

---

### 📄 Modelo

```json
[
  {
    "idLetter": "string",
    "description": "string",
    "user": "string",
    "group": "string",
    "link": "/letters/{idLetter}"
  }
]
```

</div>
<br>

### 🟦 GET `/users/{idUser}/productsAssigned` - Obtén todos los productos asignados a un usuario por id

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `page` *(opcional)*: número de página
* `size` *(opcional)*: tamaño de página

---

### 📄 Modelo

```json
[
  {
    "idProduct": "string",
    "name": "string",
    "detail": "string",
    "url": "string",
    "state": "string",
    "asignado": {
      "idUser": "string",
      "nameComplete": "string",
      "link": "string"
    },
    "idChat": "string"
  }
]
```

</div>
<br>

### 🟦 GET `/users/{idUser}/chats` - Obtén todos los chats de un usuario

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `page` *(opcional)*: número de página
* `size` *(opcional)*: tamaño de página
* `idUser` *(obligatorio)*: identificador del usuario

---

### 📄 Modelo

```json
[
  {
    "idChat": "string",
    "messages": [
      {
        "idMessage": "string",
        "sendDate": "string",
        "content": "string",
        "sender": {
          "idUser": "string",
          "nameComplete": "string",
          "link": "/users/{idUser}"
        }
      }
    ]
  }
]
```

</div>
<br>

## Controlador de chats

### 🟦 GET `/chats` - Obtén todos los chats

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `page` *(opcional)*: número de página
* `size` *(opcional)*: tamaño de página

---

### 📄 Modelo

```json
[
  {
    "idChat": "string",
    "messages": [
      {
        "idMessage": "string",
        "sendDate": "string",
        "content": "string",
        "sender": {
          "idUser": "string",
          "nameComplete": "string",
          "link": "/users/{idUser}"
        }
      }
    ]
  }
]
```

</div>
<br>

### 🟦 GET `/chats/{idChat}` – Obtén un chat por id

---
<div style="margin-left: 20px;">

### 🧾 Parámetros

- `idChat` *(obligatorio)*: identificador del chat

---

### 📄 Modelo

```json
{
  "idChat": "string",
  "messages": [
    {
      "idMessage": "string",
      "sendDate": "string",
      "content": "string",
      "sender": {
        "idUser": "string",
        "nameComplete": "string",
        "link": "/users/{idUser}"
      }
    }
  ]
}
```
</div>
<br>

### 🟨 PUT `/chats/{idChat}/messages` - Enviar un mensaje a un chat

---

<div style="margin-left: 20px;">

### 🧾 Parámetros

* `idChat` *(obligatorio)*: identificador del chat

---

### 📦 Cuerpo de la solicitud

```json
{
  "idMessage": "string",
  "sendDate": "string",
  "content": "string",
  "idUser": "string"
}
```

</div>
<br>
