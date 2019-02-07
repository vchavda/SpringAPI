package domainDtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Viewport {
    @JsonProperty("southwest")
    private Southwest southwest;
    @JsonProperty("northeast")
    private Northeast northeast;
}
