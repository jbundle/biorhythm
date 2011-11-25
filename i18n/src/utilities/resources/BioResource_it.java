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

public class BioResource_it extends ListResourceBundle {
		static final Object[][] m_contents = {
			 // LOCALIZE THIS
			 		 {"Language", "Italian"},
			 		 {"LanguageInEnglish", "Italiano"},
					 {"Biorhythm", "bioritmo"},		// "Biorththm"
					 {"Birthdate", "data di nascita"},		// Input field labels
					 {"Start Date", "inizio"},
					 {"End Date", "fine"},
					 {"Emotional Cycle", "ciclo emozionale"},	// Cycle Descriptions
					 {"Physical Cycle", "Physical Cycle"},
					 {"Intellectual Cycle", "Intellectual Cycle"},
					 {"Critical", "Critical"},		// Critials/High/Low
					 {"High", "High"},
					 {"Low", "Low"},
					 {"EnterBirthdate", "Enter your birthdate in the Birthdate field."},
			 // END OF MATERIAL TO LOCALIZE
			 };

//----------------------------------------------------------------
// HsilgneDate - Default constructor (Same as EDate)
	public BioResource_it() {
		super();
	}
/**
 * getContents method comment.
 */
protected java.lang.Object[][] getContents() {
	return m_contents;
}
}
