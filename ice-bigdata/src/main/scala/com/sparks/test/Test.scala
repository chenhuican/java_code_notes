package com.sparks.test

import org.apache.spark.sql.SparkSession

object Test {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .master("local[2]")
      .appName("HdfsTest")
      .getOrCreate()

    //val filePath = "D:\\IdeaProjects\\ice-bigdata\\src\\main\\resources\\xanadu.txt"
    val filePath = args(0)

    //rdd方式读取
    val rdd = spark.sparkContext.textFile(filePath)

    val lines = rdd.flatMap(x => x.split(" "))
      .map(x =>(x,1))
      .reduceByKey((a,b)=>(a+b))
      .collect().toList

    print(lines)

    // dataset方式读取
    import spark.implicits._
    val dataset = spark.read.textFile(filePath)
      .flatMap(x=>x.split(" "))
      .map(x=>(x,1))
      .groupBy("_1")
      .count()
      .show()

    //print(dataset.show)
  }

}
