package com.hadooptraining.recommender;

public interface ClusterablePoint {
    public double getDistance(ClusterablePoint other);
    public String print();
}

