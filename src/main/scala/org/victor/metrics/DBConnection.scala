package org.victor.metrics

/**
 * @author victorp
 */
class DBConnection(val connectionUrl:String, val timeoutMillis:Long) {

  def commitWith(query:String) = println(s"Committing query: $query using url: $connectionUrl, with timeout: $timeoutMillis")

}
