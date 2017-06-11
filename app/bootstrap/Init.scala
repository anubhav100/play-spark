package bootstrap

import org.apache.spark.sql.SparkSession
import play.api._

object Init extends GlobalSettings {

  var sparkSession: SparkSession = _

  /**
   * On start load the json data from conf/data.json into in-memory Spark
   */
  override def onStart(app: Application) {
    sparkSession = SparkSession.builder
      .master("local")
      .appName("ApplicationController")
      .getOrCreate()

    val dataFrame = sparkSession.read.json("conf/data.json")
    dataFrame.createOrReplaceTempView("godzilla")
  }

  /**
   * On stop clear the sparksession
   */
  override def onStop(app: Application) {
    sparkSession.stop()
  }

  def getSparkSessionInstance = {
    sparkSession
  }
}


