environment {
    from(GridWorldEnvironment())
    actions {
        action(move).meaning {
            "move in the given direction: ${args[0]}"
        }
        action(getDirectionToMove).meaning {
            "provides a Direction free of obstacles where the agent can then move"
        }
    }
}