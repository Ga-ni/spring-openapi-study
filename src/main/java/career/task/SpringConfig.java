package career.task;

import career.task.dto.blog.BlogSearchRequestDto;
import career.task.service.blog.KakaoBlogSearchApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    KakaoBlogSearchApi kakaoBlogSearchApi(){
        return new KakaoBlogSearchApi(blogSearchRequestDto());
    }

    @Bean
    BlogSearchRequestDto blogSearchRequestDto(){
        return new BlogSearchRequestDto();
    }
}
