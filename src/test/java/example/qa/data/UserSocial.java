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
public class UserSocial {

    @JsonProperty("instagram_username")
    private String instagramUsername;

    @JsonProperty("portfolio_url")
    private String portfolioUrl;

    @JsonProperty("twitter_username")
    private String twitterUsername;

    @JsonProperty("paypal_email")
    private String paypalEmail;
}
