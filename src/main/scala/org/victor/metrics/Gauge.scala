package org.victor.metrics

import java.util.concurrent.atomic.AtomicLong


/**
 * @author victorp
 */
class Gauge {

  val value:AtomicLong = new AtomicLong

  def update(newValue:Long) = {
    value.set(newValue)
  }

  override def toString = s"${value.get}"

}
