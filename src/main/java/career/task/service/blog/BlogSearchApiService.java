package career.task.service.blog;

import career.task.dto.blog.BlogSearch;
import career.task.dto.blog.BlogSearchRequestDto;
import career.task.dto.blog.BlogSearchResponseDto;
import career.task.eums.VendorType;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BlogSearchApiService {

    private static final String KAKAO = "kakao";
    private static final String NAVER = "naver";

    public Optional<BlogSearchResponseDto> blogSearch(BlogSearchRequestDto blogSearchRequestDto){
        VendorType vendorType = getVendorType(blogSearchRequestDto.getVendor());
        BlogSearch blogSearch = BlogSearch.of(vendorType, blogSearchRequestDto);
        BlogSearchApi blogSearchApi = blogSearch.getApi();

        return Optional.ofNullable(blogSearchApi.callApi());
    }

    private VendorType getVendorType(String vendor){
        if (NAVER.equals(vendor)) {
            return VendorType.NAVER;
        }
        return VendorType.KAKAO;
    }

}
