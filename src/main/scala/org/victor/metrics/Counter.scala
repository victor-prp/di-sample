package org.victor.metrics

import java.util.concurrent.atomic.AtomicInteger

/**
 * @author victorp
 */
class Counter {
  val current:AtomicInteger = new AtomicInteger
  def inc() = current.incrementAndGet


  override def toString = s"${current.get}"
}
