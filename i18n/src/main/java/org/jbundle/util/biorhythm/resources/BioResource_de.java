/*
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package org.jbundle.util.biorhythm.resources;

import java.util.ListResourceBundle;

public class BioResource_de extends ListResourceBundle {
		static final Object[][] m_contents = {
			 // LOCALIZE THIS
			 		 {"Language", "Deutsch"},
			 		 {"LanguageInEnglish", "German"},
					 {"Biorhythm", "Biorhythm"},		// "Biorththm"
					 {"Birthdate", "Geburtstag"},		// Input field labels
					 {"Start Date", "Start"},
					 {"End Date", "Ende"},
					 {"Emotional Cycle", "emotional Zyklus"},	// Cycle Descriptions
					 {"Physical Cycle", "körperlich Zyklus"},
					 {"Intellectual Cycle", "intellektuell Zyklus"},
					 {"Critical", "kritisch"},		// Critials/High/Low
					 {"High", "hoch"},
					 {"Low", "tief"},
					 {"EnterBirthdate", "Furen Sie bitte ihr Geburtstag ein, im Geburtstagfeld."},
			 // END OF MATERIAL TO LOCALIZE
			 };

//----------------------------------------------------------------
// HsilgneDate - Default constructor (Same as EDate)
	public BioResource_de() {
	}
/**
 * getContents method comment.
 */
protected java.lang.Object[][] getContents() {
	return m_contents;
}
}
