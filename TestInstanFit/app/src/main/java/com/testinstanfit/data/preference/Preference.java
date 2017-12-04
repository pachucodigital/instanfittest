package com.testinstanfit.data.preference;

import android.app.Activity;
import android.content.SharedPreferences;

import com.testinstanfit.app.InstanFitApplication;


public abstract
class Preference
{
	 
	 private final static String NAME = "PREFERENCE INSTANFIT";
	 
	 protected SharedPreferences systemPreferences;
	 
	 protected SharedPreferences.Editor editor;
	 
	 public Preference(  )
	 {
			
			this.systemPreferences = InstanFitApplication.getInstance().getSharedPreferences ( NAME,
																															Activity.MODE_PRIVATE );
			this.editor = systemPreferences.edit ( );
	 }
}
