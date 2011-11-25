/*
 * Constants.java
 *
 * Created on January 14, 2001, 12:39 AM
 
 * Copyright © 2011 jbundle.org. All rights reserved.
 */
package org.jbundle.util.biorhythm;

/** 
 * Constants - These are the constants for the Biorhythm program.
 * @author  Don Corley
 * @version 1.0
 */
public interface Constants
{
	public static final int PHYSICAL_CYCLE = 23;		// Length of cycle in days
	public static final int EMOTIONAL_CYCLE = 28;
	public static final int INTELLECTUAL_CYCLE = 33;

	public static final int BACKGROUND = -1;			// Constants used to set elements
	public static final int GRID = -2;
	public static final int BASELINE = -3;
	public static final int DATE = -4;
	public static final int TODAY = -5;

	public static final long ONE_DAY_MS = 24 * 60 * 60 * 1000;	// One day (in milliseconds)
	public static final String TOKENS = "=\"";

	public final static String BIRTHDATE_PARAM = "birthdate";
	public final static String STARTDATE_PARAM = "startDate";
	public final static String ENDDATE_PARAM = "endDate";
	public final static String LANGUAGE_PARAM = "language";
}
