/**
 * 
 */
package com.blx.app.adrd.tnprofcounseling.framework;

import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * @author Nanjundan Chinnasamy
 * @version 1.0
 * 
 */
public class FrameworkValidator {

	   /**
	    * Method that to check the the given string is empty or not
	    *
	    * @param inputText
	    * @return
	    */
		public  static boolean isStringEmpty(String inputStr) {
			return TextUtils.isEmpty(inputStr);
		}
		
   /**
    * Method that to check the EditText field value is Empty OR Not
    *
    * @param inputText
    * @return
    */
	public static boolean isEditTextEmpty(EditText inputText) {
		return TextUtils.isEmpty(inputText.getText());
	}
	
	/**
	 * Method used to validate the text input against the regex pattern given 
	 * 
	 * @param textegInput
	 * @param regExPattern
	 * @return
	 */
	public static boolean validateTextInputWithRegEx(EditText textInput, String regExPattern){
		if(!isEditTextEmpty(textInput)){
			return textInput.getText().toString().matches(regExPattern);
		}
		return false;
	}

	/**
	 * Method used to validate the String value against the regex pattern given 
	 * 
	 * @param textegInput
	 * @param regExPattern
	 * @return
	 */
	public static  boolean validateStringValWithRegEx(String strVal, String regExPattern){
		if(!isStringEmpty(strVal)){
			return strVal.matches(regExPattern);
		}
		return false;
	}
	
	/**
	 * Method to check whether any checkbox is checked from the given checkbox list
	 * 
	 * @param checkBoxArray
	 * @return
	 */
	public static boolean isCheckBoxsGroupEmpty(CheckBox...checkBoxArray ){ 
		boolean checkBoxChecked=false;
		for(CheckBox checkBoxObj:checkBoxArray){
			if(checkBoxObj.isChecked()){
				return true;
			} else{
				continue;
			}
		}
		return checkBoxChecked;
	}	
}
