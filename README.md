# Songs

A java spring web app that provide users with form to add albums information and submit the album data to a database and
then add songs to an album and render songs and album songs.

use the endpoint `localhost:8080/albums`

## Related Resources and Integration Testing lab 13

to run this app correctly please follow steps:

1. `http://localhost:8080/album` to add an album, it wll redirect you to step 2
2. `http://localhost:8080/songs/newSong` to add song
3. `http://localhost:8080/songs/album/{album}` to render songs that belongs to a specific album