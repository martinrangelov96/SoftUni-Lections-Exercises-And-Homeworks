package app.factories;

import app.entities.clusters.Cluster;

public final class ClusterFactory {

    private ClusterFactory() {}

    public static Cluster createCluster(String clusterId, int rows, int cols) {
        return new Cluster(clusterId, rows, cols);
    }
}
