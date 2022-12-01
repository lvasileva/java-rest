package example.qa.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CollectionLinks {

    @JsonProperty("self")
    private String self;

    @JsonProperty("html")
    private String html;

    @JsonProperty("photos")
    private String photos;

    @JsonProperty("related")
    private String related;

}
