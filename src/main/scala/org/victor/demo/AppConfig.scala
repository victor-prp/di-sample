package org.victor.demo

/**
 * represents configuration that in real life will be loaded from some source (file system, env var etc)
 *
 * @author victorp
 */
class AppConfig {
  /**
   * reporters
   */
  val counterReporterPeriodMillis = 100
  val gaugeReporterPeriodMillis = 200

  /**
   * DB
   */
  val dbConnectionUrl = "db:url"
  val dbConnectionTimeoutMillis = 1000

}
