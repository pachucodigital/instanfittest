package com.testinstanfit.data.preference;

import com.testinstanfit.app.utils.TYPE_VIEW_LIST;

/**
 * Created by Daniel Ruis
 */

public class SettingsPreference extends  Preference {
    private final static  String VIEW_TRAINERS="VIEW_TRAINERS";

    public boolean saveType(TYPE_VIEW_LIST typeViewList){
        editor.putString(VIEW_TRAINERS,typeViewList.name());
        return editor.commit();
    }

    public TYPE_VIEW_LIST getType(){
        if(systemPreferences.getString(VIEW_TRAINERS,TYPE_VIEW_LIST.LIST.name()).equalsIgnoreCase(TYPE_VIEW_LIST.LIST.name())){
            return TYPE_VIEW_LIST.LIST;
        }else{
            return TYPE_VIEW_LIST.GRID;
        }
    }
}
