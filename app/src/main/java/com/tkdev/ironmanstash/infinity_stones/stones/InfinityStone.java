package com.tkdev.ironmanstash.infinity_stones.stones;

import java.util.ArrayList;
import java.util.List;

public class InfinityStone {

    private int imageId;
    private String stoneName;
    private int isVisible;


     InfinityStone() {
    }

     int getImageId() {
        return imageId;
    }

    void setImageId(int imageId) {
        this.imageId = imageId;
    }

     String getStoneName() {
        return stoneName;
    }

     void setStoneName(String stoneName) {
        this.stoneName = stoneName;
    }

     int getIsVisible() {
        return isVisible;
    }

     void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }

}

