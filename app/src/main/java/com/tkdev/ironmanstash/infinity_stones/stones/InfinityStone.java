package com.tkdev.ironmanstash.infinity_stones.stones;

import java.util.ArrayList;
import java.util.List;

public class InfinityStone {

    private int imageId;
    private String stoneName;
    private int isVisible;

//    public InfinityStone(int imageId, String stoneName, int isVisible) {
//        this.imageId = imageId;
//        this.stoneName = stoneName;
//        this.isVisible = isVisible;
//    }


    public InfinityStone() {
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getStoneName() {
        return stoneName;
    }

    public void setStoneName(String stoneName) {
        this.stoneName = stoneName;
    }

    public int getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }


}

