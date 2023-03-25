package career.task.mapper;

import career.task.dto.blog.BlogSearchResponseDto;
import career.task.dto.blog.KakaoBlogSearchResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface KakaoBlogSearchResponseMapper {

    KakaoBlogSearchResponseMapper INSTANCE = Mappers.getMapper(KakaoBlogSearchResponseMapper.class);

    @Mappings({
            @Mapping(target = "per_page_count", ignore = true),
            @Mapping(source = "kakaoResponse.documents", target = "blog_list"),

    })

    default BlogSearchResponseDto toDto(KakaoBlogSearchResponse kakaoResponse){
        BlogSearchResponseDto dto = new BlogSearchResponseDto();
        dto.setTotal_count(kakaoResponse.getMeta().total_count);
        dto.setBlog_list(KakaoBlogListMapperImpl.INSTANCE.getBlogList(kakaoResponse.getDocuments()));
        return dto;
    }

}
