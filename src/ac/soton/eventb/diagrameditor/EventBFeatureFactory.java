package ac.soton.eventb.diagrameditor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IContext;

public class EventBFeatureFactory<C extends IContext, F extends IFeature> {

	protected List<Matcher<C, F>> featureList;

	public EventBFeatureFactory() {
		super();
		this.featureList = new ArrayList<Matcher<C, F>>();
	}

	public F getFeature(C context, EventBDiagramFeatureProvider f) {
		for (final Matcher<C, F> m : this.featureList) {
			if (m.match(context, f)) {
				return m.getFeature(context, f);
			}
		}
		return null;
	}

	public void register(Matcher<C, F> matcher) {
		this.featureList.add(matcher);
	}

}