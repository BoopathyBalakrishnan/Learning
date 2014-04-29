package com.blx.app.adrd.tnprofcounseling.tnea.test;

import com.blx.app.adrd.tnprofcounseling.framework.FrameworkConstants;
import com.blx.app.adrd.tnprofcounseling.framework.FrameworkValidator;


public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(FrameworkValidator.validateStringValWithRegEx("23",FrameworkConstants.REGEX_PATTERN_CUTOFF_MARK));
		System.out.println(String.format("%2d", String.valueOf(1)));

	}

}
