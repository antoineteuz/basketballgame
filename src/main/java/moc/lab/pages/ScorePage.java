package moc.lab.pages;

import ej.container.Flow;
import ej.container.Split;
import ej.navigation.desktop.NavigationDesktop;
import ej.navigation.page.Page;
import ej.widget.basic.Label;
import ej.widget.composed.Button;
import ej.widget.listener.OnClickListener;

public class ScorePage extends Page {
	
	private Split container;

	public ScorePage (NavigationDesktop nav) {
	
		container = new Split(false, (float) 0.2);
		
		
		Label title = new Label("SCORE PAGE");
		title.addClassSelector("TITLE");

		Button bckBTN = new Button("BACK BUTTON");
		bckBTN.addClassSelector("BUTTON");
		
		bckBTN.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("CLICKED BUTTON BACK ON GAME PAGE");
				nav.back();
			}
		});
		
		container.setFirst(title);
		
		//SCROLL HERE
		container.setLast(bckBTN);
		
		setWidget(container);
	}
}