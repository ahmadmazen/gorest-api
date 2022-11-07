# Pre-requisites:
- MySQL Database.
- Create a New Scheme with the name <user_registration>.
- add the following entry in your OS host file:
127.0.0.1       auth-server
in order to have the autherization server work with
the url we have defined in the config class "http://auth-server:9000"

# the application is composed of three modules:
### authorization server: 
### resource server.
### gorest api client.

Run steps:
- First run the authorization server and the resource server
 - then run the client
