package domainDtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Southwest {
    @JsonProperty("lng")
    private double lng;
    @JsonProperty("lat")
    private double lat;
}
