package example.qa.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = { "cover_photo", "preview_photos"})
public class Collection {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("published_at")
    private String publishedAt;

    @JsonProperty("last_collected_at")
    private String lastCollectedAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("curated")
    private Boolean curated;

    @JsonProperty("featured")
    private Boolean featured;

    @JsonProperty("total_photos")
    private Integer totalPhotos;

    @JsonProperty("private")
    private Boolean isPrivate;

    @JsonProperty("share_key")
    private String shareKey;

    @JsonProperty("tags")
    private List<CollectionTag> tags;

    @JsonProperty("links")
    private CollectionLinks links;

    @JsonProperty("user")
    private User user;

    @JsonProperty("cover_photo")
    private List<String> coverPhoto;

    @JsonProperty("preview_photos")
    private List<String> previewPhotos;
}
