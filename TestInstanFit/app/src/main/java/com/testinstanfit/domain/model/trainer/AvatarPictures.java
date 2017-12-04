package com.testinstanfit.domain.model.trainer;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Daniel Ruiz
 */

public class AvatarPictures {

    @SerializedName("full_size")
    private String fullSize;
    @SerializedName("big")
    private String big;
    @SerializedName("medium")
    private String medium;
    @SerializedName("small")
    private String small;

    public String getFullSize() {
        return fullSize;
    }

    public void setFullSize(String fullSize) {
        this.fullSize = fullSize;
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }
}
