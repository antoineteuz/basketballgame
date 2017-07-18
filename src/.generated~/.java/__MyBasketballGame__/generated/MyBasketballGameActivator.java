package __MyBasketballGame__.generated;

import ej.wadapps.management.ActivitiesList;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.components.registry.BundleActivator;

public class MyBasketballGameActivator implements BundleActivator {

	moc.lab.Program moc__lab__Program;

	@Override
	public void initialize() {
		this.moc__lab__Program = new moc.lab.Program();
	}

	@Override
	public void link() {
		ActivitiesList activitieslist = ServiceLoaderFactory.getServiceLoader().getService(ActivitiesList.class);
		activitieslist.add(this.moc__lab__Program);

	}

	@Override
	public void start() {
	}

	@Override
	public void stop() {
		ActivitiesList activitieslist = ServiceLoaderFactory.getServiceLoader().getService(ActivitiesList.class);
		activitieslist.remove(this.moc__lab__Program);

	}

}