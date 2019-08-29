package com.tkdev.ironmanstash.infinity_stones.fragments.allstones;

public class InfinityStone {

    private int imageId;
    private String stoneName;
    private int isVisible;


    public InfinityStone() {
    }

    protected int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    protected String getStoneName() {
        return stoneName;
    }

    public void setStoneName(String stoneName) {
        this.stoneName = stoneName;
    }

    protected int getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }

}

