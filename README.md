# GoogleOAuthDemo
# Steps :
Navigate to: console.developers.google.com
Left tab: Credentials > Create credentials > OAuth Client ID
-	Select ‘Application Type’ as ‘Web application’
-	In ‘Authorised redirect URIs , add the URI http://localhost:8080/login/oauth2/code/google // redirects user to login page
-	Copy the client ID and Client secret key to enter in the application.properties

#https://yatheesanc9.medium.com/spring-boot-with-google-sign-in-8e304dbe936e

# Log into https://start.spring.io/ and add following dependency :
- Spring web
- OAuth2 client
- Spring security


# OR add below in pom.xml

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-oauth2-client</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-test</artifactId>
        <scope>test</scope>
    </dependency>


# application.properties

- spring.security.oauth2.client.registration.google.client-id=${Client_ID}
- spring.security.oauth2.client.registration.google.client-secret=${Client_Secret}
- -   (Note aded as environment variable)



# Add in Security.java as below:

    @Configuration
    public class Security extends WebSecurityConfigurerAdapter { 

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
   
        httpSecurity
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login();
         }
    
    }


