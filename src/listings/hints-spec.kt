agent("ExplorerBot") {
  goals { ... }
  beliefs {
      admissible {
          +fact { "obstacle"("Direction") }.meaning {
              "there is an $functor to the ${args[0]}"
          }
      }
  }
}