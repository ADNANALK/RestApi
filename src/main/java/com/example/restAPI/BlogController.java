package com.example.restAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class BlogController {

/*BlogMockedData blogMockedData = BlogMockedData.getInstance();



   @GetMapping("/blog")
    public List<Blog> index(){
        return  blogMockedData.fetchBlogs();
    }

    @PostMapping("/create")
    public Blog create(@RequestBody Map<String ,String> body) {
        return  blogMockedData.createNewBlog(Integer.parseInt(body.get("id")), body.get("title"), body.get("content"));
    }

    @PutMapping("/edit/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
        int blogId = Integer.parseInt(id);
        String title = body.get("title");
        String content = body.get("content");
        return blogMockedData.updateBlog(blogId, title, content);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogMockedData.delete(blogId);
    }
    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogMockedData.getBlogById(blogId);
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return blogMockedData.searchBlogs(searchTerm);
    }*/



    @Autowired
    BlogRespository blogRespository;


    @GetMapping("/")
    public String PrintMsg(){
        return "Hello";
    }

    @GetMapping("/blog")
    public List<Blog> index(){
        return blogRespository.findAll();
    }

    @GetMapping("/details/{id}")
    public Blog show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogRespository.getOne(blogId);
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return blogRespository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PostMapping("/create")
    public Blog create(@RequestBody Map<String, String> body){
        String title = body.get("title");
        String content = body.get("content");
        Blog newBlog = new Blog(title, content);
        return blogRespository.save(newBlog);
    }

    @PutMapping("/edit/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
        int blogId = Integer.parseInt(id);
        // getting blog
        Blog blog = blogRespository.getOne(blogId);
        blog.setTitle(body.get("title"));
        blog.setContent(body.get("content"));
        return blogRespository.save(blog);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        Blog blog = blogRespository.getOne(blogId);
        blogRespository.delete(blog);
        return true;
    }

    @GetMapping("get-by-content/{text}")
    public Blog getByContent(@PathVariable String text)
    {
        return blogRespository.testQuery(text);

    }

}
