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
public class UserProfileImage {

    @JsonProperty("small")
    private String small;

    @JsonProperty("medium")
    private String medium;

    @JsonProperty("large")
    private String large;
}
