/**
 * 
 */
package com.blx.app.adrd.tnprofcounseling.framework.Validator;

import android.widget.EditText;
import android.widget.Spinner;

import com.blx.app.adrd.tnprofcounseling.framework.FrameworkConstants;
import com.blx.app.adrd.tnprofcounseling.framework.FrameworkValidator;

/**
 * @author Nanjundan Chinnasamy
 * 
 */
public class TNEAValidator extends FrameworkValidator {

	/**
	 * method to check the TNEA cutoff mark entered
	 * 
	 * @param cutOffMark
	 * @return
	 */
	public static boolean validateTNEACutOffMark(EditText cutOffMark) {
		return validateTextInputWithRegEx(cutOffMark,
				FrameworkConstants.REGEX_PATTERN_CUTOFF_MARK);
	}

	/**
	 * method to check the college code entered 
	 * 
	 * @param collegeCode
	 * @return
	 */
	public static boolean validateTNEACollegeCode(EditText collegeCode) {
		return validateTextInputWithRegEx(collegeCode,
				FrameworkConstants.REGEX_PATTERN_COLLEGE_CODE);
	}

	/**
	 * Method to validate all spinner selected item
	 * 
	 * @param deptSpinner
	 * @return
	 */
	public static boolean validateTNEASpinnerSelection(Spinner deptSpinner) {
		return !deptSpinner.getSelectedItem().toString().equals(FrameworkConstants.SPINNER_DEFAULT_TEXT);
	}
}
