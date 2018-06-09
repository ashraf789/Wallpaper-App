package net.a6te.lazycoder.wallpapers.models;

/**
 * Created by lazycoder on 3/6/18.
 */

public class Wallpaper extends Item{
    private String imageUrl;

    public Wallpaper(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Wallpaper(String name, String code, String imageUrl) {
        super(name, code);
        this.imageUrl = imageUrl;
    }

    public Wallpaper(String name, String imageUrl) {
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
