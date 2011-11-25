/*
 * Copyright © 2011 jbundle.org. All rights reserved.
 */
package org.jbundle.biorhythm.resources;

/**
 * Copyright (c) 1996 jbundle.org. All Rights Reserved.
 *	Copy freely, but don't sell this program or remove this copyright notice.
 *		Don_Corley@msn.com
 */

import java.util.*;

public class BioResource_es extends ListResourceBundle {
		static final Object[][] m_contents = {
			 // LOCALIZE THIS
			 		 {"Language", "Espa�ol"},
			 		 {"LanguageInEnglish", "Spanish"},
					 {"Biorhythm", "Biorhythm"},		// "Biorththm"
					 {"Birthdate", "Cumplea�os"},		// Input field labels
					 {"Start Date", "Empiezo"},
					 {"End Date", "Fin"},
					 {"Emotional Cycle", "Emoci�n Ciclo"},	// Cycle Descriptions
					 {"Physical Cycle", "F�sico Ciclo"},
					 {"Intellectual Cycle", "Intelectual Ciclo"},
					 {"Critical", "Cr�tica"},		// Critials/High/Low
					 {"High", "Alto"},
					 {"Low", "Bajo"},
					 {"EnterBirthdate", "Pon la fecha de tu Cumplea�os en el espacio indicado."},
			 // END OF MATERIAL TO LOCALIZE
			 };

//----------------------------------------------------------------
// HsilgneDate - Default constructor (Same as EDate)
	public BioResource_es() {
		super();
	}
/**
 * getContents method comment.
 */
protected java.lang.Object[][] getContents() {
	return m_contents;
}
}
