/*
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package org.jbundle.util.biorhythm.resources;

/**
 * Copyright © 2012 jbundle.org. All Rights Reserved.
 *	Copy freely, but don't sell this program or remove this copyright notice.
 *		Don_Corley@msn.com
 */

import java.util.*;

public class BioResource_hu extends ListResourceBundle {
		static final Object[][] m_contents = {
			 // LOCALIZE THIS
// Farsang István
// istvan.farsang@intl.pepsi.com
			 		 {"Language", "Magyar"},
			 		 {"LanguageInEnglish", "Hungarian"},
					 {"Biorhythm", "Bioritmus"},		// "Biorththm"
					 {"Birthdate", "Születésnap"},		// Input field labels
					 {"Start Date", "Kezdo dátum"},
					 {"End Date", "Végdátum"},
					 {"Emotional Cycle", "Érzelmi ciklus"},	// Cycle Descriptions
					 {"Physical Cycle", "Fizikai ciklus"},
					 {"Intellectual Cycle", "Értelmi ciklus"},
					 {"Critical", "Kritikus nap"},		// Critials/High/Low
					 {"High", "Csúcspont"},
					 {"Low", "Mélypont"},
					 {"EnterBirthdate", "Kérem a születésnapodat a Születésnap mezobe"},
			 // END OF MATERIAL TO LOCALIZE
			 };

//----------------------------------------------------------------
// HsilgneDate - Default constructor (Same as EDate)
	public BioResource_hu() {
		super();
	}
/**
 * getContents method comment.
 */
protected java.lang.Object[][] getContents() {
	return m_contents;
}
}
