package domainDtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Photos {
    @JsonProperty("width")
    private int width;
    @JsonProperty("photo_reference")
    private String photo_reference;
    @JsonProperty("html_attributions")
    private List<String> html_attributions;
    @JsonProperty("height")
    private int height;
}
