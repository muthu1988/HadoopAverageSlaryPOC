package com.avgbydept;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AverageByDepartmentMapper extends Mapper<LongWritable, Text, Text, FloatWritable> {
	
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		String line = value.toString();
		String[] items = line.split(",");
		
		String department = items[3];
		Float salary = Float.parseFloat(items[4]);
		
		context.write(new Text(department), new FloatWritable(salary));
		
	}

}
