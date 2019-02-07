package domainDtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Northeast {
    @JsonProperty("lng")
    private double lng;
    @JsonProperty("lat")
    private double lat;
}
