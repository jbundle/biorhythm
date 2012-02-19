/*
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package org.jbundle.util.biorhythm.resources;

/*
* Copyright © 2012 jbundle.org. All Rights Reserved.
*	Copy freely, but don't sell this program or remove this copyright notice.
*		Don_Corley@msn.com
*/

import java.util.*;

public class BioResource_no extends ListResourceBundle {

static final Object[][] m_contents = {

// LOCALIZE THIS
		 {"Language", "Norsk"},
		 {"LanguageInEnglish", "Norwegian"},
{"Biorhythm", "Biorhythm"},		// "Biorththm"
{"Birthdate", "Fdselsdato"},		// Input field labels
{"Start Date", "Start"},
{"End Date", "Slutt"},
{"Emotional Cycle", "Flelsesmessig Syklus"},	// Cycle Descriptions
{"Physical Cycle", "Fysisk Syklus"},
{"Intellectual Cycle", "Intellektuell Syklus"},
{"Critical", "Kritisk"},		// Critials/High/Low
{"High", "Hy"},
{"Low", "Lav"},
{"EnterBirthdate", "Skriv inn til fdselsdato i riktig felt."},

// END OF MATERIAL TO LOCALIZE
};

//---------------------------------------------------------------- 

//NorwegianDate - Default constructor (Same as EDate)

public BioResource_no() {
}

/**
* getContents method comment.
*/

protected java.lang.Object[][] getContents() {
return m_contents;
}

}
