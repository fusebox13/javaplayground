package com.fuseworks.labs.playground.endless;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Photo implements Serializable {

    @Id
    private long id;
    private long albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

    public Photo(long id, long albumId, String title, String url, String thumbnailUrl) {
        this.id = id;
        this.albumId = albumId;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public Photo() {
    }

    public long getId() {
        return id;
    }

    public long getAlbumId() {
        return albumId;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
