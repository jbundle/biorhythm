package org.jbundle.biorhythm.resources;

/**
 * Copyright (c) 1996 jbundle.org. All Rights Reserved.
 *	Copy freely, but don't sell this program or remove this copyright notice.
 *		Don_Corley@msn.com
 */

import java.util.*;

public class BioResource_hu extends ListResourceBundle {
		static final Object[][] m_contents = {
			 // LOCALIZE THIS
// Farsang Istv�n
// istvan.farsang@intl.pepsi.com
			 		 {"Language", "Magyar"},
			 		 {"LanguageInEnglish", "Hungarian"},
					 {"Biorhythm", "Bioritmus"},		// "Biorththm"
					 {"Birthdate", "Sz�let�snap"},		// Input field labels
					 {"Start Date", "Kezdo d�tum"},
					 {"End Date", "V�gd�tum"},
					 {"Emotional Cycle", "�rzelmi ciklus"},	// Cycle Descriptions
					 {"Physical Cycle", "Fizikai ciklus"},
					 {"Intellectual Cycle", "�rtelmi ciklus"},
					 {"Critical", "Kritikus nap"},		// Critials/High/Low
					 {"High", "Cs�cspont"},
					 {"Low", "M�lypont"},
					 {"EnterBirthdate", "K�rem a sz�let�snapodat a Sz�let�snap mezobe"},
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