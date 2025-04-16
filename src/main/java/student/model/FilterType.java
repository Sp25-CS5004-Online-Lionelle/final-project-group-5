package student.model;

/** A list of filter types allowed for filtering and sort. */
public enum FilterType {
    GENRE, RATING, YEAR, TITLE, DESCRIPTION;

    /**
     * Helper function to check if a value is in the list of formats.
     *
     * @param value the value to check
     * @return the format type if found, null otherwise
     */
    public static FilterType containsValues(String value) {
        for (FilterType filterFormat : FilterType.values()) {
            if (filterFormat.toString().equalsIgnoreCase(value)) {
                return filterFormat;
            }
        }
        return null;
    }

/*     public static FilterType fromString(String value) {
        String cleaned = value.toUpperCase().replaceAll("[^A-Z]", "");

        for (FilterType type : FilterType.values()) {
            if (type.name().replaceAll("[^A-Z]", "").equalsIgnoreCase(cleaned)) {
                return type;
            }
        }

        throw new IllegalArgumentException("Invalid filter type: " + value);
    }
}
 */
}
