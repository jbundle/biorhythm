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

public class BioResource_ru extends ListResourceBundle {
		static final Object[][] m_contents = {
			 // LOCALIZE THIS
// Andrew Zubriy
// zubr@biocon.kiev.ua
			 		 {"Language", "Русский"},
			 		 {"LanguageInEnglish", "Russian"},
					 {"Biorhythm", "Биоритм"},		// "Biorththm"
					 {"Birthdate", "Дата рождения"},		// Input field labels
					 {"Start Date", "Начало"},
					 {"End Date", "Конец"},
					 {"Emotional Cycle", "Эмоциональный цикл"},	// Cycle Descriptions
					 {"Physical Cycle", "Физический цикл"},
					 {"Intellectual Cycle", "Интеллектуальный цикл"},
					 {"Critical", "Критический"},		// Critials/High/Low
					 {"High", "Высоко"},
					 {"Low", "Низко"},
					 {"EnterBirthdate", "Ввведите дату вашего рождения в соответствующее поле."},
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
