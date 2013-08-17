package com.hadooptraining.cooccurence;

import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Writable;

import java.util.Set;

public class WordMapWritable extends MapWritable {

    public String toString() {
        String returnValue = "";
        Set<Writable> keys = this.keySet();
        for (Writable key : keys) {
            returnValue += "[" + key + ": " + this.get(key) + "] ";
        }
        return returnValue;
    }
}
