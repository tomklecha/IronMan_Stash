package com.tkdev.ironmanstash.infinity_stones;

public class InfinityStones{

    private int imageId;
    private String stoneName;

    public InfinityStones(int imageId, String stoneName) {
        this.imageId = imageId;
        this.stoneName = stoneName;
    }

    public int getImageId() {
        return imageId;
    }

    public String getStoneName() {
        return stoneName;
    }
}
