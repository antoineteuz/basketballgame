package moc.lab.pages;

import ej.container.List;
import ej.container.Scroll;
import ej.container.Split;
import ej.navigation.desktop.NavigationDesktop;
import ej.navigation.page.Page;
import ej.widget.basic.Label;
import ej.widget.composed.Button;
import ej.widget.listener.OnClickListener;

public class FeaturesPage extends Page {
	
	private static Scroll scroll;
	private static Split container;
	private static List list;
	
	public FeaturesPage (NavigationDesktop nav) {
		
		container = new Split(false, (float) 0.2);

		list = new List(false);
		
		Label title = new Label("FEATURES PAGE");
		title.addClassSelector("TITLE");
		
		
		for (int i = 0; i < 10; i++) {
			Label label = new Label("ITEM - " + String.valueOf(i));
			label.addClassSelector("TITLE");
			list.add(label);
		}

		Button bckBTN = new Button("BACK BUTTON");
		bckBTN.addClassSelector("BUTTON");
		
		bckBTN.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("CLICKED BUTTON BACK ON FEATURES PAGE");
				nav.back();
			}
		});
		
		list.add(bckBTN);
		
		scroll = new Scroll(false, true);
		scroll.setWidget(list);
		
		container.setFirst(title);
		container.setLast(scroll);
		
		setWidget(container);

	}
	
}