package sa.lendo.gorest.api.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import sa.lendo.gorest.api.client.dto.CommentDto;
import sa.lendo.gorest.api.client.dto.PostDto;
import sa.lendo.gorest.api.client.dto.UserDto;
import sa.lendo.gorest.api.client.entity.User;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;


@RestController
public class GorestAPIClientController {

    @Autowired
    private WebClient webClient;

    @GetMapping("/api/hello")
    public String hello(Principal principal) {
        return "Hello " +principal.getName()+", Welcome to lendo gorest api integration!!";
    }

//    @GetMapping("/api/users")
//    public String[] users(
//            @RegisteredOAuth2AuthorizedClient("api-client-authorization-code")
//                    OAuth2AuthorizedClient client){
//        return this.webClient
//                .get()
//                .uri("http://127.0.0.1:8090/api/users")
//                .attributes(oauth2AuthorizedClient(client))
//                .retrieve()
//                .bodyToMono(String[].class)
//                .block();
//    }

    @GetMapping("/api/users")
    public ResponseEntity<List<UserDto>> users(
            @RegisteredOAuth2AuthorizedClient("api-client-authorization-code")
            OAuth2AuthorizedClient client){
        return this.webClient
                .get()
                .uri("http://127.0.0.1:8090/api/users")
                .attributes(oauth2AuthorizedClient(client))
                .retrieve()
                .toEntityList(UserDto.class)
                .block();
    }
    @GetMapping("/api/posts")
    public ResponseEntity<List<PostDto>> posts(
            @RegisteredOAuth2AuthorizedClient("api-client-authorization-code")
            OAuth2AuthorizedClient client){
        return this.webClient
                .get()
                .uri("http://127.0.0.1:8090/api/posts")
                .attributes(oauth2AuthorizedClient(client))
                .retrieve()
                .toEntityList(PostDto.class)
                .block();
    }

    @GetMapping("/api/comments")
    public ResponseEntity<List<CommentDto>> comments(
            @RegisteredOAuth2AuthorizedClient("api-client-authorization-code")
            OAuth2AuthorizedClient client){
        return this.webClient
                .get()
                .uri("http://127.0.0.1:8090/api/comments")
                .attributes(oauth2AuthorizedClient(client))
                .retrieve()
                .toEntityList(CommentDto.class)
                .block();
    }

    @GetMapping("/api/posts/{userId}")
    public ResponseEntity<List<PostDto>> userPosts(@PathVariable("userId") Integer userId,
            @RegisteredOAuth2AuthorizedClient("api-client-authorization-code")
            OAuth2AuthorizedClient client){

        return this.webClient
                .get()
                .uri("http://127.0.0.1:8090/api/posts/", userId.toString())
                .attributes(oauth2AuthorizedClient(client))
                .retrieve()
                .toEntityList(PostDto.class)
                .block();
    }

    @GetMapping("/api/comments/{postId}")
    public ResponseEntity<List<CommentDto>> postComments(@PathVariable("postId") Integer postId,
                                                   @RegisteredOAuth2AuthorizedClient("api-client-authorization-code")
                                                   OAuth2AuthorizedClient client){

        return this.webClient
                .get()
                .uri("http://127.0.0.1:8090/api/comments/", postId.toString())
                .attributes(oauth2AuthorizedClient(client))
                .retrieve()
                .toEntityList(CommentDto.class)
                .block();
    }
}
