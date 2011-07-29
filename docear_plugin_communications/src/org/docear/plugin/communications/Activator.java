package org.docear.plugin.communications;

import java.util.Hashtable;

import org.freeplane.features.mode.mindmapmode.MModeController;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		final Hashtable<String, String[]> props = new Hashtable<String, String[]>();
		props.put("mode", new String[] { MModeController.MODENAME });
//		context.registerService(IModeControllerExtensionProvider.class.getName(),
//		    new IModeControllerExtensionProvider() {
//			    public void installExtension(ModeController modeController) {
//			    	new Communication();
//				    
//			    }
//		    }, props);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
	}

}