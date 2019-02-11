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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getPhoto_reference() {
        return photo_reference;
    }

    public void setPhoto_reference(String photo_reference) {
        this.photo_reference = photo_reference;
    }

    public List<String> getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(List<String> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
