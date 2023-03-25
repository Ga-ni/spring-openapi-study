package career.task.mapper;

import career.task.dto.blog.BlogSearchResponseDto;
import career.task.dto.blog.KakaoBlogSearchResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-25T19:10:57+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.10 (AdoptOpenJDK)"
)
public class KakaoBlogListMapperImpl implements KakaoBlogListMapper {

    @Override
    public List<BlogSearchResponseDto.BlogInfo> getBlogList(List<KakaoBlogSearchResponse.documents> document) {
        if ( document == null ) {
            return null;
        }

        List<BlogSearchResponseDto.BlogInfo> list = new ArrayList<BlogSearchResponseDto.BlogInfo>( document.size() );
        for ( KakaoBlogSearchResponse.documents documents : document ) {
            list.add( documentsToBlogInfo( documents ) );
        }

        return list;
    }

    protected BlogSearchResponseDto.BlogInfo documentsToBlogInfo(KakaoBlogSearchResponse.documents documents) {
        if ( documents == null ) {
            return null;
        }

        BlogSearchResponseDto.BlogInfo blogInfo = new BlogSearchResponseDto.BlogInfo();

        blogInfo.setTitle( documents.getTitle() );
        blogInfo.setUrl( documents.getUrl() );
        blogInfo.setThumbnail( documents.getThumbnail() );
        blogInfo.setContents( documents.getContents() );

        return blogInfo;
    }
}
