package career.task.dto.blog;

import lombok.Data;

@Data
public class BlogSearchRequestDto {

    public String vendor;
    public String keyword;
    public String sort;
    public int page;
    public int per_page_size;

}
