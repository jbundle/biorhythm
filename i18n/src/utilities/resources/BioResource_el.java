package org.jbundle.biorhythm.resources;

/**
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
 		 {"Language", "\u0395\u039B\u039B\u0397\u039D\u0399\u039A\u0391 (HELLINIKA)"},
			 		 {"LanguageInEnglish", "Greek"},
					 {"Biorhythm", "\u0392\u0399\u039F\u03A1\u03A1\u03A5\u0398\u039C\u039F\u0399"},		// "Biorththm"
					 {"Birthdate", "\u0397\u039C\u0395\u03A1\u039F\u039C\u0397\u039D\u0399\u0391 \u0393\u0395\u039D\u039D\u0397\u03A3\u0397\u03A3"},		// Input field labels
					 {"Start Date", "\u0395\u039D\u0391\u03A1\u039E\u0397"},
					 {"End Date", "\u03A4\u0395\u039B\u039F\u03A3"},
					 {"Emotional Cycle", "\u03A3\u03A5\u039D\u0391\u0399\u03A3\u0398\u0397\u039C\u0391\u03A4\u0399\u039A\u039F\u03A3 \u039A\u03A5\u039A\u039B\u039F\u03A3"},	// Cycle Descriptions
					 {"Physical Cycle", "\u03A6\u03A5\u03A3\u0399\u039A\u039F\u03A3 \u039A\u03A5\u039A\u039B\u039F\u03A3"},
					 {"Intellectual Cycle", "\u03A0\u039D\u0395\u03A5\u039C\u0391\u03A4\u0399\u039A\u039F\u03A3 \u039A\u03A5\u039A\u039B\u039F\u03A3"},
					 {"Critical", "\u039A\u03A1\u0399\u03A3\u0399\u039C\u039F\u03A3"},		// Critials/High/Low
					 {"High", "\u03A5\u03A8\u0397\u039B\u039F\u03A3"},
					 {"Low", "\u03A7\u0391\u039C\u0397\u039B\u039F\u03A3"},
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
