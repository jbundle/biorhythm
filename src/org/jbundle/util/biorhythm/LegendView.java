/*
 * LegendView.java
 *
 * Created on January 14, 2001, 12:39 AM
 
 * Copyright © 2011 jbundle.org. All rights reserved.
 */
package org.jbundle.util.biorhythm;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

/** 
 * LegendView - This is the biorhythm view.
 * @author  Don Corley
 * @version 1.0
 */
public class LegendView extends View
{
    
	/**
	 * The resource bundle used to translate information for this view.
	 */
	public static ResourceBundle m_resources = null;	// Current resource bundle
	public static Calendar gCalendar = Calendar.getInstance();

	/**
	 * Creates new View.
	 */
    public LegendView(Context context) {
        super(context);
//        this.init(this.fakeController(context));
    }
    public LegendView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        this.init(this.fakeController(context));
    }
    public LegendView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
//        this.init(this.fakeController(context));
    }
	/**
	 * Creates new View.
	 * Remember to set the background color after instaniating this object.
	 * @param controller Controller that this view is connected to.
	 */
	public LegendView(Controller controller)
	{
		this((Context)null);
		this.init(controller);
	}
	/**
	 * Creates new View.
	 * @param controller Controller that this view is connected to.
	 */
	public void init(Controller controller)
	{
		super.init(controller);

		//this.setPreferredSize(new Dimension(300, 300));

//		Locale currentLocale = Locale.getDefault();
  //      String strBundleName = this.getResourceName();
	//	m_resources = ResourceBundle.getBundle(strBundleName, currentLocale);
	}
	/**
	 * Paint this portion of the panel (overidden from awt).
	 * @param g Graphics object to paint to.
	 */
//	public void paint(Graphics g)
    protected void onDraw(Canvas canvas) {
		this.drawHorizontals(canvas);
		this.drawVerticals(canvas);
		super.onDraw(canvas);
		this.drawLegend(canvas);
	}
	/**
	 * Draw the horizontal lines every 10 pixels.
	 * @param canvas Graphics object to paint to.
	 */
	public void drawHorizontals(Canvas canvas)
	{
	    int width = this.getWidth();
	    int height = this.getHeight();
		int colorBack = this.getElementColor(BACKGROUND);
        Paint paint = new Paint();
		//if (colorBack != null)
		{
		    paint.setColor(colorBack);
			canvas.drawRect(0, 0, width, height, paint);
		}
		paint.setColor(this.getElementColor(GRID));
		for (int i = height / 2; i >= 0; i = i - 10) {
			canvas.drawLine(0, i, width, i, paint);
		}
		for (int i = height / 2; i <= height; i = i + 10) {
			canvas.drawLine(0, i, width, i, paint);
		}
		paint.setColor(this.getElementColor(BASELINE));
		canvas.drawLine(0, height / 2, width, height / 2, paint);
	}
	/**
	 * Draw the vertical lines at every day break.
	 * @param canvas Graphics object to paint to.
	 */
	public void drawVerticals(Canvas canvas)
	{
		int colorGrid = this.getElementColor(GRID);
		int colorDate = this.getElementColor(DATE);
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
        int width = this.getWidth();
        int height = this.getHeight();
        Paint paint = new Paint();
		for (int x = -1; x < width; x++)
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
				paint.setColor(colorGrid);
				canvas.drawLine(x, 0, x, height, paint);
				if (x - iStartDayX > 10)
				{	// Put the day in the middle of the box
					paint.setColor(colorDate);
					String strDate = Integer.toString(iDay);
					int istringWidth = 10; //? canvas.getFontMetrics().stringWidth(strDate);
					int sx = x + (iDayOffsetX - istringWidth) / 2;
					int sy = 12;
					canvas.drawText(strDate, sx, sy, paint);
					iStartDayX = x;
				}
			}
		}
		// Now draw the vertical that represents today
		paint.setColor(this.getElementColor(TODAY));
		if  (xNow > -1) if (xNow < width - 1)
			canvas.drawLine(xNow, 0, xNow, height, paint);
	}
	/**
	 * Draw the legend.
	 */
	public void drawLegend(Canvas canvas)
	{
//		FontMetrics fm = canvas.getFontMetrics();
        int width = this.getWidth();
        int height = this.getHeight();
		Paint paint = new Paint();
		paint.setColor(this.getElementColor(PHYSICAL_CYCLE));
		int sx = 10;
		int sy = height - 7;
		canvas.drawLine(sx, sy, sx+20, sy, paint);
		String string = "Physical Cycle";//?this.getResources().getString("Physical Cycle");
		canvas.drawText(string, sx+25, sy+5, paint); 

		paint.setColor(this.getElementColor(EMOTIONAL_CYCLE));
		string = "Emotional Cycle";//?this.getResources().getString("Emotional Cycle");
		int iWidth = 10; //?fm.stringWidth(string);
		sx = (width - iWidth - 20) / 2;
		canvas.drawLine(sx, sy, sx+20, sy, paint);
		canvas.drawText(string, sx+25, sy+5, paint); 

		paint.setColor(this.getElementColor(INTELLECTUAL_CYCLE));
		string = "Intellectual Cycle";//?this.getResources().getString("Intellectual Cycle");
		iWidth = 10; //?fm.stringWidth(string);
		sx = width - 30 - iWidth;
		canvas.drawLine(sx, sy, sx+20, sy, paint);
		canvas.drawText(string, sx+25, sy+5, paint); 
	}
	/**
	 * Draw a line from x to x+1 on the canvas.
	 * @param canvas Graphics object to paint to.
	 * @param x x value to use to compute the Y value
	 * @param iCycleLength Length of the cycle to compute
	 */
	public void drawGraphLine(Canvas canvas, int x, int iCycleLength, Paint paint)
	{
		super.drawGraphLine(canvas, x, iCycleLength, paint);
		this.drawTickmarks(canvas, x, iCycleLength, paint);
	}
	/**
	 * If x is at a minimum, maximum, or critical point, draw the tickmark and the day.
	 * @param canvas Graphics object to paint to.
	 * @param x x value to use to compute the Y value
	 * @param iCycleLength Length of the cycle to compute
	 */
	public void drawTickmarks(Canvas canvas, int x, int iCycleLength, Paint paint)
	{
		int iTrend = 0;

		double dXGraphYValue = this.getController().getModel().convertTimeToStrength(this.convertXtoTime(x), iCycleLength);
		double dXNextGraphYValue = this.getController().getModel().convertTimeToStrength(this.convertXtoTime(x+1), iCycleLength);
		if (((dXGraphYValue >= 0) && (dXNextGraphYValue < 0))
			|| ((dXGraphYValue <= 0) && (dXNextGraphYValue > 0)))
				this.drawThisTickmark(canvas, x, iCycleLength, iTrend, paint);
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
					this.drawThisTickmark(canvas, x, iCycleLength, iTrend, paint);
			}
			else
			{
				if (iTrend == -1)
					this.drawThisTickmark(canvas, x, iCycleLength, iTrend, paint);
			}
		}
   }                                                                           
	/**
	 * Draw the tickmark at this location.
	 * @param canvas Graphics object to paint to.
	 * @param x x value to use to compute the Y value
	 * @param iCycleLength Length of the cycle to compute
	 * @param iTrend is the cycle heading up (+1) or down (-1).
	 */
	public void drawThisTickmark(Canvas canvas, int x, int iCycleLength, int iTrend, Paint paint)
	{
		int sy = convertXtoY(x, iCycleLength);
		canvas.drawLine(x, sy - 4, x, sy + 4, paint);
		if (iTrend == -1)
			sy -= 5;
		else
			sy += 14;
		Date dateAtMark = new Date(this.convertXtoTime(x));
		gCalendar.setTime(dateAtMark);
		int iDay = gCalendar.get(Calendar.DAY_OF_MONTH);
		String strDate = Integer.toString(iDay);
		int istringWidth = 10; //canvas.getFontMetrics().stringWidth(strDate);
		int sx = x - istringWidth / 2;
		canvas.drawText(strDate, sx, sy, paint);
	}
	/**
	 * Get the color to paint this wave.
	 * @param iCycleLength Type of cycle to paint.
	 * @return The color of the element.
	 */
	public int getElementColor(int iCycleLength)
	{
		return super.getElementColor(iCycleLength);
	}
	/**
	 * Get the resource bundle.
	 * @return Local string resources.
	 */
//?	public ResourceBundle getResources()
//?	{
//?		return m_resources;
//?	}
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
//?		LegendController.m_df = DateFormat.getDateInstance(DateFormat.MEDIUM, currentLocale);
//?		LegendController.m_dtf = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT, currentLocale);
		Controller controller = this.getController();
//?		((LegendController)this.getController()).setComponentText();
		controller.setBirthdate(controller.getBirthdate());
		controller.setStartDate(controller.getStartDate());
		controller.setEndDate(controller.getEndDate());
		this.invalidate();
//?		this.validate();
//?		this.repaint();
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
