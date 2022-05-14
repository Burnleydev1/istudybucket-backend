package com.elroykanye.istudybucket.api.controller;

import com.elroykanye.istudybucket.api.dto.PostDto;
import com.elroykanye.istudybucket.business.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/comment")
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addComment(@RequestBody PostDto postDto) {
        log.info("adding comment to post: {}", postDto.getSourcePostId());
        return new ResponseEntity<>(commentService.addComment(postDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{postId}")
    public ResponseEntity<List<PostDto>> getCommentsByPost(@PathVariable(value = "postId") Long postId) {
        return ResponseEntity.ok(commentService.getCommentsByPost(postId));
    }

    @GetMapping(value = "/{postId}/{authorId}")
    public ResponseEntity<List<PostDto>> getCommentByPostAndAuthor(
            @PathVariable(value = "postId") Long postId,
            @PathVariable(value = "authorId") Long authorId) {
        return ResponseEntity.ok(commentService.getCommentsByPostAndAuthor(postId, authorId));
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateComment(@RequestBody PostDto postDto) {
        log.info("Updating comment: {}", postDto.getPostId());
        return new ResponseEntity<>(commentService.updateComment(postDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "commentId") Long commentId) {
        log.info("Deleting comment: {}", commentId);
        return new ResponseEntity<>(commentService.deleteComment(commentId), HttpStatus.OK);
    }
}
