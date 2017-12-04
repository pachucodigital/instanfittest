package com.testinstanfit.domain.model.trainer;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Daniel Ruiz
 */

public class ResponseTrainerList {
    @SerializedName("data")
    private List<ItemTrainer> data;

    public ResponseTrainerList(){}

    public List<ItemTrainer> getArray() {
        return data;
    }

    public void setArray(List<ItemTrainer> array) {
        this.data = array;
    }
}
