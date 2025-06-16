agent("ExplorerBot") {
  goals {
      admissible {
          +achieve("reach"("Object")).meaning {
              "reach a situation where ${args[0]} is in the position of the agent" +
                  " (i.e. there_is(${args[0]}, here))"
          }
      }
      +achieve("reach"("home"))
  }
  beliefs {
      admissible {
          +fact { "obstacle"("Direction") }.meaning {
              "there is an $functor to the ${args[0]}"
          }
          +fact { "there_is"("Object", "Direction") }.meaning {
              "there is an ${args[0]} in the given ${args[1]}"
          }
          +fact { "direction"("Direction") }.meaning {
              "${args[0]} is a direction"
          }
          +fact { "object"("Object") }.meaning {
              "${args[0]} is an object"
          }
      }
  }
}