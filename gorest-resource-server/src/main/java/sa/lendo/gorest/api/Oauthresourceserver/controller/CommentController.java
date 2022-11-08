package sa.lendo.gorest.api.Oauthresourceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sa.lendo.gorest.api.Oauthresourceserver.dto.CommentDto;
import sa.lendo.gorest.api.Oauthresourceserver.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentDto>> listOfComments() throws Exception {

        List<CommentDto> comments = commentService.getComments();
        return ResponseEntity.ok().body(comments);
    }
    @GetMapping(value = "/{postId}")
    public ResponseEntity<List<CommentDto>> getPostComments(@PathVariable("postId") Integer postId) throws Exception {

        List<CommentDto> comments = commentService.getPostComments(postId);
        return ResponseEntity.ok().body(comments);
    }
}
