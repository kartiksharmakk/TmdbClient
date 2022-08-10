When the user views the movie data for the first time, App will

download them from the TMDB API.

TMDB api will

send us the first 20 movies in the most popular list.

Then app will save

those data to the room database. From the room database, app will get the list and display them to the

user using a

RecyclerView.

We will also use a temporary cache to improve the performance..

When the user clicks on the update movies icon, app will clear the database

table, download lateset list of most popular movies from the TMDB API, save them to the database and

display them to the user in a recyclerVIew.

In order to implement those functionalities in this repository class we need to use a remote data source,

local data source and a cache data source.




remote data source will take data from api , local data source will take data from DB