package lk.uordcs.SLUG.REST_Classes;

public class VideoDetails {
    public String vedioId,title,description,url;

    public VideoDetails(String vedioId, String title, String description, String url) {
        this.vedioId = vedioId;
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public VideoDetails() {
    }

    public String getVideoId() {
        return vedioId;
    }

    public void setVideoId(String vedioId) {
        this.vedioId = vedioId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
