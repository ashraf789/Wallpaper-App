package net.a6te.lazycoder.wallpapers.models;

/**
 * Created by lazycoder on 3/5/18.
 */

public class Item {
    private String name;
    private String code;

    public Item(){

    }
    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
