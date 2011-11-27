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

public class BioResource_ro extends ListResourceBundle {
		static final Object[][] m_contents = {
			 // LOCALIZE THIS
			 		 {"Language", "Romaneste"},
			 		 {"LanguageInEnglish", "Romanian"},
					 {"Biorhythm", "Biorhythm"},		// "Biorththm"
					 {"Birthdate", "Data nasterii"},		// Input field labels
					 {"Start Date", "Inceput"},
					 {"End Date", "Sfarsit"},
					 {"Emotional Cycle", "Ciclu Emotiv"},	// Cycle Descriptions
					 {"Physical Cycle", "Ciclu Fizic"},
					 {"Intellectual Cycle", "Ciclu Intelectual"},
					 {"Critical", "Critic"},		// Critials/High/Low
					 {"High", "Bun"},
					 {"Low", "Slab"},
					 {"EnterBirthdate", "Introduceti data nasterii in campul corespunzator."},
			 // END OF MATERIAL TO LOCALIZE
			 };

//----------------------------------------------------------------
// RomanianDate - Default constructor (Same as EDate)
	public BioResource_ro() {
	}
/**
 * getContents method comment.
 */
protected java.lang.Object[][] getContents() {
	return m_contents;
}
}
