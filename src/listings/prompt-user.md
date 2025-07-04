# User Message
Below is your internal state and the specific goal I need you to plan for.

## Agent's internal state
### Beliefs
#### Admissible beliefs
- obstacle(Direction): there is an obstacle to the `Direction`
- there_is(Object, Direction): there is an `Object` in the given `Direction`
- direction(Direction): `Direction` is a direction
- object(Object): `Object` is an object

#### Actual beliefs
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

### Goals
#### Admissible goals
- achieve reach(Object): reach a situation where `Object` is in the position of the agent (i.e. there_is(`Object`, here))

#### Actual goals
None.

### Admissible actions
- fail(): makes the agent fail its current intention
- stop(): stops the agent
- pause(): pauses the agent
- sleep(Time): makes the agent sleep for `Time` milliseconds
- move(Direction): move in the given direction: `Direction`
- getDirectionToMove(Direction): provides a Direction free of obstacles where the agent can then move

## Expected outcome
Create plans to pursue the goal: achieve reach(home).
Output only the final set of plans with no alternatives or intermediate attempts. 
End with an additional YAML block that contains a list of any new admissible goals and beliefs you invented, including their natural language interpretation.