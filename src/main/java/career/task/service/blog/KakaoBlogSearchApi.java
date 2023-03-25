package career.task.service.blog;

import career.task.dto.blog.BlogSearchRequestDto;
import career.task.dto.blog.BlogSearchResponseDto;
import career.task.dto.blog.KakaoBlogSearchResponse;
import career.task.eums.SortType;
import career.task.mapper.KakaoBlogSearchResponseMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class KakaoBlogSearchApi extends BlogSearchApi {

    @Value("${kakao-api-host}")
    private String host;

    @Value("${kakao-api-key}")
    private String apiKey;

    private static final String PATH = "/v2/search/blog";
    private static final String KAKAO_SORT_TYPE_ACCURACY = "accuracy";
    private static final String KAKAO_SORT_TYPE_RECENCY = "recency";



    @Autowired BlogSearchRequestDto request;

    public KakaoBlogSearchApi(BlogSearchRequestDto request) {
        this.request = request;
        setSortValue(request.getSort());
    }

    private void setSortValue(String sort){
        if (SortType.RECENCY.getValue().equals(sort)){
            this.request.setSort(KAKAO_SORT_TYPE_RECENCY);
        }
        else {
            this.request.setSort(KAKAO_SORT_TYPE_ACCURACY);
        }
    }

    @Override
    public BlogSearchResponseDto callApi() {
        Mono<KakaoBlogSearchResponse> responseMono = WebClient.create(host)
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(PATH)
                        .queryParam("query", request.getKeyword())
                        .queryParam("sort", request.getSort())
                        .queryParam("count", request.getPer_page_size())
                        .queryParam("page", request.getPage())
                        .build())
                .header("Authorization", "KakaoAK " + apiKey)
                .retrieve()
//                .onStatus(
//                        Predicate.not(HttpStatus::is2xxSuccessful), clientResponse ->
//                                error(new ApplicationException(ERROR_MSG))
//                )
                .bodyToMono(KakaoBlogSearchResponse.class);

        KakaoBlogSearchResponse kResponse = responseMono.block();

        return KakaoBlogSearchResponseMapperImpl.INSTANCE.toDto(kResponse);

    }

}
