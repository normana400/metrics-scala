package nl.grons.metrics4.scala

import org.scalatest.Matchers._
import org.scalatest.FunSpec

class StringUtilsSpec extends FunSpec {

  describe("collapseDots") {
    it("strips leading dot") {
      StringUtils.collapseDots(".foo.bar") should equal ("foo.bar")
    }

    it("strips trailing dot") {
      StringUtils.collapseDots("foo.bar.") should equal ("foo.bar")
    }

    it("collapses dots at the beginning of the String") {
      StringUtils.collapseDots("....foo.bar") should equal ("foo.bar")
    }

    it("collapses dots at the end of the String") {
      StringUtils.collapseDots("foo.bar....") should equal ("foo.bar")
    }

    it("collapses dots in the middle of the String") {
      StringUtils.collapseDots("foo....bar...baz") should equal ("foo.bar.baz")
    }

    it("doesn't modify an already valid String") {
      StringUtils.collapseDots("foo.bar.baz") should equal ("foo.bar.baz")
    }
  }

  describe("replace") {
    it("doesn't replace anything in null Strings") {
      StringUtils.replace(null, "foo", "bar") should equal (null)
    }

    it("doesn't replace anything in empty Strings") {
      StringUtils.replace("", "foo", "bar") should equal ("")
    }

    it("doesn't replace null") {
      StringUtils.replace("foo", null, "bar") should equal ("foo")
    }

    it("doesn't replace empty String") {
      StringUtils.replace("foo", "", "bar") should equal ("foo")
    }

    it("replaces repeated occurrences") {
      StringUtils.replace("queued", "ue", "") should equal ("qd")
    }

    it("doesn't replace non-matching String") {
      StringUtils.replace("queued", "zz", "") should equal ("queued")
    }

    it("can replace with a longer String") {
      StringUtils.replace("abXYab", "ab", "foobar") should equal ("foobarXYfoobar")
    }
  }

  describe("isEmpty") {
    it("recognizes nulls as empty") {
      StringUtils.isEmpty(null) should be (true)
    }

    it("recognizes empty String as empty") {
      StringUtils.isEmpty("") should be (true)
    }

    it("recognizes non-empty String as not empty") {
      StringUtils.isEmpty("foo") should be (false)
    }
  }
}
