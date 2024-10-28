import org.apache.spark.sql.{SparkSession, DataFrame}

object CSVToJsonConverter {
  def main(args: Array[String]): Unit = {
    if (args.length != 3) {
      println("Usage: CSVToJsonConverter <input_file> <output_file> <spark_master>")
      sys.exit(1)
    }

    // Command line arguments
    val csvFilePath = args(0)
    val jsonOutputPath = args(1)
    val sparkMaster = args(2)

    // Create a SparkSession
    val spark = SparkSession.builder
      .appName("CSV to JSON Converter")
      .master(sparkMaster)  // Use specified Spark master
      .config("spark.ui.port", "4040") // Optional: specify a port for the Spark UI
      .getOrCreate()

    // Read the CSV file into a DataFrame
    val df: DataFrame = spark.read
      .option("header", "true")  // Specify if the CSV file has a header
      .option("inferSchema", "true")  // Infer the schema of the CSV file
      .csv(csvFilePath)

    // Write the DataFrame to a JSON file
    df.write
      .json(jsonOutputPath)

    // Keep the application running to access the Spark UI
    println("Application is running. Access Spark UI at http://localhost:4040")
    Thread.sleep(10000)
    // Stop the SparkSession
    spark.stop()
  }
}
