package career.task.dto.blog;

import lombok.Data;

import java.util.List;

@Data
public class NaverBlogSearchResponse {

    Integer total;
    List<items> items;

    public static class items{
        String bloggername;
        String title;
        String postdate;
        String link;
        String bloggerlink;
        String description;
    }
}
