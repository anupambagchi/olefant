package com.hadooptraining.cooccurence;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * Algorithm taken from http://www.javacodegeeks.com/2012/11/calculating-a-co-occurrence-matrix-with-hadoop.html
 * See the book: Data-Intensive Processing with MapReduce
 * http://www.amazon.com/Data-Intensive-Processing-MapReduce-Synthesis-Technologies/dp/1608453421
 */
public class CooccurenceUsingPairs extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new CooccurenceUsingPairs(), args);
        System.exit(res);
    }

    @Override
    public int run(String[] args) throws Exception {
        if (args.length < 2) {
            System.err.println("Usage: <input_path> <output_path>");
            System.exit(-1);
        }

		/* input parameters */
        String inputPath = args[0];
        String outputPath = args[1];

        Job job = Job.getInstance(getConf(), "cooccurence-pairs");

        job.setJarByClass(CooccurenceUsingPairs.class);
        job.setMapperClass(PairsOccurenceMapper.class);
        job.setReducerClass(PairsReducer.class);

        job.setOutputKeyClass(WordPair.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path(outputPath));

        int exitStatus = job.waitForCompletion(true) ? 0 : 1;

        return exitStatus;
    }
}