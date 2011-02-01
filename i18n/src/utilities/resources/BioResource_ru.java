package org.jbundle.biorhythm.resources;

/*
 * Copyright (c) 1996 jbundle.org. All Rights Reserved.
 *	Copy freely, but don't sell this program or remove this copyright notice.
 *		Don_Corley@msn.com
 */

import java.util.*;

public class BioResource_ru extends ListResourceBundle {
		static final Object[][] m_contents = {
			 // LOCALIZE THIS
// Andrew Zubriy
// zubr@biocon.kiev.ua
			 		 {"Language", "\u0420\u0443\u0441\u0441\u043A\u0438\u0439"},
			 		 {"LanguageInEnglish", "Russian"},
					 {"Biorhythm", "\u0411\u0438\u043E\u0440\u0438\u0442\u043C"},		// "Biorththm"
					 {"Birthdate", "\u0414\u0430\u0442\u0430 \u0440\u043E\u0436\u0434\u0435\u043D\u0438\u044F"},		// Input field labels
					 {"Start Date", "\u041D\u0430\u0447\u0430\u043B\u043E"},
					 {"End Date", "\u041A\u043E\u043D\u0435\u0446"},
					 {"Emotional Cycle", "\u042D\u043C\u043E\u0446\u0438\u043E\u043D\u0430\u043B\u044C\u043D\u044B\u0439 \u0446\u0438\u043A\u043B"},	// Cycle Descriptions
					 {"Physical Cycle", "\u0424\u0438\u0437\u0438\u0447\u0435\u0441\u043A\u0438\u0439 \u0446\u0438\u043A\u043B"},
					 {"Intellectual Cycle", "\u0418\u043D\u0442\u0435\u043B\u043B\u0435\u043A\u0442\u0443\u0430\u043B\u044C\u043D\u044B\u0439 \u0446\u0438\u043A\u043B"},
					 {"Critical", "\u041A\u0440\u0438\u0442\u0438\u0447\u0435\u0441\u043A\u0438\u0439"},		// Critials/High/Low
					 {"High", "\u0412\u044B\u0441\u043E\u043A\u043E"},
					 {"Low", "\u041D\u0438\u0437\u043A\u043E"},
					 {"EnterBirthdate", "\u0412\u0432\u0432\u0435\u0434\u0438\u0442\u0435 \u0434\u0430\u0442\u0443 \u0432\u0430\u0448\u0435\u0433\u043E \u0440\u043E\u0436\u0434\u0435\u043D\u0438\u044F \u0432 \u0441\u043E\u043E\u0442\u0432\u0435\u0442\u0441\u0442\u0432\u0443\u044E\u0449\u0435\u0435 \u043F\u043E\u043B\u0435."},
			 // END OF MATERIAL TO LOCALIZE
			 };

//----------------------------------------------------------------
// HsilgneDate - Default constructor (Same as EDate)
	public BioResource_ru() {
		super();
	}
/**
 * getContents method comment.
 */
protected java.lang.Object[][] getContents() {
	return m_contents;
}
}
