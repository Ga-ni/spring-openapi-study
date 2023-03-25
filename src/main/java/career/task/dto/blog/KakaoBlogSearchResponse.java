package career.task.dto.blog;

import lombok.Data;

import java.util.List;

@Data
public class KakaoBlogSearchResponse {

    KakaoBlogSearchResponse.Meta meta;
    List<documents> documents;

    @Data
    public static class Meta{
        Boolean is_end;
        Integer pageable_count;
        public Integer total_count;
    }

    @Data
    public static class documents{
        String blogname;
        String title;
        String datetime;
        String url;
        String thumbnail;
        String contents;
    }
}
