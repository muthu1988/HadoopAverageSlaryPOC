package com.avgbydept;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


/**
 * Driver Class for Hadoop Jar
 *
 */
public class App {
	public static void main(String[] args) throws Exception {

		
		if (args.length != 2) {
			System.err.println("Usage: Average by Department <input path> <output path>");
			System.exit(-1);
		}
		
		//Define MapReduce job
		Job job = new Job();
		job.setJarByClass(App.class);
		job.setJobName("AverageByDepartment");

		//Set input and output locations
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		//Set Input and Output formats
	    job.setInputFormatClass(TextInputFormat.class);
	    job.setOutputFormatClass(TextOutputFormat.class);
	    
	    //Set Mapper and Reduce classes
		job.setMapperClass(AverageByDepartmentMapper.class);
		job.setReducerClass(AverageByDepartmentReducer.class);
				
		//Output types
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FloatWritable.class);

		//Submit job
		System.exit(job.waitForCompletion(true) ? 0 : 1);
				
	
	}
}
