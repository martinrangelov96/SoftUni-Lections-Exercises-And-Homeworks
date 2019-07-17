package exercises.pr0304Barracks.data;

import exercises.pr0304Barracks.contracts.Repository;
import exercises.pr0304Barracks.contracts.Unit;
import jdk.jshell.spi.ExecutionControl;

import java.util.Map;
import java.util.TreeMap;

public class UnitRepository implements Repository {
	public static final String NO_SUCH_UNIT_TYPE_EXCEPTION_MESSAGE = "No such units in repository.";

	private Map<String, Integer> amountOfUnits;

	public UnitRepository() {
		this.amountOfUnits = new TreeMap<>();
	}

	public void addUnit(Unit unit) {
		String unitType = unit.getClass().getSimpleName();
		if (!this.amountOfUnits.containsKey(unitType)) {
			this.amountOfUnits.put(unitType, 0);
		}

		int newAmount = this.amountOfUnits.get(unitType) + 1;
		this.amountOfUnits.put(unitType, newAmount);
	}

	public String getStatistics() {
		StringBuilder statBuilder = new StringBuilder();
		for (Map.Entry<String, Integer> entry : amountOfUnits.entrySet()) {
			String formatedEntry =
					String.format("%s -> %d%n", entry.getKey(), entry.getValue());
			statBuilder.append(formatedEntry);
		}
		statBuilder.setLength(
				statBuilder.length() - System.lineSeparator().length());

		return statBuilder.toString();
	}

	public void removeUnit(String unitType) {
		if (this.amountOfUnits.containsKey(unitType)) {
			Integer countOfUnits = this.amountOfUnits.get(unitType);
			if (countOfUnits > 0) {
				this.amountOfUnits.put(unitType, countOfUnits - 1);
			}
			return;
		}
		throw new IllegalArgumentException(NO_SUCH_UNIT_TYPE_EXCEPTION_MESSAGE);
	}
}
