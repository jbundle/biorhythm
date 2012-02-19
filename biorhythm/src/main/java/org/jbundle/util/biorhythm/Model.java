/*
 * Model.java
 *
 * Created on January 14, 2001, 12:39 AM
 
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package org.jbundle.util.biorhythm;


/** 
 * Model - This is the biorhythm model.
 * @author  Don Corley
 * @version 1.0
 */
public class Model extends Object
	implements Constants
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
	/**
	 * The view to associate with this model.
	 */
	protected View m_view = null;
	/**
	 * Creates new Model.
	 */
	public Model()
	{
		super();
	}
	/**
	 * Creates new Model.
	 * @param view The view to associate with this model.
	 * @params dateBirth The birthdate to analyze.
	 */
	public Model(View view)
	{
		this();
		this.init(view);
	}
	/**
	 * Creates new Model.
	 * @param view The view to associate with this model.
	 * @params dateBirth The birthdate to analyze.
	 */
	public void init(View view)
	{
		this.setView(view);
	}
	/**
	 * Set the view.
	 * @param view The view to associate with this model.
	 */
	public void setView(View view)
	{
		m_view = view;
	}
	/**
	 * Set the view.
	 * @param view The view to associate with this model.
	 */
	public View getView()
	{
		return m_view;
	}
	/**
	 * Convert this date value to a strength value between -1.0000 and +1.0000.
	 * @param dateToConvert The time to convert (from date.getTime()).
	 * @param iCycleLength The cycle length to convert.
	 */
	public double convertTimeToStrength(long dateToConvert, int iCycleLength)
	{
// First, convert x to the strength of the Biorhythm
		long lBirthTime = this.getView().getController().getBirthdate().getTime();
		double dTimeChange = dateToConvert - lBirthTime;	// milliseconds since their birthdate
		dTimeChange = dTimeChange / ONE_DAY_MS;				// In days
		double dCyclesCompleted = dTimeChange / iCycleLength;
		double dPercentThroughCycle = dCyclesCompleted - Math.floor(dCyclesCompleted);	// Generate a number 0 - .99
// Now, Convert the strength to radians
		double dRadians = dPercentThroughCycle * Math.PI * 2;
// Now, Convert to a sin wave (0->1->0->-1->0)
		double dValue = Math.sin(dRadians);
		return dValue;
	}
}
