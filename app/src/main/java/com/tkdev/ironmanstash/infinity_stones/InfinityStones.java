package com.tkdev.ironmanstash.infinity_stones;

public class InfinityStones{

    private int imageId;
    private String stoneName;
    private int isVisible;

    public InfinityStones(int imageId, String stoneName, int isVisible) {
        this.imageId = imageId;
        this.stoneName = stoneName;
        this.isVisible = isVisible;
    }

    public int getImageId() {
        return imageId;
    }

    public String getStoneName() {
        return stoneName;
    }

    public int isVisible() {
        return isVisible;
    }

    public void setVisible(int visible) {
        isVisible = visible;
    }
}
