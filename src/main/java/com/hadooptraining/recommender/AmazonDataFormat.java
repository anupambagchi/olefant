package com.hadooptraining.recommender;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

public class AmazonDataFormat extends FileInputFormat<Text, Text>{
    private AmazonDataReader boxFileReader = null;

    @Override
    public RecordReader<Text, Text> createRecordReader(
            InputSplit inputSplit, TaskAttemptContext attempt) throws IOException,
            InterruptedException {
        boxFileReader = new AmazonDataReader();
        boxFileReader.initialize(inputSplit, attempt);
        return boxFileReader;
    }

}