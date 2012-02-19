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

public class BioResource_es extends ListResourceBundle {
		static final Object[][] m_contents = {
			 // LOCALIZE THIS
			 		 {"Language", "Español"},
			 		 {"LanguageInEnglish", "Spanish"},
					 {"Biorhythm", "Biorhythm"},		// "Biorhththm"
					 {"Birthdate", "Cumpleaños"},		// Input field labels
					 {"Start Date", "Empiezo"},
					 {"End Date", "Fin"},
					 {"Emotional Cycle", "Emoción Ciclo"},	// Cycle Descriptions
					 {"Physical Cycle", "Físico Ciclo"},
					 {"Intellectual Cycle", "Intelectual Ciclo"},
					 {"Critical", "Crítica"},		// Criticals/High/Low
					 {"High", "Alto"},
					 {"Low", "Bajo"},
					 {"EnterBirthdate", "Pon la fecha de tu Cumpleaños en el espacio indicado."},
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
