import org.apache.spark.sql.{SparkSession, DataFrame}

object SparkCSVReader {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession
    val spark = SparkSession.builder
      .appName("Spark CSV Reader")
      .master("local[*]")  // Use all available cores
      .getOrCreate()

    // Path to your CSV file
    val csvFilePath = "path_to_csv_file"

    // Read the CSV file into a DataFrame
    val df: DataFrame = spark.read
      .option("header", "true")  // Specify if the CSV file has a header
      .option("inferSchema", "true")  // Infer the schema of the CSV file
      .csv(csvFilePath)

    // Show the DataFrame content
    df.show()

    // Stop the SparkSession
    spark.stop()
  }
}
