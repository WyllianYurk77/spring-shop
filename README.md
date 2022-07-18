# Spring Boot Shop

### **Endpoints**

#### Sign-up

```json
POST /api/authentication/sign-up HTTP/1.1
> Host: localhost:8080
> User-Agent: insomnia/2022.4.2
> Content-Type: application/json

{
    "name": "Test User",
 	"username": "testuser",
 	"password": "test123"
}
```
#### Sign-in

```json
POST /api/authentication/sign-in HTTP/1.1
> Host: localhost:8080
> User-Agent: insomnia/2022.4.2
> Content-Type: application/json

{
 	"username": "testuser",
 	"password": "test123"
}
```