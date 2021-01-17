# brockerTest
Test de Gabriel Loy para empresa de Broker

# como levantar la API:
1- Una vez descargado el proyecto en su ordenador, debera importarlo con Eclipse o IntelliJ
2- Ir a la clase /broker-test/src/main/java/com/gloy/brokertest/BrokerTestApplication.java e inicializar el proyecto.
3- En el mismo RUN se va a correr un archivo data.sql que va a hacer los inserts de los datos, se ingresaran 10 users y 110 loans.
4- La configuracion es estandar, por lo que la aplicacion se deberia levantar en el puerto 8080 y la base de datos en el 3306

# urls
Se han expuesto dos end-points principales como se pedia en la consigna: "users" y "loans"
Usando un cliente, por ej POSTMAN, los puertos serian
GET:
localhost:8080/users
localhost:8080/users/{id}
localhost:8080/users/{id}
localhost:8080/loans?page={pageNum}&size={pageSize}
localhost:8080/loans?page={pageNum}&size={pageSize}&user-id={userId}
POST:
localhost:8080/users
Body:
	{
        "email": "String",
        "firstName": "String",
        "lastName": "String"
    }
localhost:8080/loans
Body:
    {
        "total":double,
        "userId":int
    }
DELETE:
localhost:8080/users/{user-id}
localhost:8080/loans/{loan-id}