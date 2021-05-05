package com.sample;

import java.io.IOException;
import java.util.Collection;

public interface Gui {
	public void showMap(Collection<LocatedOnMap> mapBeing, Settings setting);
	public void showHelp();
	public PlayerAction getAction() throws IOException;
}
