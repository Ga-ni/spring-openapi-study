package career.task.api.controller.blog;

import career.task.dto.blog.BlogSearchRequestDto;
import career.task.dto.blog.BlogSearchResponseDto;
import career.task.service.blog.BlogSearchApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogSearchApiController {
    @Autowired BlogSearchApiService blogSearchApiService;

    @GetMapping("/api/search/blog")
    // TODO : valid 추가
    public String blogSearch(BlogSearchRequestDto blogSearchRequestDto){
        return "redirect:/";
    }

}
