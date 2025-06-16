environment {
    from(GridWorld())
    actions {
        action(move).meaning {
            "move in the given ${args[0]}"
        }
        action(getDirectionToMove).meaning {
            "provides a ${args[0]} free of obstacles where the agent can then move"
        }
    }
}