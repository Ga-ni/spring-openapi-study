package career.task.dto.blog;

import career.task.eums.VendorType;
import career.task.service.blog.BlogSearchApi;
import career.task.service.blog.KakaoBlogSearchApi;
import career.task.service.blog.NaverBlogSearchApi;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BlogSearch {

    private BlogSearchApi api;

    @Builder
    public BlogSearch(BlogSearchApi api) {
        this.api = api;
    }

    /**
     * VendorType에 맞는 BlogSearchApi 객체를 반환한다.
     * @param vendorType
     * @param requestDto
     * @return
     */
    public static BlogSearch of(VendorType vendorType, BlogSearchRequestDto requestDto){
        if (vendorType == VendorType.NAVER){
            return ofNaver(requestDto);
        }
        return ofKakao(requestDto);
    }

    /**
     * of 메소드에서 Vendor가 KAKAO인 경우 호출되고, kakao api가 세팅된다.
     * @param requestDto
     * @return
     */
    private static BlogSearch ofKakao(BlogSearchRequestDto requestDto){
        return BlogSearch.builder()
                .api(new KakaoBlogSearchApi(requestDto))
                .build();
    }

    /**
     * of 메소드에서 Vendor가 NAVER인 경우 호출되고, naver api가 세팅된다.
     * @param requestDto
     * @return
     */
    private static BlogSearch ofNaver(BlogSearchRequestDto requestDto){
        return BlogSearch.builder()
                .api(new NaverBlogSearchApi(requestDto))
                .build();
    }

}
