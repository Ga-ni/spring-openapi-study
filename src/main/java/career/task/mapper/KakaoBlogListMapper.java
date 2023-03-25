package career.task.mapper;

import career.task.dto.blog.BlogSearchResponseDto;
import career.task.dto.blog.KakaoBlogSearchResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface KakaoBlogListMapper {

    KakaoBlogListMapper INSTANCE = Mappers.getMapper(KakaoBlogListMapper.class);

    @Mappings({
            @Mapping(source = "blogname", target="blog_name"),
            @Mapping(source = "datetime", target="post_date"),
    })
    List<BlogSearchResponseDto.BlogInfo> getBlogList(List<KakaoBlogSearchResponse.documents> document);
}
