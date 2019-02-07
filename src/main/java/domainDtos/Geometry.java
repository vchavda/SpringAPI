package domainDtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geometry {
    @JsonProperty("viewport")
    private Viewport viewport;
    @JsonProperty("location")
    private Location location;
}
