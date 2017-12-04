package com.testinstanfit.presentation.view;



import com.testinstanfit.domain.model.trainer.ItemTrainer;

import java.util.List;

/**
 * Created by Daniel Ruiz
 */

public interface IListView extends IView {

    public void showDataList(List<ItemTrainer> itemTrainerList);
}
