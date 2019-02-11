package domainDtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geometry {
    @JsonProperty("viewport")
    private Viewport viewport;
    @JsonProperty("location")
    private Location location;

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
