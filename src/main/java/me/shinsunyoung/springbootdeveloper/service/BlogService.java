package me.shinsunyoung.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.Article;
import me.shinsunyoung.springbootdeveloper.dto.AddArticleRequest;
import me.shinsunyoung.springbootdeveloper.dto.UpdateArticleRequest;
import me.shinsunyoung.springbootdeveloper.repository.BlogRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

  private final BlogRepository blogRepository;


  public Article save(AddArticleRequest request, String userName){
    return blogRepository.save(request.toEntity(userName));
  }

  public List<Article> findAll(){
    return blogRepository.findAll();
  }

  public Article findById(Long id){
    return blogRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("not found: "+ id));
  }

  public void deleteById(Long id){


    blogRepository.deleteById(id);
  }

  public void delete(long id){
    Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));

    authorizeArticleAuthor(article);
    blogRepository.deleteById(id);
  }

  @Transactional
  public Article update(Long id, UpdateArticleRequest request){
    Article article = blogRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

    authorizeArticleAuthor(article);
    article.update(request.getTitle(), request.getContent());

    return article;
  }

  private static void authorizeArticleAuthor(Article article){
    String username = SecurityContextHolder.getContext().getAuthentication().getName();

    if(!article.getAuthor().equals(username)){
      throw new IllegalArgumentException("not authorized");
    }
  }
}
