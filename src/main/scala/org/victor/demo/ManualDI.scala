package org.victor.demo

import java.util.concurrent.{Executors, ScheduledExecutorService}

import org.victor.metrics.{Metrics, GaugeReporter, CounterReporter, DBConnection}

/**
 * @author victorp
 */
object ManualDI extends App{

  /**
   * App bootstrap
   * Resolve all dependencies and config injection manually
   */

  val config:AppConfig = new AppConfig // in real life it will be created from some source

  val reportersScheduler:ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor

  val dbConnection:DBConnection = new DBConnection(config.dbConnectionUrl,config.dbConnectionTimeoutMillis)

  val counterReporter:CounterReporter = new CounterReporter(config.counterReporterPeriodMillis,dbConnection,reportersScheduler)
  val gaugeReporter:GaugeReporter = new GaugeReporter(config.counterReporterPeriodMillis,dbConnection,reportersScheduler)

  /**
   * Now we can use the Metrics and see how different stats are reported
   */
  Metrics.counter("counter1").inc()
  Metrics.counter("counter2").inc()

  Metrics.gauge("gauge1").update(100)
  Metrics.gauge("gauge2").update(300)


  //Lets wait to make sure all reporters worked at least once
  Thread.sleep(Math.max(config.counterReporterPeriodMillis,config.gaugeReporterPeriodMillis)+100)

  //We need to call exit explicitly since other threads are running on background
  System.exit(0)
}
