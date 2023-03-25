package career.task.mapper;

import career.task.dto.blog.BlogSearchResponseDto;
import career.task.dto.blog.NaverBlogSearchResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NaverBlogListMapper {

    NaverBlogListMapper INSTANCE = Mappers.getMapper(NaverBlogListMapper.class);

    @Mappings({
            @Mapping(source = "bloggername", target="blog_name"),
            @Mapping(source = "link", target="url"),
            @Mapping(source = "bloggerlink", target="thumbnail"),
            @Mapping(source = "description", target="contents"),
    })

    List<BlogSearchResponseDto.BlogInfo> getBlogList(List<NaverBlogSearchResponse.items> items);
}
