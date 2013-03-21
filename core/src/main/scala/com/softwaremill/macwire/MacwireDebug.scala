package com.softwaremill.macwire

private[macwire] class MacwireDebug {
  var ident = 0

  def apply(msg: => String) {
    val prefix = "   " * (ident - 1)
    println(s"$prefix[debug] $msg")
  }


  def withBlock[T](msg: => String)(block: => T) = {
    apply(msg)
    beginBlock()
    val result = block
    endBlock()
    result
  }

  def beginBlock() {
    ident += 1
  }

  def endBlock() {
    ident -= 1
  }
}