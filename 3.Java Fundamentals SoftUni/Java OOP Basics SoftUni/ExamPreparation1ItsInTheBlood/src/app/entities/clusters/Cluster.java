package app.entities.clusters;

import app.entities.cells.Cell;

import java.util.LinkedList;
import java.util.List;

public class Cluster {

    private String id;
    private int rows;
    private int cols;
    private Cell[][] cells;


    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
    }

    public String getId() {
        return this.id;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    public void addCell(Cell cell) {
        this.cells[cell.getPositionRow()][cell.getPositionCol()] = cell;
    }

    public int getCellsCount() {
        int count = 0;

        for (Cell[] cells : this.getCells()) {
            for (Cell cell : cells) {
                if (cell != null) {
                    count++;
                }
            }
        }
        return count;
    }

    public void activate() {
        List<Cell> cellList = new LinkedList<>();

        for (Cell[] cells : cells) {
            for (Cell cell : cells) {
                if (cell != null) {
                    cellList.add(cell);
                }
            }
        }

        while (cellList.size() > 0) {

            if (cellList.size() == 1) {
                break;
            }

            Cell startCell = cellList.get(0);
            cellList.remove(0);

            int row = cellList.get(0).getPositionRow();
            int col = cellList.get(0).getPositionCol();

            Cell secondCell = cellList.get(0);
            cellList.remove(0);
            Cell winner = fight(startCell, secondCell);

            cellList.add(0, winner);
        }

        this.cells = new Cell[rows][cols];

        for (Cell cell : cellList) {
            this.cells[cell.getPositionRow()][cell.getPositionCol()] = cell;
        }
    }

    private Cell fight(Cell startCell, Cell cell) {
        String cellType = startCell.getClass().getSimpleName();

        switch (cellType) {
            case "RedBloodCell":
            case "WhiteBloodCell":
                startCell.setHealth(startCell.getHealth() + cell.getHealth());
                startCell.setPositionRow(cell.getPositionRow());
                startCell.setPositionCol(cell.getPositionCol());
                return startCell;
            default:
                while (true) {
                    int startCellHealth = startCell.getHealth();
                    int secondCellHealt = startCell.getHealth();

                    cell.setHealth(cell.getHealth() - startCell.getEnergy());
                    if (cell.getHealth() <= 0) {
                        startCell.setPositionRow(cell.getPositionRow());
                        startCell.setPositionCol(cell.getPositionCol());
                        return startCell;
                    }
                    startCell.setHealth(startCell.getHealth() - cell.getEnergy());

                    if (startCell.getHealth() <= 0) {
                        cell.setPositionRow(startCell.getPositionRow());
                        cell.setPositionCol(startCell.getPositionCol());
                        return cell;
                    }
                }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("----Cluster %s", this.getId()))
                .append(System.lineSeparator());

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                Cell cell = cells[i][j];
                if (cell != null) {
                    sb.append(cell.toString());
                }
            }
        }

        return sb.toString();
    }
}
