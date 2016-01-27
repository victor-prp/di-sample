package org.victor.metrics

import java.util.concurrent.{ScheduledExecutorService, TimeUnit}

/**
 * @author victorp
 */
class GaugeReporter (val periodMillis:Long, val dbConnection:DBConnection, val scheduler: ScheduledExecutorService) {

  scheduler.schedule(report ,periodMillis,TimeUnit.MILLISECONDS)


  def report:Runnable = {
    new Runnable {
      override def run(): Unit = dbConnection.commitWith(s"updating gauges with: ${Metrics.gaugesSnapshot} ")
    }
  }

}
