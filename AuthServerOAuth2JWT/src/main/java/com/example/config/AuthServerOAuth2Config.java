package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
//Interview remember this class - AuthorizationServerConfigurerAdapter and this Annotation - @EnableAuthorizationServer
public class AuthServerOAuth2Config extends AuthorizationServerConfigurerAdapter {
	
   private String clientid = "my-client-id";
   private String clientSecret = "my-client-secret";
	
//	private String clientid = "auth-user-test";
//	private String clientSecret = "br(m@@usr47$";
   
   private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
   		"MIIEowIBAAKCAQEA5jpjZuKNzicLNpgyYJ1F7XEJBfAEfacbY5Y5n3oSFhPIk1a9\r\n" + 
   		"1SkBp6XZAhZiGAwqrZpSrwNDipzexzU/S+J0fHYIQPgEY9BffnEIxtS+Mgi1y2fQ\r\n" + 
   		"rVJxAiSOiHMBqrAn5W8GLN5c/e2lRsL+I9ia+xDcqbAPGA0imgsIu0bDM5iwqGyX\r\n" + 
   		"9ZPj92BepV6R89k3KBH7wjL4ksRxP5Uz8OcCwKzmuwp7uK/bAkzi/ZCa+JSEFhT0\r\n" + 
   		"SOZJMsthlswaCPI9i2Mk21RnkFCK2iewtAS9hplMd3OrQzxbi502v4x1hHMIILmC\r\n" + 
   		"p2RYHy3KH8snY/gtdErLHrOH5p0c1N9O/TcGOwIDAQABAoIBAHeRE1a3ilXqSRSN\r\n" + 
   		"bnxmsY5jCgCfanWnd738ouiECSiWFbEPd39g0I80vsMqxL8gcnm+j/p8g3NVjQ2A\r\n" + 
   		"ReMvNLf+xMKZDA6ahT2xjpFUo4Jwq5l7zRB2pGIsgimzMMZovg+V3WsoALuP1Cov\r\n" + 
   		"0rTjJXoGg9NMsEoZaEMAQASi93WvdsSxXNfmen+ChQpowb71QShQ/He0kOk3GJwM\r\n" + 
   		"9nI5v7uDjJlUzIEag5G1DcwqV8FpSEYcX4ONfuVeC4biozCoVJB7Z+O2HTBm9g/h\r\n" + 
   		"NlfCU8wE0GX5jFSAhhh/V/25RwR82EjR+att0fhWXG6ev3AF96fiFzAzRrV9ZnZA\r\n" + 
   		"bRFCe2ECgYEA857qoJebQsid9ZH9265tdiduBBaMwezFtXeQpmLWmxjqs3RnOyat\r\n" + 
   		"ikQVflzzLp3a2EgUsacS17xYZOfDySBzKSkNBeVaHnUZmWfqUETBhYzfQcHEp24J\r\n" + 
   		"3bxQNYX1qwZTE7bIbn0AfUMUeHn/NBmu2laZCErzsJVbU3yYO/G1UmUCgYEA8e1B\r\n" + 
   		"kjWKf2GgeDOtKKjU9osb+Uo5RKeuB5qbQ5SAP8g6AEYdoJ62bxkSHtlqdWHJok1Z\r\n" + 
   		"bB75qfE44njU6fW83dzQ3kDBgcTeBWbfbqC39HIBT9sgNeFQvPt0tt/751ycO7wW\r\n" + 
   		"yaHsvBiJ7Jy3iWW+guDZB60heklQQhTshXLTHB8CgYAhO5BuD8BSP+OsWBn1Gbo8\r\n" + 
   		"3+wWCq1w1sexlXnZ+KmlxqRdjod2fjQ2JEt6TVuvBEGSN2L7SPs9CqhUO3ltukt7\r\n" + 
   		"Veo836iHdxni31YLVRXBDhJ2eeRForEd2k5mvrtgdSBoFAsLZ2nlrHziYmH5zXcY\r\n" + 
   		"ua9ufir376fhn6F0q+g8MQKBgQDbZdjzaY7imnzWxbahiwsnU1zZJVDuTErtJm7s\r\n" + 
   		"SL5OGZ1QJkY0Jfs4obnnNDDxpu8fO5p/DVBJqDN4XzBnxK21Xs4k4QEcWJcouvSh\r\n" + 
   		"9Sseik1aSFTbyCxaVoiwWEywszIUkizwSuLQakiaxj1EY3r0YkkwRvh3WAlrBGLD\r\n" + 
   		"WzDM7QKBgAHZU2xIhqKBDSJ3FH383dV6GFiwbqUmI0WuQqBIkxl9vEi4B7lQzj9J\r\n" + 
   		"gY4R1YvDA3SUoVB3Rd1B93If+59tZU30o800OpHJu0G8s1NFk66OzdeMRawKM/2a\r\n" + 
   		"HBaSGSxsv33pybuH4V3rpuveinEyt4ridlrmqIb+r4VIfZpSAcdC\r\n" + 
   		"-----END RSA PRIVATE KEY-----\r\n" + 
   		"";
   private String publicKey = "-----BEGIN PUBLIC KEY-----\r\n" + 
   		"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5jpjZuKNzicLNpgyYJ1F\r\n" + 
   		"7XEJBfAEfacbY5Y5n3oSFhPIk1a91SkBp6XZAhZiGAwqrZpSrwNDipzexzU/S+J0\r\n" + 
   		"fHYIQPgEY9BffnEIxtS+Mgi1y2fQrVJxAiSOiHMBqrAn5W8GLN5c/e2lRsL+I9ia\r\n" + 
   		"+xDcqbAPGA0imgsIu0bDM5iwqGyX9ZPj92BepV6R89k3KBH7wjL4ksRxP5Uz8OcC\r\n" + 
   		"wKzmuwp7uK/bAkzi/ZCa+JSEFhT0SOZJMsthlswaCPI9i2Mk21RnkFCK2iewtAS9\r\n" + 
   		"hplMd3OrQzxbi502v4x1hHMIILmCp2RYHy3KH8snY/gtdErLHrOH5p0c1N9O/TcG\r\n" + 
   		"OwIDAQAB\r\n" + 
   		"-----END PUBLIC KEY-----\r\n" + 
   		"";

   @Autowired
   @Qualifier("authenticationManagerBean")
   private AuthenticationManager authenticationManager;
   
   
   //#1 Create a JWT Access Token Converter
   @Bean
   public JwtAccessTokenConverter jwtAccessTokenConverter() {
      JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
      converter.setSigningKey(privateKey);
      converter.setVerifierKey(publicKey);
      return converter;
   }
   
   
   
//   @Bean
//   public JwtAccessTokenConverter jwtAccessTokenConverter() {
//       JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//       KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("keystore.jks"), "ravishankar".toCharArray())
//               .getKeyPair("ssl");
//       converter.setKeyPair(keyPair);
//       return converter;
//   }
   
   
   @Bean
   public JwtTokenStore tokenStore() {
      return new JwtTokenStore(jwtAccessTokenConverter());
   }
   
   @Override
   public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      
	   endpoints
      	.authenticationManager(authenticationManager)
      	.tokenStore(tokenStore())
      	.accessTokenConverter(jwtAccessTokenConverter());
   }
   
   @Override
   public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
      
	   security
	   	.tokenKeyAccess("permitAll()")
	   	.checkTokenAccess("isAuthenticated()");
   }
   
   @Override
   public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
      
	   clients
	   	.inMemory()
	   	.withClient(clientid)
	   	.secret("{noop}" + clientSecret)
//	   	.scopes("read", "write")
	   	.scopes("openid")
//        .authorizedGrantTypes("password", "refresh_token", "client_credentials", "authorization_code")
        .authorizedGrantTypes("implicit","refresh_token", "password", "authorization_code","client_credentials")

        .accessTokenValiditySeconds(20000)
//        .refreshTokenValiditySeconds(20000)
        ;

   }
} 