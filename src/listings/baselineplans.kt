plans {
    +achieve("reach"(Object)) onlyIf {
        "there_is"(Object, "here").fromPercept
    }
    +achieve("reach"(Object)) onlyIf {
        "there_is"(Object, Direction).fromPercept
    } then {
        execute("move"(Direction))
    }
    +achieve("reach"(Object)) onlyIf {
        not("there_is"(Object, `_`).fromPercept)
    } then {
        execute("getDirectionToMove"(Direction))
        execute("move"(Direction))
        achieve("reach"(Object))
    }
}