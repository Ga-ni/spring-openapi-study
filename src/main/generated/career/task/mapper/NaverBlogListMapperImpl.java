package career.task.mapper;

import career.task.dto.blog.BlogSearchResponseDto;
import career.task.dto.blog.NaverBlogSearchResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-25T19:10:57+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.10 (AdoptOpenJDK)"
)
public class NaverBlogListMapperImpl implements NaverBlogListMapper {

    @Override
    public List<BlogSearchResponseDto.BlogInfo> getBlogList(List<NaverBlogSearchResponse.items> items) {
        if ( items == null ) {
            return null;
        }

        List<BlogSearchResponseDto.BlogInfo> list = new ArrayList<BlogSearchResponseDto.BlogInfo>( items.size() );
        for ( NaverBlogSearchResponse.items items1 : items ) {
            list.add( itemsToBlogInfo( items1 ) );
        }

        return list;
    }

    protected BlogSearchResponseDto.BlogInfo itemsToBlogInfo(NaverBlogSearchResponse.items items) {
        if ( items == null ) {
            return null;
        }

        BlogSearchResponseDto.BlogInfo blogInfo = new BlogSearchResponseDto.BlogInfo();

        return blogInfo;
    }
}
