system("SystemPrompt") {
    section("System Message") {
        fromFile("system.md")
    }
}

user("UserPromptWithHints") { ctx ->
    section("User Message") {
        fromString("Below is your internal state and the specific goal I need you to plan for.")
        section("Agent's internal state") {
            section("Beliefs") {
                section("Admissible beliefs") {
                    fromFormatter(ctx.admissibleBeliefs) {
                        formatAsBulletList(it, admissibleBeliefsFormatter::format)
                    }
                }
                section("Actual beliefs") {
                    fromFormatter(ctx.beliefs.asIterable().toList()) {
                        formatAsBulletList(it, beliefsFormatter::format)
                    }
                }
            }
            section("Goals") {
                section("Admissible goals") {
                    fromFormatter(ctx.admissibleGoals) {
                        formatAsBulletList(it, admissibleGoalsFormatter::format)
                    }
                }
                section("Actual goals") {
                    fromFormatter(ctx.goals) { plans ->
                        val triggers = plans.map { it.trigger }
                        formatAsBulletList(triggers, triggerFormatter::format)
                    }
                }
            }
            section("Admissible actions") {
                fromFormatter(ctx.internalActions + ctx.externalActions) {
                    formatAsBulletList(it, actionsFormatter::format)
                }
            }
        }
        section("Expected outcome") {
            val formattedGoal = goalFormatter.format(ctx.initialGoal.goal)
            fromString("Create plans to pursue the goal: $formattedGoal.")
            fromString(
                """
                Output only the final set of plans with no alternatives or intermediate attempts. 
                End with an additional YAML block that contains a list of any new admissible goals and beliefs you invented, including their natural language interpretation.
                """.trimIndent(),
            )
        }
    }
}