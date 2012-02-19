/*
 * Model.java
 *
 * Created on January 14, 2001, 12:39 AM
 
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package org.jbundle.util.biorhythm;

import java.util.Date;

import javax.swing.JPanel;

/** 
 * Controller - This is the biorhythm controller.
 * @author  Don Corley
 * @version 1.0
 */
public class Controller extends JPanel
	implements Constants
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
	protected Model m_model = null;

	protected Date m_dateStart = null;		// Start date in long form
	protected Date m_dateEnd = null;		// End date in long form
	/**
	 * The birthdate to analyze.
	 */
	protected Date m_dateBirth = null;

	/**
	 * Creates new Controller.
	 */
	public Controller()
	{
		super();
	}
	/**
	 * Creates new Controller.
	 */
	public Controller(Model model, Date dateBirth, Date dateStart, Date dateEnd)
	{
		this();
		this.init(model, dateBirth, dateStart, dateEnd);
	}
	/**
	 * Creates new Controller.
	 */
	public void init(Model model, Date dateBirth, Date dateStart, Date dateEnd)
	{
		this.setModel(model);
		this.setBirthdate(dateBirth);
		this.setStartDate(dateStart);
		this.setEndDate(dateEnd);
	}
	/**
	 * Sets the Model for this controller.
	 */
	public void setModel(Model model)
	{
		m_model = model;
	}
	/**
	 * Get the Model.
	 * @return The model this controller is linked to.
	 */
	public Model getModel()
	{
		return m_model;
	}
	/**
	 * Get the start date.
	 * @param dateStart The start date.
	 */
	public void setStartDate(Date dateStart)
	{
		m_dateStart = dateStart;
		this.getModel().getView().repaint();	// Update view
	}
	/**
	 * Get the start date.
	 * @return The start date.
	 */
	public Date getStartDate()
	{
		return m_dateStart;
	}
	/**
	 * Set the end date.
	 * @param dateEnd The end date
	 */
	public void setEndDate(Date dateEnd)
	{
		m_dateEnd = dateEnd;
		this.getModel().getView().repaint();	// Update view
	}
	/**
	 * Get the end date.
	 * @return The end date.
	 */
	public Date getEndDate()
	{
		return m_dateEnd;
	}
	/**
	 * Set the birthdate.
	 * @param dateBirth The birthdate to analyze.
	 */
	public void setBirthdate(Date dateBirth)
	{
		if (dateBirth == null)
			dateBirth = new Date();		// Default to today
		m_dateBirth = dateBirth;
		this.getModel().getView().repaint();	// Update view
	}
	/**
	 * Get the birthdate.
	 * @return The birthdate.
	 */
	public Date getBirthdate()
	{
		return m_dateBirth;
	}
}
