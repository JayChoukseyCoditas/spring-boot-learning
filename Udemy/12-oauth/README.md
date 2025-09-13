# Oauth2

**Steps to Enable Oauth2 login**
- Add `spring-boot-starter-oauth2-client` dependency
- Add `oauth2Login(Customizer.withDefaults())` in SecurityConfig file
- Add client-id and client-secret in application.properties file

**Steps to Create client-id and client-secret for Google**
- Go to Google Cloud Console(https://console.cloud.google.com)
- Under Quick access choose APIs and services
- Go to Credentials
- Click on Create Credentials
- Choose OAuth client ID
- Fill the Application type from drop down menu
- Give the application name
- Under Authorised redirect URIs 
  - Fill URIs 1 : http://localhost:8080/login/oauth2/code/google
- Then click on Create button
- Then you will get the client ID and client secret 

**Steps to Create Client-id and Client-secret for GitHub**
- Go to GitHub Account (https://github.com)
- Go to Settings
- Choose Developer Settings from the sidebar at the bottom 
- Choose OAuth Apps option
- Click on New OAuth App
- Fill the Application name
- Fill the Homepage URL : http://localhost:8080
- Fill the Authorization callback URL : http://localhost:8080/login/oauth2/code/github
- Click on Register application button
- Then you will get the client ID and secret(need to generate it)