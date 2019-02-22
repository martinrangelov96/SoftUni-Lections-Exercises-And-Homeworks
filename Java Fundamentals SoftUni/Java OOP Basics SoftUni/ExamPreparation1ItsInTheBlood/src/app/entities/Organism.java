package app.entities;

import app.entities.cells.Cell;
import app.entities.clusters.Cluster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Organism {
    private String name;
    private List<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(this.clusters);
    }

    public boolean addCluster(Cluster cluster) {
        for (Cluster currentCluster : clusters) {
            if (currentCluster.getId().equals(cluster.getId())) {
                return false;
            }
        }
        this.clusters.add(cluster);
        return true;
    }

    private int getCellsCount() {
        int count = 0;

        for (Cluster cluster : clusters) {
            for (Cell[] cells : cluster.getCells()) {
                for (Cell cell : cells) {
                    if (cell != null) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public Cluster getClusterById(String clusterId) {
        for (Cluster cluster : clusters) {
            if (cluster.getId().equals(clusterId)){
                return cluster;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("Organism - %s", this.getName()))
                .append(System.lineSeparator())
                .append(String.format("--Clusters: %d", this.clusters.size()))
                .append(System.lineSeparator())
                .append(String.format("--Cells: %d", this.getCellsCount()))
                .append(System.lineSeparator());
        for (Cluster cluster : clusters) {
            sb.append(cluster.toString());
        }

        return sb.toString();
    }

    public void moveClusterToTheEnd() {
        Cluster cluster = this.getClusters().get(0);
        this.clusters.remove(0);
        this.clusters.add(cluster);
    }
}
