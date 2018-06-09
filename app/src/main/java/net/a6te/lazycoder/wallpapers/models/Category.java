package net.a6te.lazycoder.wallpapers.models;

/**
 * Created by lazycoder on 3/5/18.
 */

public class Category extends Item {
    private String imageUrl;

    public Category(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category(String name, String code, String imageUrl) {
        super(name, code);
        this.imageUrl = imageUrl;
    }

    public Category(String name, String imageUrl) {
        super(name);
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
