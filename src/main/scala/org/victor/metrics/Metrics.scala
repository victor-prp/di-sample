package org.victor.metrics

import scala.collection.concurrent.Map


/**
 * @author victorp
 */
object Metrics {

  val counterRegistry: Map[String,Counter] = new scala.collection.concurrent.TrieMap[String,Counter]
  val gaugeRegistry: Map[String,Gauge] = new scala.collection.concurrent.TrieMap[String,Gauge]


  def counter(name:String):Counter = {
    counterRegistry.putIfAbsent(name,new Counter)
    counterRegistry.get(name).get
  }

  def gauge(name:String):Gauge={
    gaugeRegistry.putIfAbsent(name,new Gauge)
    gaugeRegistry.get(name).get
  }

  def countersSnapshot:Map[String,Counter] = counterRegistry
  def gaugesSnapshot:Map[String,Gauge] = gaugeRegistry


}
