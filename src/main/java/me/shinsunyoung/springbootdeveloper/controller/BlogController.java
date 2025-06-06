package me.shinsunyoung.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.Article;
import me.shinsunyoung.springbootdeveloper.dto.AddArticleRequest;
import me.shinsunyoung.springbootdeveloper.dto.ArticleResponse;
import me.shinsunyoung.springbootdeveloper.dto.UpdateArticleRequest;
import me.shinsunyoung.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogController {

  private final BlogService blogService;

  @PostMapping("/api/articles")
  public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request, Principal principal){
    Article savedArticle = blogService.save(request, principal.getName());

    return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
  }

  @GetMapping("/api/articles")
  public ResponseEntity<List<ArticleResponse>> findAllArticles(){
    List<ArticleResponse> articles = blogService.findAll()
            .stream()
            .map(ArticleResponse::new)
            .toList();

    return ResponseEntity.ok()
            .body(articles);
  }

  @GetMapping("/api/articles/{id}")
  public ResponseEntity<ArticleResponse> findArticle(@PathVariable("id") long id){
    Article article = blogService.findById(id);

    return ResponseEntity.ok()
            .body(new ArticleResponse(article));
  }

  @DeleteMapping("/api/articles/{id}")
  public ResponseEntity<Void> deleteArticle(@PathVariable("id") long id){
    blogService.delete(id);

    return ResponseEntity.ok().build();
  }

  @PutMapping("/api/articles/{id}")
  public ResponseEntity<Article> updateArticle(@PathVariable("id") long id, @RequestBody UpdateArticleRequest request){
    Article updatedArticle = blogService.update(id, request);

    return ResponseEntity.ok().body(updatedArticle);
  }
}


