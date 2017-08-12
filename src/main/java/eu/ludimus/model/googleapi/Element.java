package eu.ludimus.model.googleapi;

public class Element {

    private Distance distance;
    private Duration duration;
    private String status;

    public Distance getDistance() {
        return distance;
    }

    public Element setDistance(Distance distance) {
        this.distance = distance;
        return this;
    }

    public Duration getDuration() {
        return duration;
    }

    public Element setDuration(Duration duration) {
        this.duration = duration;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Element setStatus(String status) {
        this.status = status;
        return this;
    }

}