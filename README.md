# My Personal Project

##  WatchList Application:


### `Proposal: `

My proposal for my term project is to create an application that allows the user to log TV shows or movies they are \
watching. The most basic objective for this application is to allow to organize TV shows or Movies into lists such as \
*"planning to watch"*, *"currently watching"*, *"dropped"*, *etc*.

As of right now, I envision the following additional features for the application:
- The ability for the user to provide ratings for a TV show or Movie
- The ability to perform basic statistics on across ratings in a Watchlist

This project is interesting to me as I like using services such as *myAnimeList*, or *aniList*, and I would like to try\
and take the best features that I love from those services and try to implement them myself in my application.

## User Stories:
- As a user, I would like to add Movies and TV shows to a watchlist
- As a user, I would like to be able to add a rating for my TV shows and Movies
- As a user, I would like to keep track and organize different watch lists such as a \
*currently watching*, *planning to watch*, or *dropped* list
- As a user, I would like to calculate the average rating across a category of my watchlist


- As a user, I would like to save the current state of my watchlist to file
- As a user, I would like to be able to load my saved watchlist from a file
- As a user, it would be nice to be able to see the titles of the media items in my watchlist
## Instructions for Grader:

- The application can be launched from main

### To add Media to your WatchList (First required event):
- Click the *"Add media to Watchlist"* button
- Input the type of media you are adding (*"movie"* if the media is a movie, otherwise *"tv"* if it is a TV show)
- Input the title of the media you are adding
- Input the release year
- Input the release month
- Input the release day
- Input the genre of the media you are adding
- Input either *"currently-watching"*, *"dropped"*, or *"planning-to-watch"* to add your media to the desired watchlist category


### To view the contents of your watchlist (Second required event):
- Click the *"View watchlist contents"* button
- A window will open showing you the title of the media objects in each watchlist category plus the size of the list in 
each category

### Visual component:
- My visual component can be located on the main window of the application

### Saving:
- You can save the state of the application by clicking on the *"Save the state of the application"* button

### Loading:
- You can load from a saved state of the application by clicking on the *"Load from save"* button

### For fun:
Here are the directions for the rest of the program if you get bored and keep wanting to look at Gura (the picture):

To rate media objects:

- Click the *"Rate media in watchlist"* button
- Input either *"currently-watching"*, *"dropped"*, or *"planning-to-watch"*
- Input the title of the media object that you wish to rate
- Input a rating between 0 and 100
- Success!

To view the average rating in a watchlist category:
- Click the *"Calculate the average rating in a watchlist category"* button 
- Input either *"currently-watching"*, *"dropped"*, or *"planning-to-watch"*
- Enjoy ^


## Sample Event Log (Phase 4: Task 2)
Wed Aug 10 13:30:32 PDT 2022
Media added to currently-watching watchlist

Wed Aug 10 13:30:53 PDT 2022
Media added to planning-to-watch watchlist

Wed Aug 10 13:31:13 PDT 2022
Viewed contents of watchlist across all categories

Wed Aug 10 13:31:41 PDT 2022
Media added to dropped  watchlist

Wed Aug 10 13:31:56 PDT 2022
Viewed contents of watchlist across all categories


## Phase 4: Task 3

