package exercises.pr0304Barracks;

import exercises.pr0304Barracks.contracts.Repository;
import exercises.pr0304Barracks.contracts.UnitFactory;
import exercises.pr0304Barracks.core.Engine;
import exercises.pr0304Barracks.core.factories.UnitFactoryImpl;
import exercises.pr0304Barracks.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
