# Spark_Utilities

Spark is faster because it uses random access memory (RAM) instead of reading and writing intermediate data to disks.

I have written some Spark jobs in scala. The program is run using the spark-submit command in the terminal with spark master - yarn and local.
For this we need to setup Spark, Yarn on our system. 
This branch comprises of 3 jobs :
  1. Reading a CSV file.
  2. Format conversion: CSV file is converted into JSON format.
  3. Data processing: The converted file is undergone through a data processing.

The input paths for the utility are provided as arguments in the spark-submit command.

## On IDE  terminal

## To compile package

sbt clean \
sbt compile \
sbt package \

## Spark-submit command

### For format conversion
$SPARK_HOME/bin/spark-submit --class <className> --master yarn <jar_file_path> <csv_input_path> <output_file_path_for_json> yarn

### For data processing

$SPARK_HOME/bin/spark-submit --class <className> --master yarn <jar_file_path> <csv_input_path> <json_output_path> yarn <age_threshold>
