/*
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package org.jbundle.util.biorhythm;

import java.beans.*;

/** 
 * The only thing we define in the BioBeanBeanInfo is a GIF icon.
 */
public class BioBeanBeanInfo extends SimpleBeanInfo {

	/**
	 * Get the icon.
	 */
    public java.awt.Image getIcon(int iconKind) {
		
		String strDir = "images/icons/";
		
		if (iconKind == BeanInfo.ICON_COLOR_16x16) {
			java.awt.Image img = loadImage(strDir + "Bio16.jpg");
			return img;
		}
		if (iconKind == BeanInfo.ICON_COLOR_32x32) {
			java.awt.Image img = loadImage(strDir + "Bio32.jpg");
			return img;
		}

		return null;
    }

}
