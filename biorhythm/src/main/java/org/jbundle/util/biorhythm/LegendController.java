/*
 * Copyright © 2011 jbundle.org. All rights reserved.
 */
package org.jbundle.util.biorhythm;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jbundle.util.jcalendarbutton.JCalendarButton;
import org.jbundle.util.jcalendarbutton.JTimeButton;

/**
 * LegendController - This is the biorhythm controller.
 */
public class LegendController extends Controller
	implements KeyListener, FocusListener, ActionListener, PropertyChangeListener
{
    private static final long serialVersionUID = 1L;
    
	public final static int DELAY_VALIDATE_MS = 2 * 1000;	// Delay in typing before validation

	protected JLabel m_labelBirthdate = null;
	protected JLabel m_labelStartDate = null;
	protected JLabel m_labelEndDate = null;

	protected JTextField m_tfBirthdate = null;
	protected JTextField m_tfStartDate = null;
	protected JTextField m_tfEndDate = null;
	
	protected String m_strLanguage = null;

	public static DateFormat m_df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	public static DateFormat m_dtf = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);

	/**
	 * Creates new Controller.
	 */
	public LegendController()
	{
		super();
	}
	/**
	 * Creates new Controller.
	 */
	public LegendController(Model model, Date dateBirth, Date dateStart, Date dateEnd)
	{
		this();
		this.init(model, dateBirth, dateStart, dateEnd);
	}
	/**
	 * Creates new Controller.
	 */
	public void init(Model model, Date dateBirth, Date dateStart, Date dateEnd)
	{
		super.init(model, dateBirth, dateStart, dateEnd);
		this.addComponents();
	}
	/**
	 * Set the label text.
	 */
	public void setComponentText()
	{
		String string = this.getResources().getString("Birthdate");
		m_labelBirthdate.setText(string);
		string = this.getResources().getString("Start Date");
		m_labelStartDate.setText(string);
		string = this.getResources().getString("End Date");
		m_labelEndDate.setText(string);
	}
	/**
	 * Initialize all the panel components.
	 */
	public void addComponents()
	{
		try {
			this.setOpaque(false);
			this.setLayout(new FlowLayout());
			String string = this.getResources().getString("Birthdate");
			this.add(m_labelBirthdate = new JLabel(string));
			this.add(this.getBirthdateTextField());
			JCalendarButton calendarButton = new JCalendarButton(BIRTHDATE_PARAM, this.getBirthdate(), this.getLanguage());
			this.add(calendarButton);
			calendarButton.addPropertyChangeListener(this);
			this.addPropertyChangeListener(calendarButton);
            JTimeButton timeButton = new JTimeButton(BIRTHDATE_PARAM, this.getBirthdate(), this.getLanguage());
            this.add(timeButton);
            timeButton.addPropertyChangeListener(this);
            this.addPropertyChangeListener(timeButton);
			
			string = this.getResources().getString("Start Date");
			this.add(m_labelStartDate = new JLabel(string));
			this.add(this.getStartDateTextField());
            calendarButton = new JCalendarButton(STARTDATE_PARAM, this.getStartDate(), this.getLanguage());
            this.add(calendarButton);
            calendarButton.addPropertyChangeListener(this);
            this.addPropertyChangeListener(calendarButton);
			
			string = this.getResources().getString("End Date");
			this.add(m_labelEndDate = new JLabel(string));
			this.add(this.getEndDateTextField());
			this.setOpaque(false);
			calendarButton = new JCalendarButton(ENDDATE_PARAM, this.getEndDate(), this.getLanguage());
			this.add(calendarButton);
			calendarButton.addPropertyChangeListener(this);
			this.addPropertyChangeListener(calendarButton);

			this.getBirthdateTextField().addKeyListener(this);
			this.getStartDateTextField().addKeyListener(this);
			this.getEndDateTextField().addKeyListener(this);
			this.getBirthdateTextField().addFocusListener(this);
			this.getStartDateTextField().addFocusListener(this);
			this.getEndDateTextField().addFocusListener(this);
			this.getBirthdateTextField().addActionListener(this);
			this.getStartDateTextField().addActionListener(this);
			this.getEndDateTextField().addActionListener(this);

		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	}
	/**
	 * Get the resource bundle.
	 * @return The resource bundle.
	 */
	public ResourceBundle getResources()
	{
		return this.getModel().getView().getResources();
	}
	/**
	 * Get the color to paint this wave.
	 * @param iCycleLength Type of cycle to paint.
	 * @return The color of the element.
	 */
	public Color getElementColor(int iCycleLength)
	{
		return this.getModel().getView().getElementColor(iCycleLength);
	}
	/**
	 * Called whenever the part throws an exception.
	 * @param exception java.lang.Throwable
	 */
	protected void handleException(Throwable exception)
	{
		 System.out.println(exception.getMessage());
		 exception.printStackTrace();
	}
	/**
	 * Return the TextField1 property value.
	 * @return java.awt.TextField
	 */
	public JTextField getBirthdateTextField()
	{
		if (m_tfBirthdate == null) {
			try {
				m_tfBirthdate = new JTextField(15);
			} catch (java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		};
		return m_tfBirthdate;
	}
	/**
	 * Return the TextField3 property value.
	 * @return java.awt.TextField
	 */
	public JTextField getEndDateTextField()
	{
		if (m_tfEndDate == null) {
			try {
				m_tfEndDate = new JTextField(10);
			} catch (java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		};
		return m_tfEndDate;
	}
	/**
	 * Set the birthdate using this text.
	 * @param strBirthdate The birthdate in standard system-parseable format.
	 */
	public void setTextBirthdate(String strBirthdate)
	{
		Date dateBirth = null;
		try	{
		if ((strBirthdate != null) && (strBirthdate.length() > 0))
			dateBirth = m_dtf.parse(strBirthdate);
		} catch (Exception e)	{
			try	{
				dateBirth = m_df.parse(strBirthdate);
				LegendView.gCalendar.setTime(dateBirth);
				LegendView.gCalendar.set(Calendar.HOUR_OF_DAY, 12);		// 12:00 noon
				LegendView.gCalendar.set(Calendar.MINUTE, 0);
				LegendView.gCalendar.set(Calendar.SECOND, 0);
				LegendView.gCalendar.set(Calendar.MILLISECOND, 0);
				dateBirth = LegendView.gCalendar.getTime();
			} catch (Exception e2)	{
			}		
		}
		if ((dateBirth == null) && (strBirthdate == null))
		{
			dateBirth = new Date();
		}
		if (dateBirth != null)
			this.setBirthdate(dateBirth);
	}
	/**
	 * Set the birthdate.
	 * @param dateBirth The birthdate.
	 */
	public void setBirthdate(Date dateBirth)
	{
		Date oldDate = m_dateBirth;
		if (dateBirth == null)
			this.setTextBirthdate(null);
		else
			super.setBirthdate(dateBirth);
		this.getBirthdateTextField().setText(m_dtf.format(this.getBirthdate()));
		if (m_dateBirth != null)
			if (!m_dateBirth.equals(oldDate))
				this.firePropertyChange(BIRTHDATE_PARAM, oldDate, m_dateBirth);
	}
	/**
	 * Set the start date using this text.
	 * @param strStartDate the start date.
	 */
	public void setTextStartDate(String strStartDate)
	{
		Date dateStart = null;
		try	{
			if ((strStartDate != null) && (strStartDate.length() > 0))
				dateStart = m_df.parse(strStartDate);
		} catch (ParseException ex)	{
			dateStart = null;
		}
		if ((dateStart == null) && (strStartDate == null))
		{
			dateStart = new Date();
			LegendView.gCalendar.setTime(dateStart);
			LegendView.gCalendar.set(Calendar.DAY_OF_MONTH, 1);	// First day of month
			dateStart = LegendView.gCalendar.getTime();
		}
		if (dateStart != null)
		{
			LegendView.gCalendar.setTime(dateStart);
			LegendView.gCalendar.set(Calendar.HOUR_OF_DAY, 0);
			LegendView.gCalendar.set(Calendar.MINUTE, 0);
			LegendView.gCalendar.set(Calendar.SECOND, 0);
			LegendView.gCalendar.set(Calendar.MILLISECOND, 0);
			dateStart = LegendView.gCalendar.getTime();
			this.setStartDate(dateStart);
		}
	}
	/**
	 * Set the end date using this text.
	 * @param strEndDate the end date.
	 */
	public void setTextEndDate(String strEndDate)
	{
		Date dateEnd = null;
		try	{
			if ((strEndDate != null) && (strEndDate.length() > 0))
				dateEnd = m_df.parse(strEndDate);
		} catch (ParseException ex)	{
			dateEnd = null;
		}
		if ((dateEnd == null) && (strEndDate == null))
		{
			dateEnd = this.getStartDate();
			if (dateEnd == null)
				dateEnd = new Date();

			LegendView.gCalendar.setTime(dateEnd);
			LegendView.gCalendar.set(Calendar.DAY_OF_MONTH, 1);	// First day of month
			dateEnd = LegendView.gCalendar.getTime();
			LegendView.gCalendar.add(Calendar.MONTH, +1);
			dateEnd = LegendView.gCalendar.getTime();	// Force compute
			LegendView.gCalendar.add(Calendar.DATE, -1);	// Last day of month
			dateEnd = LegendView.gCalendar.getTime();
		}
		if (dateEnd != null)
		{
			LegendView.gCalendar.setTime(dateEnd);
			LegendView.gCalendar.set(Calendar.HOUR_OF_DAY, 23);
			LegendView.gCalendar.set(Calendar.MINUTE, 59);
			LegendView.gCalendar.set(Calendar.SECOND, 59);
			LegendView.gCalendar.set(Calendar.MILLISECOND, 0);
			dateEnd = LegendView.gCalendar.getTime();
			this.setEndDate(dateEnd);
		}
	}
	/**
	 * Set the start date.
	 * @param dateStart The start date.
	 */
	public void setStartDate(Date dateStart)
	{
		Date oldDate = m_dateStart;
		if (dateStart == null)
			this.setTextStartDate(null);
		else
			super.setStartDate(dateStart);
		this.getStartDateTextField().setText(m_df.format(this.getStartDate()));
		if (m_dateStart != null)
			if (!m_dateStart.equals(oldDate))
				this.firePropertyChange(STARTDATE_PARAM, oldDate, m_dateStart);
	}
	/**
	 * Set the end date.
	 * @param dateEnd The end date.
	 */
	public void setEndDate(Date dateEnd)
	{
		Date oldDate = m_dateEnd;
		if (dateEnd == null)
			this.setTextEndDate(null);
		else
			super.setEndDate(dateEnd);
		this.getEndDateTextField().setText(m_df.format(this.getEndDate()));
		if (m_dateEnd != null)
			if (!m_dateEnd.equals(oldDate))
				this.firePropertyChange(ENDDATE_PARAM, oldDate, m_dateEnd);
	}
	/**
	 * Return the TextField2 property value.
	 * @return java.awt.TextField The start date text field.
	 */
	public JTextField getStartDateTextField()
	{
		if (m_tfStartDate == null) {
			try {
				m_tfStartDate = new JTextField(10);
			} catch (java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		};
		return m_tfStartDate;
	}
	/**
	 * Set the Language.
	 * @param strLanguage The language.
	 */
	public void setLanguage(String strLanguage)
	{
		String oldLanguage = m_strLanguage;
		((LegendView)this.getModel().getView()).setLanguage(strLanguage);
		if (strLanguage != null)
			if (!strLanguage.equals(oldLanguage))
		{
				this.firePropertyChange(LANGUAGE_PARAM, oldLanguage, strLanguage);
		}
		m_strLanguage = strLanguage;
	}
	/**
	 * Get the language.
	 * @return the language.
	 */
	public String getLanguage()
	{
		return m_strLanguage;
	}
	/**
	 * Empty method Required for the key listener.
	 */
	public void keyPressed(KeyEvent evt)
	{
	}
	/**
	 * Key released.
	 */
	public void keyReleased(KeyEvent evt) 
	{
		if (evt.getKeyChar() != KeyEvent.CHAR_UNDEFINED)
			this.startTimer(evt.getSource());
		else
		{	// If there is a timer running - extend it
			if (m_timer != null)
				if (m_timer.isRunning())
					m_timer.restart();
		}
	}
	/**
	 * Character typed.
	 */
	public void keyTyped(KeyEvent evt) 
	{
	}
	/**
	 * Input focus gained.
	 */
	public void focusGained(final java.awt.event.FocusEvent evt)
	{
	}
	/**
	 * Input focus lost.
	 */
	public void focusLost(final java.awt.event.FocusEvent evt)
	{
		this.parseField(evt.getSource());
	}
	/**
	 * Action performed.
	 */
	public void actionPerformed(final java.awt.event.ActionEvent evt)
	{
		if (evt.getSource() == m_timer)
			this.parseField(m_objTimerTarget);
		else
			this.parseField(evt.getSource());
	}
	protected javax.swing.Timer m_timer = null;
	protected Object m_objTimerTarget = null;
	/**
	 * Wait one second, then validate this field.
	 */
	public void startTimer(Object srcField)
	{
		if (m_timer == null)
		{
			m_timer = new javax.swing.Timer(DELAY_VALIDATE_MS, this);
			m_timer.setRepeats(false);
		}
		else
			m_timer.restart();
		synchronized (this)
		{
			m_objTimerTarget = srcField;
		}
	}
	/**
	 * Parse this target date field.
	 */
	public void parseField(Object srcField) 
	{
		synchronized (this)
		{
			m_objTimerTarget = null;	// Turn the timer off
		}
		if ((srcField == getBirthdateTextField()) ) {
			this.setTextBirthdate(this.getBirthdateTextField().getText());
		}
		if ((srcField == getStartDateTextField()) ) {
			this.setTextStartDate(this.getStartDateTextField().getText());
		}
		if ((srcField == getEndDateTextField()) ) {
			this.setTextEndDate(this.getEndDateTextField().getText());
		}
	}
	/**
	 * A propery changed, change the corresponding variable.
	 */
	public void propertyChange(final java.beans.PropertyChangeEvent evt)
	{
		if (evt.getNewValue() instanceof Date)
		{
			if (BIRTHDATE_PARAM.equalsIgnoreCase(evt.getPropertyName()))
				this.setBirthdate((Date)evt.getNewValue());
			if (STARTDATE_PARAM.equalsIgnoreCase(evt.getPropertyName()))
				this.setStartDate((Date)evt.getNewValue());
			if (ENDDATE_PARAM.equalsIgnoreCase(evt.getPropertyName()))
				this.setEndDate((Date)evt.getNewValue());
		}
//		else if (LANGUAGE_PARAM.equals(evt.getPropertyName()))
//		{
//			this.setLanguage((String)evt.getNewValue());
//		}
	}
	/**
	 * The standard property change manager.
	 */
	protected PropertyChangeSupport propertyManager = new PropertyChangeSupport(this);
	/**
	 * Add a new listener.
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		propertyManager.addPropertyChangeListener(listener);
	}
	/**
	 * Add a new listener.
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener)
	{
		propertyManager.removePropertyChangeListener(listener);
	}
	/**
	 * Fire the property change.
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue)
	{
		if (propertyManager != null)
			propertyManager.firePropertyChange(propertyName, oldValue, newValue);
	}

}
