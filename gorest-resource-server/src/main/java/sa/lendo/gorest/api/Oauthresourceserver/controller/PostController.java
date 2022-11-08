package sa.lendo.gorest.api.Oauthresourceserver.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sa.lendo.gorest.api.Oauthresourceserver.dto.PostDto;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private sa.lendo.gorest.api.Oauthresourceserver.service.PostService PostService;

    @GetMapping
    public ResponseEntity<List<PostDto>> listOfUsers() throws Exception {

        List<PostDto> posts = PostService.getPosts();
        return ResponseEntity.ok().body(posts);
    }


    @GetMapping(value = "/{userId}")
    public ResponseEntity<List<PostDto>> getUserPosts(@PathVariable("userId") Integer userId) throws Exception {

        List<PostDto> posts = PostService.getUserPosts(userId);
        return ResponseEntity.ok().body(posts);
    }
}
