# AREP-LAB02

Para la tarea usted debe construir una aplicación con la arquitectura propuesta y desplegarla en AWS usando EC2 y Docker.

## Arquitectura

<img src="https://github.com/Rincon10/AREP-LAB02/blob/master/resources/images/Arquitectura.jpg" alt="arquitectura" />


1. El servicio MongoDB es una instancia de MongoDB corriendo en un container de docker en una máquina virtual de EC2
2. LogService es un servicio REST que recibe una cadena, la almacena en la base de datos y responde en un objeto JSON con las 10 ultimas cadenas almacenadas en la base de datos y la fecha en que fueron almacenadas.
3. La aplicación web APP-LB-RoundRobin está compuesta por un cliente web y al menos un servicio REST. El cliente web tiene un campo y un botón y cada vez que el usuario envía un mensaje, este se lo envía al servicio REST y actualiza la pantalla con la información que este le regresa en formato JSON. El servicio REST recibe la cadena e implementa un algoritmo de balanceo de cargas de Round Robin, delegando el procesamiento del mensaje y el retorno de la respuesta a cada una de las tres instancias del servicio LogService.
 
## Entregables:

1. El código del proyecto en un repositorio de GITHUB
2. Un README que explique un resumen del proyecto, l arquitectura, el diseño de clases y que muestre cómo generar las imágenes para desplegarlo. Además que muestre imágenes de cómo quedó desplegado cuando hicieron las pruebas.



## **Prerrequisitos**

-   [Git](https://git-scm.com/downloads) - Sistema de control de versiones
-   [Maven](https://maven.apache.org/download.cgi) - Gestor de dependencias
-   [Java 8](https://www.java.com/download/ie_manual.jsp) - Entorno de desarrollo
-   [Intellij Idea](https://www.jetbrains.com/es-es/idea/download/) (Opcional)
-   [Docker](https://www.docker.com/get-started) -  Motor para contenedores


## **Instrucciones de ejecución local**

0. Desde cmd clonar el repositorio

```git
https://github.com/Rincon10/AREP-LAB02.git
```


1. Ubicarse en la carpeta AREP-LAB02 y borraremos todas las dependencias y modulos que puedan exisitir de los binarios del proyecto.
```maven
mvn clean
```

2. Realizamos la compilación y empaquetamiento del proyecto
```maven
mvn package -U
```

3. Ejecutamos el proyecto
```maven
mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.RunMyServer"
```

<img src="https://github.com/Rincon10/AREP-LAB02/blob/master/resources/images/01-running-console.jpg" alt="running-project" />

## Petición Get 

<img src="https://github.com/Rincon10/AREP-LAB02/blob/master/resources/images/02-get-petition.jpg" alt="get" />

## Petición Post

### Petición desde insomnia
<img src="https://github.com/Rincon10/AREP-LAB02/blob/master/resources/images/02-get-petition.jpg" alt="post" />
<br />
<img src="https://github.com/Rincon10/AREP-LAB02/blob/master/resources/images/02-get-petition.jpg" alt="post-2" />

### Verificando inserción

<img src="https://github.com/Rincon10/AREP-LAB02/blob/master/resources/images/02-get-petition.jpg" alt="get-2" />

### Revisando inserción desde MongoDb

<img src="https://github.com/Rincon10/AREP-LAB02/blob/master/resources/images/02-get-petition.jpg" alt="MongoDb" />

4. Generando la documentación del proyecto
```mvn
mvn javadoc:javadoc
```

<img src="https://github.com/Rincon10/AREP-LAB02/blob/master/resources/images/05-javadoc.jpg" alt="javadoc" />

La documentación se generara en la ruta
```
target/site/apidocs/index.html
```

<img src="" alt="documentacion" />

<br />


## **Ejecutando pruebas**
Para la ejecución de pruebas

```mvn
mvn test
```


## Proceso de creación de la imagen

## Publicando imagenes en DockerHub

## 

 

## Proceso de creacion de los contenedores

