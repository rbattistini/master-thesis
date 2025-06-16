# Background

You are a Belief-Desire-Intention (BDI) agent.
You have to devise a plan to pursue one goal.
The more general the plan, the better.
You encode beliefs as first-order-logic (FOL) facts.
You encode goals as FOL terms.
You encode plans as triplets of the form (event, condition, operation), where "event" is the goal to be pursued, "condition" is a FOL formula to be tested against the current beliefs, and "operation" is a list of activities to be performed to pursue "goal".

Events must be prefixed with a keyword according to their type:

- `achieve`: use when defining goals that the agent should actively work towards achieving. Once triggered, it initiates a plan to achieve a specific outcome. For example, "achieve reach(home)" means the agent wants to reach a state where it is at home.

Operations must be prefixed with a keyword according to their type:

- `execute`: use for primitive actions that directly interact with the environment or other agents. These are atomic operations that can't be decomposed further. For example, `execute move(north)`;
- `achieve`: use to set a new subgoal that needs to be achieved, which will trigger another plan. For example, `achieve reach(rock)`;
- `add`: use to add a new belief to the belief base. For example, `add visited(current_location)`;
- `remove`: use to remove an existing belief from the belief base. For example, `remove obstacle(north)`;
- `update`: use to modify an existing belief in the belief base. For example, `update position(X, Y)` to change the agent's position.

Primitive actions are FOL terms, which are interpreted as functions (with actual arguments) that the agent may invoke to act on the environment (or on itself).
Below is a representation of your internal state.
For each item of the state, both the FOL syntax and the natural language interpretation are provided.

# Agent's internal state

## Beliefs

### Admissible beliefs

- obstacle(Direction): there is an obstacle to the `Direction`
- there_is(Object, Direction): there is an `Object` in the given `Direction`
- direction(Direction): `Direction` is a direction
- object(Object): `Object` is an object

### Actual beliefs

- direction(north): north is a direction
- direction(south): south is a direction
- direction(east): east is a direction
- direction(west): west is a direction
- direction(north_east): north_east is a direction
- direction(north_west): north_west is a direction
- direction(south_east): south_east is a direction
- direction(south_west): south_west is a direction
- direction(here): here is a direction
- object(rock): rock is an object
- object(home): home is an object
- free(north): there is no obstacle to the north
- free(east): there is no obstacle to the east
- free(west): there is no obstacle to the west
- free(north_east): there is no obstacle to the north_east
- free(north_west): there is no obstacle to the north_west
- obstacle(south): there is an obstacle to the south
- obstacle(south_east): there is an obstacle to the south_east
- obstacle(south_west): there is an obstacle to the south_west

## Goals

### Admissible goals

- achieve reach(Object): reach a situation where `Object` is in the position of the agent (i.e. there_is(`Object`, here))

### Actual goals

None.

## Admissible actions

- print(Message, Payload): prints a `Message` and its `Payload`
- fail(): makes the agent fail its current intention
- stop(): stops the agent
- pause(): pauses the agent
- sleep(Time): makes the agent sleep for `Time` milliseconds
- move(Direction): move in the given `Direction`
- getDirectionToMove(Direction): provides a `Direction` free of obstacles where the agent can then move

## Remarks

None.

# Expected outcome

You must output only the final set of plans to pursue the goal reach(home), with no alternatives.
Format each plan as follows:
```yaml
EVENT: achieve event to be pursued
CONDITIONS:
  - condition to be satisfied
  - other conditions to be satisfied
  - ...
OPERATIONS:
  - [execute|achieve|add|remove|update] operation
  - [execute|achieve|add|remove|update] other operations
  - ...
```

Separate plans with a bar such as `---`.
Represent the lack of conditions or operations with the word `<none>`.

Events can be drawn from the admissible goals.
Conditions can be logic formulas over the beliefs, possibly involving negation and logical connectives.
Operations can be drawn from the admissible actions or from the admissible goals.
You can invent new admissible goals or beliefs, but you cannot invent admissible actions.
Only use FOL syntax, with no quantifiers.

In the end, provide a list of admissible goals and beliefs that you invented, along with their natural language interpretation.
For example:
```yaml
- goal: `my_goal(X)`
  purpose: natural language interpretation of my_goal for a general X
- belief: `my_belief(Y)`
  purpose: natural language interpretation of my_belief for a general Y
- ...
```

Be as general and minimal as possible: use variables instead of constants where appropriate, reuse patterns across plans, and avoid over-specification.

Do not show intermediate attempts, incorrect plans or rejected versions.
The output must contain a block with the admissible goals and beliefs and a block with the final, clean, and minimal plan set.
