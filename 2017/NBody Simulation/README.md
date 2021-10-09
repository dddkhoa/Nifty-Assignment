### Simulate the universe and more!
This is the <a href="https://fa20.datastructur.es/materials/proj/proj0/proj0">CS61B-Berkeley</a> version of the 2017 Nifty Assignment - **NBody Simulation** by Kevin Wayne.
<br>
<br>
You can use the materials from either the <a href="http://nifty.stanford.edu/2017/wayne-nbody/">Nifty Assignment</a> sources or <a href="https://fa20.datastructur.es/materials/proj/proj0/proj0">CS61B</a> (Both use **Java**). I personally find the instructions from CS61B course to be clearer and easier to follow.
<br>
### Description
This assignment aims at simulating the motion of N objects in a plane based on the laws of universial gravitation by Newton. Most of the codes are in Body.java - which constructs
the objects with their coordinates and velocities (i.e. planets in the 2nd gif below) and NBody.java - which updates their positions when net force from other objects are applied 
during a certain period of time.
<br>
### Run Simulation
There are many simulations you can try (see in the "data" folder). To run the program, simply type in your terminal: "java T dt ./data/x.txt" (with T and dt can be any positive
large doubles, x.txt can be any .txt files in "data".
<br>
#### Examples
java NBody 20000000 20000 ./data/suninterference.txt
<br>
<img src="https://github.com/kaisergod47/Nifty-Assignment/blob/main/2017/NBody%20Simulation/gifs/sun.gif" width="600" height="400"/>
<br>
java NBody 157788000.0 25000.0 data/planets.txt
<br>
<img src="https://github.com/kaisergod47/Nifty-Assignment/blob/main/2017/NBody%20Simulation/gifs/planets.gif" width="600" height="400"/>

