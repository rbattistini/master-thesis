val metaPlanFilter = ContextFilter { extendedContext ->
    extendedContext.createNewTriggerFromGoal()?.let { trigger ->
        val generationPlanId = GenerationPlanBuilder.getGenerationPlanID(trigger)
        extendedContext.copyWithFilteredPlans { plan ->
            plan.id != generationPlanId &&
                    plan.trigger !is TestGoalFailure &&
                    plan.trigger !is AchievementGoalFailure
        }
    } ?: extendedContext
}