package app.factories;

import app.entities.cells.Cell;
import app.entities.cells.bloodCells.RedBloodCell;
import app.entities.cells.bloodCells.WhiteBloodCell;
import app.entities.microbes.Bacteria;
import app.entities.microbes.Fungi;
import app.entities.microbes.Virus;

public final class CellFactory {

    private CellFactory() {
    }

    public static Cell createCell(String cellType, String cellId,
                                  int health, int rows, int cols, int addProperty) {
        switch (cellType) {
            case "RedBloodCell":
                return new RedBloodCell(cellId, health, rows, cols, addProperty);
            case "WhiteBloodCell":
                return new WhiteBloodCell(cellId, health, rows, cols, addProperty);
            case "Fungi":
                return new Fungi(cellId, health, rows, cols, addProperty);
            case "Virus":
                return new Virus(cellId, health, rows, cols, addProperty);
            case "Bacteria":
                return new Bacteria(cellId, health, rows, cols, addProperty);
            default:
                return null;
        }
    }
}
