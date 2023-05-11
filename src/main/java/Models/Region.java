package Models;

public class Region {
    private Long id_region;

    private String abbr;
    private String region_name;
    private String region_location;

    public Region(){}

    public Region(String abbr, String region_name, String region_location) {
        this.abbr = abbr;
        this.region_name = region_name;
        this.region_location = region_location;
    }

    public Long getId_region() {
        return id_region;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getRegion_name() {
        return region_name;
    }

    public String getRegion_location() {
        return region_location;
    }

    public void setId_region(Long id_region) {
        this.id_region = id_region;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public void setRegion_location(String region_location) {
        this.region_location = region_location;
    }

    @Override
    public String toString() {
        return "Models.Region{" +
                "id_region=" + id_region +
                ", abbr='" + abbr + '\'' +
                ", region_name='" + region_name + '\'' +
                ", region_location='" + region_location + '\'' +
                '}';
    }
}
