package org.jbundle.util.biorhythm.resources;

/*
 * Copyright (c) 1996 jbundle.org. All Rights Reserved.
 *	Copy freely, but don't sell this program or remove this copyright notice.
 *		Don_Corley@msn.com
 */

import java.util.*;

public class BioResource_pt extends ListResourceBundle {
		static final Object[][] m_contents = {
			 // LOCALIZE THIS
			 		 {"Language", "Português"},
			 		 {"LanguageInEnglish", "Portuguese"},
					 {"Biorhythm", "Biorhythm"},		// "Biorththm"
					 {"Birthdate", "Nascimento"},		// Input field labels
					 {"Start Date", "Iniciar"},
					 {"End Date", "Encerrar"},
					 {"Emotional Cycle", "Ciclo Emocional"},	// Cycle Descriptions
					 {"Physical Cycle", "Ciclo Físico"},
					 {"Intellectual Cycle", "Ciclo Intelectual"},
					 {"Critical", "Crítico"},		// Critials/High/Low
					 {"High", "Alto"},
					 {"Low", "Baixo"},
					 {"EnterBirthdate", "Entre sua data de nascimento no campo Nascimento."},
			 // END OF MATERIAL TO LOCALIZE
			 };

//----------------------------------------------------------------
// PortugueseDate - Default constructor (Same as EDate)
	public BioResource_pt() {
	}
/**
 * getContents method comment.
 */
protected java.lang.Object[][] getContents() {
	return m_contents;
}
}