/*
 * LegendView.java
 *
 * Created on January 14, 2001, 12:39 AM
 
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package org.jbundle.util.biorhythm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/** 
 * LegendView - This is the biorhythm view.
 * @author  Don Corley
 * @version 1.0
 */
public class LegendView extends View
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
	/**
	 * The resource bundle used to translate information for this view.
	 */
	public static ResourceBundle m_resources = null;	// Current resource bundle
	public static Calendar gCalendar = Calendar.getInstance();

	/**
	 * Creates new View.
	 */
	public LegendView()
	{
		super();
	}
	/**
	 * Creates new View.
	 * Remember to set the background color after insatiating this object.
	 * @param controller Controller that this view is connected to.
	 */
	public LegendView(Controller controller)
	{
		this();
		this.init(controller);
	}
	/**
	 * Creates new View.
	 * @param controller Controller that this view is connected to.
	 */
	public void init(Controller controller)
	{
		super.init(controller);

		this.setPreferredSize(new Dimension(300, 300));

		Locale currentLocale = Locale.getDefault();
        String strBundleName = this.getResourceName();
		m_resources = ResourceBundle.getBundle(strBundleName, currentLocale);
	}
	/**
	 * Paint this portion of the panel (overidden from awt).
	 * @param g Graphics object to paint to.
	 */
	public void paint(Graphics g)
	{
		this.drawHorizontals(g);
		this.drawVerticals(g);
		super.paint(g);
		this.drawLegend(g);
	}
	/**
	 * Draw the horizontal lines every 10 pixels.
	 * @param g Graphics object to paint to.
	 */
	public void drawHorizontals(Graphics g)
	{
		Rectangle r = this.getBounds();
		Color colorBack = this.getElementColor(BACKGROUND);
		if (colorBack != null)
		{
			g.setColor(colorBack);
			g.fillRect(0, 0, r.width, r.height);
		}
		g.setColor(this.getElementColor(GRID));
		for (int i = r.height / 2; i >= 0; i = i - 10) {
			g.drawLine(0, i, r.width, i);
		}
		for (int i = r.height / 2; i <= r.height; i = i + 10) {
			g.drawLine(0, i, r.width, i);
		}
		g.setColor(this.getElementColor(BASELINE));
		g.drawLine(0, r.height / 2, r.width, r.height / 2);
	}
	/**
	 * Draw the vertical lines at every day break.
	 * @param g Graphics object to paint to.
	 */
	public void drawVerticals(Graphics g)
	{
		Color colorGrid = this.getElementColor(GRID);
		Color colorDate = this.getElementColor(DATE);
		long lTimeX = this.convertXtoTime(1) - this.convertXtoTime(0);
		int iDayOffsetX = 0;
		if (lTimeX != 0)
			iDayOffsetX = (int)(ONE_DAY_MS / lTimeX);	// Width of one day (in pixels)
		int iDay = 0;
		int iNextDay = 0;
		int iStartDayX = -11;
		Date date = new Date();
		long lNow = date.getTime();
		int xNow = -1;
		Rectangle rect = this.getBounds();
		for (int x = -1; x < rect.width; x++)
		{
			iNextDay = iDay;	// Last day
			long time = this.convertXtoTime(x);
			if (time < lNow)
				xNow = x;				// Figure out the x value for now
			date.setTime(time);
			gCalendar.setTime(date);
			iDay = gCalendar.get(Calendar.DAY_OF_MONTH);
			if (x >= 0) if (iDay != iNextDay)
			{		// Different day then last position, draw a vertical line
				g.setColor(colorGrid);
				g.drawLine(x, 0, x, rect.height);
				if (x - iStartDayX > 10)
				{	// Put the day in the middle of the box
					g.setColor(colorDate);
					String strDate = Integer.toString(iDay);
					int istringWidth = g.getFontMetrics().stringWidth(strDate);
					int sx = x + (iDayOffsetX - istringWidth) / 2;
					int sy = 12;
			    g.drawString(strDate, sx, sy); 
					iStartDayX = x;
				}
			}
		}
		// Now draw the vertical that represents today
		g.setColor(this.getElementColor(TODAY));
		if  (xNow > -1) if (xNow < rect.width - 1)
			g.drawLine(xNow, 0, xNow, rect.height);
	}
	/**
	 * Draw the legend.
	 */
	public void drawLegend(Graphics g)
	{
		FontMetrics fm = g.getFontMetrics();
		Rectangle r = this.getBounds();
		g.setColor(this.getElementColor(PHYSICAL_CYCLE));
		int sx = 10;
		int sy = r.height - 7;
		g.drawLine(sx, sy, sx+20, sy);
		String string = this.getResources().getString("Physical Cycle");
		g.drawString(string, sx+25, sy+5); 

		g.setColor(this.getElementColor(EMOTIONAL_CYCLE));
		string = this.getResources().getString("Emotional Cycle");
		int iWidth = fm.stringWidth(string);
		sx = (r.width - iWidth - 20) / 2;
		g.drawLine(sx, sy, sx+20, sy);
		g.drawString(string, sx+25, sy+5); 

		g.setColor(this.getElementColor(INTELLECTUAL_CYCLE));
		string = this.getResources().getString("Intellectual Cycle");
		iWidth = fm.stringWidth(string);
		sx = r.width - 30 - iWidth;
		g.drawLine(sx, sy, sx+20, sy);
		g.drawString(string, sx+25, sy+5); 
	}
	/**
	 * Draw a line from x to x+1 on the canvas.
	 * @param g Graphics object to paint to.
	 * @param x x value to use to compute the Y value
	 * @param iCycleLength Length of the cycle to compute
	 */
	public void drawGraphLine(Graphics g, int x, int iCycleLength)
	{
		super.drawGraphLine(g, x, iCycleLength);
		this.drawTickmarks(g, x, iCycleLength);
	}
	/**
	 * If x is at a minimum, maximum, or critical point, draw the tickmark and the day.
	 * @param g Graphics object to paint to.
	 * @param x x value to use to compute the Y value
	 * @param iCycleLength Length of the cycle to compute
	 */
	public void drawTickmarks(Graphics g, int x, int iCycleLength)
	{
		int iTrend = 0;

		double dXGraphYValue = this.getController().getModel().convertTimeToStrength(this.convertXtoTime(x), iCycleLength);
		double dXNextGraphYValue = this.getController().getModel().convertTimeToStrength(this.convertXtoTime(x+1), iCycleLength);
		if (((dXGraphYValue >= 0) && (dXNextGraphYValue < 0))
			|| ((dXGraphYValue <= 0) && (dXNextGraphYValue > 0)))
				this.drawThisTickmark(g, x, iCycleLength, iTrend);
		if (x != 0)
		{
			double dXLastGraphYValue = this.getController().getModel().convertTimeToStrength(this.convertXtoTime(x-1), iCycleLength);
			if (dXLastGraphYValue < dXGraphYValue)
				iTrend = -1;
			else
				iTrend = +1;
			if (dXGraphYValue < dXNextGraphYValue)
			{
				if (iTrend == +1)
					this.drawThisTickmark(g, x, iCycleLength, iTrend);
			}
			else
			{
				if (iTrend == -1)
					this.drawThisTickmark(g, x, iCycleLength, iTrend);
			}
		}
   }                                                                           
	/**
	 * Draw the tickmark at this location.
	 * @param g Graphics object to paint to.
	 * @param x x value to use to compute the Y value
	 * @param iCycleLength Length of the cycle to compute
	 * @param iTrend is the cycle heading up (+1) or down (-1).
	 */
	public void drawThisTickmark(Graphics g, int x, int iCycleLength, int iTrend)
	{
		int sy = convertXtoY(x, iCycleLength);
		g.drawLine(x, sy - 4, x, sy + 4);
		if (iTrend == -1)
			sy -= 5;
		else
			sy += 14;
		Date dateAtMark = new Date(this.convertXtoTime(x));
		gCalendar.setTime(dateAtMark);
		int iDay = gCalendar.get(Calendar.DAY_OF_MONTH);
		String strDate = Integer.toString(iDay);
		int istringWidth = g.getFontMetrics().stringWidth(strDate);
		int sx = x - istringWidth / 2;
		g.drawString(strDate, sx, sy);
	}
	/**
	 * Get the color to paint this wave.
	 * @param iCycleLength Type of cycle to paint.
	 * @return The color of the element.
	 */
	public Color getElementColor(int iCycleLength)
	{
		return super.getElementColor(iCycleLength);
	}
	/**
	 * Get the resource bundle.
	 * @return Local string resources.
	 */
	public ResourceBundle getResources()
	{
		return m_resources;
	}
	/**
	 * Sets the language property (java.lang.String) value.
	 * @param language The new value for the property.
	 */
	public void setLanguage(String language)
	{
		Locale currentLocale = Locale.getDefault();
	//	if (language != null) if (language.length() > 2) if (language.indexOf('_') == -1)
	//		language = BioPanel.findLocaleFromLanguage(language);
		if (language != null)
		{
			currentLocale = new Locale(language, "");
//x			Locale.setDefault(currentLocale);
		}
		
		String strBundleName = this.getResourceName();
		m_resources = ResourceBundle.getBundle(strBundleName, currentLocale);
		LegendController.m_df = DateFormat.getDateInstance(DateFormat.MEDIUM, currentLocale);
		LegendController.m_dtf = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT, currentLocale);
		Controller controller = this.getController();
		((LegendController)this.getController()).setComponentText();
		controller.setBirthdate(controller.getBirthdate());
		controller.setStartDate(controller.getStartDate());
		controller.setEndDate(controller.getEndDate());
		this.invalidate();
		this.validate();
		this.repaint();
	}
	/**
	 * Get the resource bundle class name.
	 * @return The class name.
	 */
	public String getResourceName()
	{
        String strBundleName = this.getClass().getName();
        strBundleName = strBundleName.substring(0, strBundleName.lastIndexOf('.') + 1) + "resources.BioResource";
        return strBundleName;	    
	}
}
