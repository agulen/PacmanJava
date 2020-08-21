Welcome to the Pacman Java lesson plan! I hope you find this repository useful for learning and experimenting with code. Before getting started with coding, you will need to set up a proper Java development environment. To do that, you will need to download and install the latest [Java Development Kit](https://www.oracle.com/java/technologies/javase-downloads.html) and a Java IDE. For the IDE, I would recommend [Eclipse](https://www.eclipse.org/downloads/). 

## Part 1 

### Goal: Render Pacman at the top-left coordinate of the screen

**Steps to accomplish that:**
- Create a `Pacman` class. It should contain:
    - Member Variables
        - An integer for a x-coordinate
        - An integer for a y-coordinate
        - An ImageIcon for a Pacman image
    - Functions
        - A constructor to initialize the member variables
        - Getter and setter for each member variable
        - A `draw` function to draw Pacman to the screen. What paramater will that function need to draw something to the screen?

**You are given:**
- A `Game` class, which will render a window to the screen for you. Read through the comments to understand how the code works. Try running the program before writing any code to see the window appear.
- A folder of images, which has an image of Pacman to display
