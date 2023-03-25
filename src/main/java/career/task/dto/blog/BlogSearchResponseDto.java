package career.task.dto.blog;

import lombok.Data;

import java.util.List;

@Data
public class BlogSearchResponseDto {
    private int per_page_count;
    private int total_count;
    private List<BlogInfo> blog_list;

    @Data
    public static class BlogInfo{
        String blog_name;
        String title;
        String post_date;
        String url;
        String thumbnail;
        String contents;
    }
}
