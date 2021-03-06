package mdmoss.doobiegen

import mdmoss.doobiegen.Runner.{Target, TestDatabase}
import GenOptions._

object TestGen {

  val TestTarget = Target(
    schemaDir = "sql/",
    TestDatabase(
      "org.postgresql.Driver",
      "jdbc:postgresql:gen",
      "test",
      "test"
    ),
    src = "out/src",
    `package` = "mdmoss.doobiegen.db",
    statements = None,
    columnOptions = Map(
      "test_gen_options" -> Map(
        "created_at" -> (NoWrite :: Nil),
        "thing_with_default" -> (AlwaysInsertDefault :: Nil),
        "nullible_thing_with_default" -> (AlwaysInsertDefault :: Nil),
        "test_ignore_default" -> (IgnoreDefault :: Nil)
      ),
      "test_column_ignore" -> Map(
        "ignore_me" -> (Ignore :: Nil)
      )
    )
  )

  def main(args: Array[String]) {
    Runner.run(TestTarget)
  }
}