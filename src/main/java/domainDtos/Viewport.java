package domainDtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Viewport {
    @JsonProperty("southwest")
    private Southwest southwest;
    @JsonProperty("northeast")
    private Northeast northeast;

    public Southwest getSouthwest() {
        return southwest;
    }

    public void setSouthwest(Southwest southwest) {
        this.southwest = southwest;
    }

    public Northeast getNortheast() {
        return northeast;
    }

    public void setNortheast(Northeast northeast) {
        this.northeast = northeast;
    }
}
