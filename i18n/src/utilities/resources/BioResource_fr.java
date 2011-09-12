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

public class BioResource_fr extends ListResourceBundle {
		static final Object[][] m_contents = {
			 // LOCALIZE THIS
			 		 {"Language", "Fran�ais"},
			 		 {"LanguageInEnglish", "French"},
					 {"Biorhythm", "Biorhythm"},		// "Biorththm"
					 {"Birthdate", "Anniversaire"},		// Input field labels
					 {"Start Date", "Du"},
					 {"End Date", "Au"},
					 {"Emotional Cycle", "Cycle Emotionnel"},	// Cycle Descriptions
					 {"Physical Cycle", "Cycle Physique"},
					 {"Intellectual Cycle", "Cycle Intellectuel"},
					 {"Critical", "Critique"},		// Critials/High/Low
					 {"High", "Haut"},
					 {"Low", "Bas"},
					 {"EnterBirthdate", "Entrez votre date de naissance dans le champ Anniversaire."},
			 // END OF MATERIAL TO LOCALIZE
			 };

//----------------------------------------------------------------
// HsilgneDate - Default constructor (Same as EDate)
	public BioResource_fr() {
	}
/**
 * getContents method comment.
 */
protected java.lang.Object[][] getContents() {
	return m_contents;
}
}
