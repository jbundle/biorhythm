/*
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package org.jbundle.util.biorhythm.resources;

/*
 * Copyright © 2012 jbundle.org. All Rights Reserved.
 *	Copy freely, but don't sell this program or remove this copyright notice.
 *		Don_Corley@msn.com
 */

import java.util.*;

public class BioResource_he extends ListResourceBundle {
		static final Object[][] m_contents = {
			 // LOCALIZE THIS
// shai landau
// tv23@usa.net
			 		 {"Language", "eivrit"},
			 		 {"LanguageInEnglish", "Hebrew"},
					 {"Biorhythm", "mahzoriot"},		// "Biorththm"
					 {"Birthdate", "tarih leida"},		// Input field labels
					 {"Start Date", "athala"},
					 {"End Date", "sof"},
					 {"Emotional Cycle", "Cyclemahazor rigshi"},	// Cycle Descriptions
					 {"Physical Cycle", "mahazor fizi"},
					 {"Intellectual Cycle", "mahazor sihli"},
					 {"Critical", "gorali"},		// Critials/High/Low
					 {"High", "gavoa"},
					 {"Low", "namoh"},
					 {"EnterBirthdate", "Enter your birthdate in the Birthdate field."},
			 // END OF MATERIAL TO LOCALIZE
			 };

//----------------------------------------------------------------
// HsilgneDate - Default constructor (Same as EDate)
	public BioResource_he() {
		super();
	}
/**
 * getContents method comment.
 */
protected java.lang.Object[][] getContents() {
	return m_contents;
}
}
