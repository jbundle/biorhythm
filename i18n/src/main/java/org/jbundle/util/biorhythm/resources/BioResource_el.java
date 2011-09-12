/*
 * Copyright © 2011 jbundle.org. All rights reserved.
 */
package org.jbundle.util.biorhythm.resources;

/*
 * Copyright (c) 1996 jbundle.org. All Rights Reserved.
 *	Copy freely, but don't sell this program or remove this copyright notice.
 *		Don_Corley@msn.com
 */

import java.util.*;

public class BioResource_el extends ListResourceBundle {
		static final Object[][] m_contents = {
			 // LOCALIZE THIS
// Dimitris Pergamalis
// pergam@otenet.gr
 		 {"Language", "ΕΛΛΗΝΙΚΑ (HELLINIKA)"},
			 		 {"LanguageInEnglish", "Greek"},
					 {"Biorhythm", "ΒΙΟΡΡΥΘΜΟΙ"},		// "Biorththm"
					 {"Birthdate", "ΗΜΕΡΟΜΗΝΙΑ ΓΕΝΝΗΣΗΣ"},		// Input field labels
					 {"Start Date", "ΕΝΑΡΞΗ"},
					 {"End Date", "ΤΕΛΟΣ"},
					 {"Emotional Cycle", "ΣΥΝΑΙΣΘΗΜΑΤΙΚΟΣ ΚΥΚΛΟΣ"},	// Cycle Descriptions
					 {"Physical Cycle", "ΦΥΣΙΚΟΣ ΚΥΚΛΟΣ"},
					 {"Intellectual Cycle", "ΠΝΕΥΜΑΤΙΚΟΣ ΚΥΚΛΟΣ"},
					 {"Critical", "ΚΡΙΣΙΜΟΣ"},		// Critials/High/Low
					 {"High", "ΥΨΗΛΟΣ"},
					 {"Low", "ΧΑΜΗΛΟΣ"},
					 {"EnterBirthdate", ""},
			 // END OF MATERIAL TO LOCALIZE
			 };

//----------------------------------------------------------------
// HsilgneDate - Default constructor (Same as EDate)
	public BioResource_el() {
		super();
	}
/**
 * getContents method comment.
 */
protected java.lang.Object[][] getContents() {
	return m_contents;
}
}
