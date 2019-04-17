package sampleDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SampleDTO {

    @JsonProperty("hairDetails")
    private List<HairDetails> hairDetails;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("personID")
    private int personID;
}
