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
public class User {

    @JsonProperty("id")
    private String id;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("username")
    private String username;

    @JsonProperty("name")
    private String name;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("twitter_username")
    private String twitterUsername;

    @JsonProperty("portfolio_url")
    private String portfolioUrl;

    @JsonProperty("bio")
    private String bio;

    @JsonProperty("location")
    private String location;

    @JsonProperty("links")
    private UserLinks links;

    @JsonProperty("profile_image")
    private UserProfileImage profileImage;

    @JsonProperty("instagram_username")
    private String instagramUsername;

    @JsonProperty("total_collections")
    private Integer totalCollections;

    @JsonProperty("total_likes")
    private Integer totalLikes;

    @JsonProperty("total_photos")
    private Integer totalPhotos;

    @JsonProperty("accepted_tos")
    private Boolean accepted_tos;

    @JsonProperty("for_hire")
    private Boolean for_hire;

    @JsonProperty("social")
    private UserSocial social;
}
