/*
 * Copyright © 2011 jbundle.org. All rights reserved.
 */
package org.jbundle.util.biorhythm.osgi;

/**
 * Hello world!
 *
 */
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import org.jbundle.util.biorhythm.Biorhythm;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
public class Activator implements BundleActivator {
    ServiceRegistration helloServiceRegistration;
    Biorhythm biorhythm = null;
	JFrame frame = null;

    public void start(BundleContext context) throws Exception {
        System.out.println("Starting Biorhythm App");
        
		biorhythm = new Biorhythm();
		try {
			frame = new JFrame("Biorhythm");
//x			frame.addWindowListener(new AppCloser(frame, biorhythm));
		} catch (java.lang.Throwable e) {
			frame = null;
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		frame.getContentPane().add(BorderLayout.CENTER, biorhythm);
		Dimension size = biorhythm.getSize();
		if ((size == null) || ((size.getHeight() < 100) | (size.getWidth() < 100)))
			size = new Dimension(640, 400);
		frame.setSize(size);

		biorhythm.init();		// Simulate the applet calls
		biorhythm.start();

		frame.setVisible(true);
    }
    public void stop(BundleContext context) throws Exception {
        System.out.println("Stopping Biorhythm App");
        
        biorhythm.stop();		// Simulate the applet calls
		biorhythm.destroy();
		frame.dispose();
		biorhythm = null;
		frame = null;
    }
}
