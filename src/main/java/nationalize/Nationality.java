package nationalize;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Stores the possible countries of origin for a last name.
 */
@lombok.Data
public class Nationality {

    private long count;
    private String name;

    @SerializedName("country")
    private List<Country> countries;

    /**
     * Associates a probability with a country of origin.
     */
    @lombok.Data
    public static class Country {
        private String countryId;
        private float probability;
    }

}
