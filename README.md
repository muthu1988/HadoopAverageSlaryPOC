# HadoopAverageSlaryPOC
POC for Hadoop Map Reduce (Find average salary for a department from a employee data set)

Description : This a Hadoop map reduce maven project with following

    Driver class to configure haddop parameters.
  
    Mapper class
  
    Reducer Class

Steps to build and run this project in hadoop cluster 

1. Built unsing "mvn clean install" command - Got a Jar

2. Copy the jar to a Hadoop cluster (Using WinSCP)

3. Copy the data file to Hadoop local disc (Using WinSCP)

4. Copy the data file from local disc to HDFS using below commands
  
        $ hadoop fs -mkdir input/employee
      
        $ hadoop fs -copyFromLocal employee_dataset_chicago input/employee
      
 5. Remove old output folder using command
 		
 		$ hadoop fs -rm -r output
 		
 6. Run the project using below command
 
        $ hadoop jar AverageByDept.jar com.avgbydept.App input/employee/employee_dataset_chicago output
      
 7. Check the output using command
 
 		$ hadoop fs -cat output/part-r-00000
 	
 
 Sample Data from File set (Last value is salary, and last but before one is department id):
 
 	1512,ACCURSO MARY K,ASST ADMINISTRATIVE SECRETARY I,43,21548.8
 
 Sample Output:
 
    100     75708.56    
    110     88108.36    
    1145    79746.14
    
