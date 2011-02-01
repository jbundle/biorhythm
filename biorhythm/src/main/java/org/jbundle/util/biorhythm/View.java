/*
 * Model.java
 *
 * Created on January 14, 2001, 12:39 AM
 */
 
package org.jbundle.util.biorhythm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ResourceBundle;

import javax.swing.JPanel;

/** 
 * View - This is the biorhythm view.
 * @author  Don Corley
 * @version 1.0
 */
public class View extends JPanel
	implements Constants
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
	/**
	 * Controller that this view is connected to.
	 */
	protected Controller m_controller = null;

	/**
	 * Creates new View.
	 */
	public View()
	{
		super();
	}
	/**
	 * Creates new View.
	 * Remember to set the background color after insatiating this object.
	 * @param controller Controller that this view is connected to.
	 */
	public View(Controller controller)
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
		this.setController(controller);
		this.setOpaque(false);		// Make this transparent (by default)
	}
	/**
	 * Set the controller for this view.
	 * @param controller Controller that this view is connected to.
	 */
	public void setController(Controller controller)
	{
		m_controller = controller;
	}
	/**
	 * Get the controller for this view.
	 * @return Controller that this view is connected to.
	 */
	public Controller getController()
	{
		return m_controller;
	}
	/**
	 * Paint this portion of the panel (overidden from awt).
	 * @param g Graphics object to paint to.
	 */
	public void paint(Graphics g)
	{
		this.drawWaves(g);
	}
	/**
	 * Draw the sine waves.
	 * @param g Graphics object to paint to.
	 */
	private void drawWaves(Graphics g)
	{
		int iWidth = this.getBounds().width;
		for (int x = 0 ; x < iWidth ; x++)
		{
			g.setColor(this.getElementColor(PHYSICAL_CYCLE));
			this.drawGraphLine(g, x, PHYSICAL_CYCLE);
			g.setColor(this.getElementColor(EMOTIONAL_CYCLE));
			this.drawGraphLine(g, x, EMOTIONAL_CYCLE);
			g.setColor(this.getElementColor(INTELLECTUAL_CYCLE));
			this.drawGraphLine(g, x, INTELLECTUAL_CYCLE);
		}
	}
	/**
	 * Draw a line from x to x+1 on the canvas.
	 * @param g Graphics object to paint to.
	 * @param x x value to use to compute the Y value
	 * @param iCycleLength Length of the cycle to compute
	 */
	public void drawGraphLine(Graphics g, int x, int iCycleLength)
	{
		g.drawLine(x, this.convertXtoY(x, iCycleLength), x + 1, this.convertXtoY(x + 1, iCycleLength));
	}
	/**
	 * Convert this x value to a y value.
	 * 1) Convert the x value to a time
	 * 2) Convert the time to a strength (in radians)
	 * 3) Convert the strength to a Y value
	 * @param x x value to use to compute the Y value
	 * @param iCycleLength Length of the cycle to compute.
	 * @returns The Y value.
	 */
	public int convertXtoY(int x, int iCycleLength)
	{
		long lTimeX = this.convertXtoTime(x);
		double dGraphYValue = this.getController().getModel().convertTimeToStrength(lTimeX, iCycleLength);
		int y = this.convertStrengthToY(dGraphYValue);
		return y;
	}
	/**
	 * Convert the grid x value to the time.
	 * @param x The X value to convert.
	 * @return The time.
	 */
	public long convertXtoTime(int x)
	{
		long lStartTime = this.getController().getStartDate().getTime();
		long lEndTime = this.getController().getEndDate().getTime();
		long lWidth = (long)this.getBounds().getWidth();
		long lTimeX = (lEndTime - lStartTime) / lWidth;
		return lStartTime + (x * lTimeX);
	}
	/**
	 * Convert the value (range 1.0000 to -1.0000) to a grid y value.
	 * @param gGraphYValue Strength to convert to a Y value.
	 * @return Y value.
	 */
	public int convertStrengthToY(double dGraphYValue)
	{
		int iGraphMargin;
		Dimension m_dim = this.getBounds().getSize();
		if (m_dim.height > 150)
			iGraphMargin = 14 * 2;
		else
			iGraphMargin = (int)(m_dim.height * .2);	// 80%
// Now, Convert to the y position on the screen
		int m_iOrigin = m_dim.height / 2;
		int m_iScaleValue = m_iOrigin - iGraphMargin;

		int y = (int)(dGraphYValue * m_iScaleValue);	// Weight of value
		y = -y;																					// " on reversed axis 
		y = y + m_iOrigin;															// Shift by the amount of the origin
		return y;
	}
	/**
	 * Get the color to paint this wave.
	 * @param iCycleLength Type of cycle to paint.
	 * @return The color of the element.
	 */
	public Color getElementColor(int iCycleLength)
	{
		if (iCycleLength == PHYSICAL_CYCLE)
			return Color.red;
		if (iCycleLength == EMOTIONAL_CYCLE)
			return Color.blue;
		if (iCycleLength == INTELLECTUAL_CYCLE)
			return Color.green;
		if (iCycleLength == BACKGROUND)
			return Color.pink;
		if (iCycleLength == GRID)
			return Color.gray;
		if (iCycleLength == BASELINE)
			return Color.black;
		if (iCycleLength == DATE)
			return Color.black;
		if (iCycleLength == TODAY)
			return Color.white;
		return Color.black;
	}
	/**
	 * Get the resource bundle.
	 * Note: Override this to supply the resource bundle.
	 * @return Local string resources.
	 */
	public ResourceBundle getResources()
	{
		return null;
	}
}