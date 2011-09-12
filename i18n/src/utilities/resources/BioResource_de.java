/*
 * Copyright © 2011 jbundle.org. All rights reserved.
 */
package org.jbundle.biorhythm.resources;

import java.awt.*;
/*
 * Copyright (c) 1996 jbundle.org. All Rights Reserved.
 *	Copy freely, but don't sell this program or remove this copyright notice.
 *		Don_Corley@msn.com
 */

import java.util.*;

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
					 {"Physical Cycle", "k�rperlich Zyklus"},
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
