package com.avgbydept;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AverageByDepartmentReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {
	
	@Override
	 public void reduce(Text key, Iterable<FloatWritable> values, Context context) throws IOException, InterruptedException {
		
		float totalSlary =  Float.MIN_VALUE;
		float total = Float.MIN_VALUE;
		
		for (FloatWritable value : values) {
			totalSlary = totalSlary + value.get();
			total = total + 1;
		}
		
		float averageSalary = totalSlary / total;
		context.write(key, new FloatWritable(averageSalary));
		
	}

}
