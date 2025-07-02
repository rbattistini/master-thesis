mas {
    lmGeneration {
        model = "openai/gpt-4.1"
        temperature = 0.5
        maxTokens = 1024
    }
    agent("Printer") {
        goals {
            +achieve("print"(0, 10))
            admissible {
                +achieve("print_numbers"("start", "end")).meaning {
                    "Print the numbers from ${args[0]} to ${args[1]}"
                }
            }
        }
        plans {
            +achieve("print"(X, Y)) then {
                generatePlan("print_numbers"(X, Y))
            }
        }
    }
}