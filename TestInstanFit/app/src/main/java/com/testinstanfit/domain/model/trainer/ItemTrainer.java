package com.testinstanfit.domain.model.trainer;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 09/11/2017.
 */

public class ItemTrainer {
    @SerializedName("id")
    private int  id ;
    @SerializedName("name")
    private String name ;
    @SerializedName("description")
    private String description;
    @SerializedName("filter_available")

    private boolean filterAvailable;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("avatar_pictures")
    private AvatarPictures avatarPictures;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean isFilterAvailable() {
        return filterAvailable;
    }

    public void setFilterAvailable(boolean filterAvailable) {
        this.filterAvailable = filterAvailable;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public AvatarPictures getAvatarPictures() {
        return avatarPictures;
    }

    public void setAvatarPictures(AvatarPictures avatarPictures) {
        this.avatarPictures = avatarPictures;
    }
}
