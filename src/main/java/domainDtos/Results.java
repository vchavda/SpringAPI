package domainDtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Results {
    @JsonProperty("user_ratings_total")
    private int user_ratings_total;
    @JsonProperty("types")
    private List<String> types;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("rating")
    private int rating;
    @JsonProperty("place_id")
    private String place_id;
    @JsonProperty("photos")
    private List<Photos> photos;
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("geometry")
    private Geometry geometry;
    @JsonProperty("formatted_address")
    private String formatted_address;
}
