package __MyBasketballGame__.generated;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.components.registry.BundleRegistry;
import ej.wadapps.management.ActivitiesScheduler;
import ej.wadapps.registry.SharedRegistryFactory;

public class ProgramStandalone {

	public static void main(String[] args) {
		SharedRegistryFactory.getSharedRegistry().register(BundleRegistry.class, new StandaloneRegistry());

		// Start entry point.
		new MyBasketballGameEntryPoint().start();

		// Program
		ActivitiesScheduler activitiesScheduler = ServiceLoaderFactory.getServiceLoader()
				.getService(ActivitiesScheduler.class);
		moc.lab.Program activity = new moc.lab.Program();
		activitiesScheduler.show(activity);
	}

}