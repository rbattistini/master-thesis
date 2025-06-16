EVENT: achieve reach(Object)
CONDITIONS:
  - there_is(Object, here)
OPERATIONS:
  - <none>

EVENT: achieve reach(Object)
CONDITIONS:
  - there_is(Object, Direction)
OPERATIONS:
  - execute move(Direction)

EVENT: achieve reach(Object)
CONDITIONS:
  - not(there_is(Object, _))
OPERATIONS:
  - execute getDirectionToMove(Direction)
  - execute move(Direction)
  - achieve reach(Object)
