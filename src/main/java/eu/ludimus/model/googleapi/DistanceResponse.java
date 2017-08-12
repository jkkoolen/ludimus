package eu.ludimus.model.googleapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DistanceResponse {
    @JsonProperty("destination_addresses")
    private List<String> destinationAddresses = null;
    @JsonProperty("origin_addresses")
    private List<String> originAddresses = null;
    private List<Row> rows = null;
    private String status;

    public List<String> getDestinationAddresses() {
        return destinationAddresses;
    }

    public DistanceResponse setDestinationAddresses(List<String> destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
        return this;
    }

    public List<String> getOriginAddresses() {
        return originAddresses;
    }

    public DistanceResponse setOriginAddresses(List<String> originAddresses) {
        this.originAddresses = originAddresses;
        return this;
    }

    public List<Row> getRows() {
        return rows;
    }

    public DistanceResponse setRows(List<Row> rows) {
        this.rows = rows;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public DistanceResponse setStatus(String status) {
        this.status = status;
        return this;
    }
}
