package career.task.mapper;

import career.task.dto.blog.BlogSearchResponseDto;
import career.task.dto.blog.NaverBlogSearchResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NaverBlogSearchResponseMapper {

    NaverBlogSearchResponseMapper INSTANCE = Mappers.getMapper(NaverBlogSearchResponseMapper.class);

    @Mappings({
            @Mapping(target = "per_page_count", ignore = true),
            @Mapping(source = "total", target = "total_count"),
            @Mapping(source = "naverResponse.items", target = "blog_list"),
//            @Mapping(source = "naverResponse.items.link", target = "blog_list.url"),
//            @Mapping(source = "naverResponse.items.description", target = "blog_list.contents"),
//            @Mapping(source = "naverResponse.items.bloggername", target = "blog_list.blog_name")
    })

    default BlogSearchResponseDto toDto(NaverBlogSearchResponse naverResponse){
        BlogSearchResponseDto dto = new BlogSearchResponseDto();
        dto.setTotal_count(naverResponse.getTotal());
        dto.setBlog_list(NaverBlogListMapperImpl.INSTANCE.getBlogList(naverResponse.getItems()));
        return dto;
    }

}
