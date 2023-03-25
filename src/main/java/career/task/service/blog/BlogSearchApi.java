package career.task.service.blog;

import career.task.dto.blog.BlogSearchResponseDto;

public abstract class BlogSearchApi {

    public BlogSearchApi() {}

    public abstract BlogSearchResponseDto callApi();
}
