

# Proyecto Springboot para api de Manejo de Finanzas Personales

Esta api permitirá realizar las operaciones crud para un servicio de administración de finanzas personasles como:

- Crear Movimiento
- Consultar todos los movimientos
- Consultar un movimiento por id
- Consulta de movimientos por filtro de nombre
- Modificar un movimiento
- Eliminar un movimiento


## Librerias utilizadas

 ### 'org.springframework.boot:spring-boot-starter-web'
 
 Starter que permite la configuración y manejo  de dependencias para un servicio web permitiendo la configuración e inicio rápido de un servicio.
 
 ### 'org.springframework.boot:spring-boot-starter-data-jpa'
 
 Starter que permite la configuración y manejo  de dependencias para base de datos a través de JPA
 
 ### 'org.springframework.boot:spring-boot-starter-validation'
 
 Starter para usar validaciones de beans con hibernate
 
 
 ### 'org.springframework.boot:spring-boot-starter-security'
 
 
 ### 'io.springfox:springfox-boot-starter
 
 Starter para generar especificaciones Json

  
 ###  'org.springframework.boot:spring-boot-starter-actuator'
 
 Starter para iniciar actuator para generar metricas e informacion del servicio
 
 ### 'io.micrometer:micrometer-registry-prometheus'
 
 Librería para generar eventos para monitoreo
 
 
 ### 'mysql:mysql-connector-java'
 
 Libreria que contiene el driver de conexión a la base de datos mysql
 
 ### 'org.projectlombok:lombok'
 
 Libreria que simplifica el codigo fuente evitando contruir getters and setters simplemente con una anotación.
    
 ### 'org.springframework.boot:spring-boot-devtools'
 
 Libreria que permite reiniciar la aplicacion cada vez que se produce cambio en el código

 ### 'org.springframework.boot:spring-boot-starter-test'
 
 Starter que importa los modulos de springboot test como los assert de Junit y un número de poderosas librerias
 
 ### testImplementation 'com.h2database:h2'
 
 Libreria que inicia una base de datos h2 en memoria. Es usada para las pruebas unitarias

## Clases Principales

### Application
Clase que contiene el arranque del microservicio

### controller/PfmController
Clase que contiene los controladores con las operaciones que expondrá el servicio
- Crear Movimiento
- Consultar todos los movimientos
- Consultar un movimiento por id
- Consulta de movimientos por filtro de nombre
- Modificar un movimiento
- Eliminar un movimiento

### config/SecurityConfiguration
Clase que contiene los métodos que configurar la seguridad del microservicio el cual permite asegurar el servicio por usuario y password con manejo de roles extendiendo las capacidades de la libreria **WebSecurityConfigurerAdapter**

### domain/Movement
Clase que contiene la estructura del objeto movimientos con sus respectivos atributos

## exeption/ExceptionDetails
Clase que contiene la estructura para las excepciones generadas

## ResourceNotFoundException
Clase para la excepcion que se genera cuando no se encuentra movimientos

## ResourceNotFoundExceptionDetail
Clase que contiene la estructura para las excepciones generadas para cuando no se encuentra movimientos

## ValidateExceptionDetail
Clase que contiene la estructura para la validación de las excepciones

# Monitoreo de la aplicacion
https://prometheus.io/