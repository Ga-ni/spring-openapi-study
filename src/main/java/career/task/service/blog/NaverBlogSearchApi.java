package career.task.service.blog;

import career.task.dto.blog.BlogSearchRequestDto;
import career.task.dto.blog.BlogSearchResponseDto;

public class NaverBlogSearchApi extends BlogSearchApi {

    public BlogSearchRequestDto request;
    public NaverBlogSearchApi(BlogSearchRequestDto request) {
        this.request = request;
    }

    @Override
    public BlogSearchResponseDto callApi() {
        return null;
    }
}
