Jersey1RESTClient - Develop REST api Client using Jersey 2 api to invoke GET/PUT/POST request + JSON body is sent as String
=====

This example demonstrate how to create REST client using Jersey 1 api and send POST request with **JSON body as String**


**Prerequisite :**

Please download rest jar from 
*https://github.com/rdntech14/RESTWebServiceJar*

This is a REST web service should be executing on local machine and return result in JSON format.

```
java -jar rest.jar
```

**add Jersey dependency in pom.xml**

```
<dependency>
			<groupId>com.sun.jersey</groupId>
			<artifactId>jersey-client</artifactId>
			<version>1.8</version>
</dependency>
```

**GET/PUT/POST examples**

**GET**

url : http://localhost:8080/student/list


**POST**

url : http://localhost:8080/student 

body : 
```
{
	"id": 1111,
	"firstName": "Vernon",
	"lastName": "Harper",
	"email": "1111@gmail.com",
	"programme": "Financial Analysis",
	"courses": [
		"Accounting",
		"Statistics"
	]
}
```

**PUT**

url : http://localhost:8080/student/1 

body : 
```
{
	"id": 1,
	"firstName": "Vernon",
	"lastName": "Harper",
	"email": "1111aaaa@gmail.com",
	"programme": "Financial Analysis",
	"courses": [
		"computer",
		"Statistics"
	]
}
```