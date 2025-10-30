# Java Project - The Game of Cut

## Overview
___
**Objective:** For this project, we'll create a deck of unique card objects we can use to play card games. We'll begin by creating a unique card object, then a deck, and then we'll apply that deck to a main program for various card games. This project is designed to reinforce your understanding of:
- Objects
- Arrays
- Object Handlers

## Key Requirements
___
By the end of this project, your program should allow for the following functionality:
- [ ] Each **Card Object** should be able to store its unique value and suit. Those values should be retrievable individually and through a *toString()* method.
- [ ] The **Card Deck** should be responsible for creating a normal 52-card deck, shuffling it, and 'dealing' cards.
- [ ] The **Main Program** should run through a single game of *Cut*
- [ ] For each game, the **user will first** cut the deck from any position, and then store the value of the card at that portion.
- [ ] The **CPU will then** cut the deck from the remaining stack of cards, exclusive of all the cards from the first to the position the person cut.
- [ ] The **Winner of the game** is determined by the scoring guide in the section below. The first player to win *three out of five* games is the overall winner!

*Note: For this project, you do not need to have the game re-start after a winner is decided. The program can safely end.*

## Card Object
___
For this portion, you’ll be tasked with creating a Card class, which will eventually be used to populate a 52 card deck.

| Name                     | Type                    | Purpose                                                                                                                              |
| ------------------------ | ----------------------- | ------------------------------------------------------------------------------------------------------------------------------------ |
| face                     | *final int*             | The face of the card (1-13) (In this case, 1 = Ace, 13 = King)                                                                       |
| suit                     | *final int*             | The suit of the card (1 = Spade, 2 = Heart, 3 = Club, 4 = Diamond)                                                                   |
| faces                    | *final* String[]        | An array that contains the String character for the value of the card. (i.e. if the card is a 1, we use this array to display "Ace") |
| suits                    | *final* String[]        | An array that contains the String character for the suit of the card. (i.e. if the suit is 1,  we can use this array to display "♠") |
| Card(int face, int suit) | Constructor             | Creates a new Card object with the face and suit values stored as integers.                                                          |
| *getFace()*              | Accessor                | Getter for face.                                                                                                                     |
| *getSuit()*              | Accessor                | Getter for suit.                                                                                                                     |
| *toString()*             | String Display Function | Displays the String format of the card (i.e. "Ace of ♠")                                                                             |
## Deck Object
___
The next two parts are more free-form, and require some design decisions we'll make together as a class. Your deck should perform the following actions:
- [ ] On construction, create a 52-index array which will be filled with Cards.
- [ ] Using a function, populate the deck with a fresh set of cards.
	- [ ] 1-13 of each of the 4 suits.
- [ ] Shuffle the deck.
- [ ] Remove a card from a specific index and shorten the array by one card.
- [ ] Return the current contents of the deck as a String.

## The Game of Cut
___
For this portion, we'll test out our deck by playing a simple game of cut. Each game should run in a file called *Main.java*, and run like so:
1. A deck of 52 cards is shuffled.
2. The first player chooses a position from the first card to the *second to last card* to 'cut' the deck. They retain that card.
3. The second player chooses a position from the place the first player cut to the *end of the deck.* They retain that card.
4. Both players compare their chosen cards according to the following scoring guide: 
	1. The highest value of the card wins (In this game, we'll consider an Ace as a 1)
	2. If the values are the same, the suit priority wins: Spades > Hearts > Clubs > Diamonds
5. The game repeats with a freshly shuffled deck. The first player to score three points out of a total of five games is the winner.

## Submission Guidelines
Please submit your file by pushing all changes to your assigned git repository. Your submission should include the following:
- Your main Java file(s). For this project your submission should have *Lastname_GameOfCut* at the top, as well as the date in the header.
- **At least three** screenshots of terminal output done from your own testing. Include them in the same directory as your Java files, under a folder labelled "Screenshots".
## Grading Schema
### Summative Assessments & Projects
*In an effort to provide students with more consistent grades & feedback, I am following a grading schema called **specification grading**. The rules for the version I will  implement are simple:*

- Each project has a certain number of “features” that are required to be considered a complete project. Students are graded by each outlined feature according to the table below and then provided feedback on how they can improve. Point allocation will also be accompanied by comprehensive feedback that provides additional guidance to the student.
- If a student wishes to improve on their project they are allotted up to one and a half weeks from receiving the feedback to provide a re-submission and notify their teacher. Corrections made will receive partial credit. 
- Late or incomplete programs will receive a point reduction that emphasizes the importance of turning in assignments on time without making the potential loss “not worth the effort” of doing the assignment. 
- Late assignments will receive a reduction of 5% in total possible points for each school day it is late. If the assignment is not turned in by the end of the week the assignment is due AND the student has not contacted the instructor, it will be considered as missing (MIS) in the gradebook.
- If the student contacts the instructor and informs them that their assignment will be late, that instructor can extend the assignment’s due date for that student. The above rule applies to the new projected due date.
- Assignments where it is evident that the student has not provided sufficient effort (i.e. the example/template code is the only thing that has been submitted) will be considered as missing (MIS) in the gradebook.
- Due to the nature of programming assignments, any project that cannot be executed by the instructor will be considered as missing (MIS) in the gradebook. However, if a student re-submits that project in an executable state within the due date, they will not incur any penalties.
### Point Allocation Table - Summative Assignment Features (General)

| Score | Problem Solving                                                                                                                                  |     |
| ----- | ------------------------------------------------------------------------------------------------------------------------------------------------ | --- |
| 5     | Response gives evidence of a complete understanding of the problem; is fully developed; is clearly communicated.                                 |     |
| 4     | Response gives the evidence of a clear understanding of the problem but contains minor errors or is not fully communicated.                      |     |
| 3     | Response gives evidence of a reasonable approach but indicates gaps in conceptual understanding. Explanations are incomplete, vague, or muddled. |     |
| 2     | Response gives some evidence of problem understanding but contains major programming or reasoning errors.                                        |     |
| 1     | No response or response is completely incorrect or irrelevant.                                                                                   |     |





