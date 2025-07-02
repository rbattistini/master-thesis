mas {
    agent("Printer") {
        goals { ... }
        plans {
            +achieve("print_numbers"(X, Y)) then {
                ...
            } givenLMConfig {
                connectTimeout = 2.seconds
            }
        }
    }
}