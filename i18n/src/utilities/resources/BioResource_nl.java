/*
 * Copyright © 2011 jbundle.org. All rights reserved.
 */
package org.jbundle.biorhythm.resources;

/*
 * Copyright (c) 1996 jbundle.org. All Rights Reserved.
 *	Copy freely, but don't sell this program or remove this copyright notice.
 *		Don_Corley@msn.com
 */

import java.util.*;

public class BioResource_nl extends ListResourceBundle {
		static final Object[][] m_contents = {
			 // LOCALIZE THIS
			 		 {"Language", "Nederlands"},
			 		 {"LanguageInEnglish", "Dutch"},
					 {"Biorhythm", "Biorhythm"},		// "Biorththm"
					 {"Birthdate", "Geboortedatum"},		// Input field labels
					 {"Start Date", "begin"},
					 {"End Date", "einde"},
					 {"Emotional Cycle", "emotioneel cyclus"},	// Cycle Descriptions
					 {"Physical Cycle", "lichamelijk cyclus"},
					 {"Intellectual Cycle", "intelectueel cyclus"},
					 {"Critical", "kritiek"},		// Critials/High/Low
					 {"High", "hoog"},
					 {"Low", "laag"},
					 {"EnterBirthdate", "Voor uw geboortedatum in, in het geboortedatumveld."},
			 // END OF MATERIAL TO LOCALIZE
			 };

//----------------------------------------------------------------
// HsilgneDate - Default constructor (Same as EDate)
	public BioResource_nl() {
	}
/**
 * getContents method comment.
 */
protected java.lang.Object[][] getContents() {
	return m_contents;
}
}
