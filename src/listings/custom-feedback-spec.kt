externalAction("move", "direction") {
    val env = environment as? GridWorldEnvironment
    if (env != null) {
        val updatedEnvState = env.parseAction(actionName)
        val oldPosition = env.data.state()?.agentPosition
        if (updatedEnvState != null && oldPosition != null) {
            updateData("state" to updatedEnvState)
            val newPosition = updatedEnvState.agentPosition
            val feedback = updatedEnvState.objectsPosition.entries
                .find { it.value == newPosition }
                ?.let { ObjectReachedEvent(it.key, arguments) }
                ?: MoveActionSuccess(oldPosition, newPosition, arguments)
            addFeedback(feedback)
        }
    }
}