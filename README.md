Repo for commiting the home assignment as part of the Intuit interview process.

some notes:
in this implementation, it was assumed that the CSV will not change, not in data and not in structure.
in addition, it was assumed that since GET was all that was required, and the CSV had quite a number of rows, time complexity would be preferred over memory, and therefore the data was parsed and stored in a HashMap.
in addition, as data was not going to be edited, it was superfluous and wasteful to store data in DB, rather that the initial time to parse the CSV.

given enough time, i would write some tests for outlying cases - blank rows, shortened rows, rows that contain the wrong data (int for date, strings for number fields, etc.).
Another thing i would do, if given the time, would be to find a more elegant solution to the shortened rows.

in addition, the data layer is such that changing the storage from Item based to DB based would require minimal changes, and only to that layer, as each layer is decoupled from the rest.
