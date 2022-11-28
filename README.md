### Pre-requisites:
- You should have MySQL Database installed on your machine.
- Create a New Schema with the name <user_registration>.
  or use that script: 
```
CREATE SCHEMA 'user_registration'
```
- Run the following script to insert the default users, you can rather
add yours:
```
  INSERT INTO `user_registration`.`user` (`id`, `email`, `enabled`, `first_name`, `last_name`, `password`, `role`) VALUES ('1', 'ahmed.mazen87@yahoo.com', b'1', 'Ahmed', 'Mazen', '$2a$12$A18M0vlDeQ8/7H208KfS8eY9lroFKOLA/uFtIFFSB5RnJ4leqLXNq', 'USER');
```
- Add the following entry in your OS host file:
127.0.0.1       auth-server
in order to have the authorization server accessible through
the url we have defined in the config class http://auth-server:9000
---------------------------------------------------------------------------------

### The application is composed of three modules:

#### 1- authorization server.
#### 2- resource server.
#### 3- gorest api client.

**Run steps:**
- **First** run the authorization server and the resource server
- **Then** run the client
- **For testing the authentication, the basic authentication and autherization** start with the following
hello message try the following url: http://127.0.0.1:8080/api/hello 
- you will be redirected to sign in form, sign-in using the default user: ahmed.mazen87@yahoo.com/123, then navigate again the above-mentioned
url, you will get this message:Hello ahmed.mazen87@yahoo.com, Welcome to lendo gorest api integration!!
  
- **For testing resources of gorest apis:** you will find the gorest api accessible from the GorestAPIClientController
- to get all gorest users : http://127.0.0.1:8080/api/users
- to get all gorest posts : http://127.0.0.1:8080/api/posts
- to get all gorest comments : http://127.0.0.1:8080/api/comments
- to get the posts of specific userId (eg. 19) : http://127.0.0.1:8080/api/posts/19
- to get the comments of specific post (eg. 19) : http://127.0.0.1:8080/api/comments/19



