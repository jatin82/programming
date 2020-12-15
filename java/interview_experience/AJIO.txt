Download Manager

Features

2. Dowloaded it permanent storage.
3. Multiple Downloads.
4. Start/Resume Functionality.
5. Set Download Speed.
6. Progress Bar - Percentage completed, Recieving Speed.
7. Chunks Downloads - That


-------------------------------
1. URL provide start DOwnload
2. Dowloaded it permanent storage.
3. Multiple Downloads.
4. Start/Resume Functionality.
6. Progress Bar - Percentage completed

----------------------------------
7. Chunks Downloads - That


--------------------------------

NOSQL

MongoDB

1. DownloadID
2. DOwnloadURL
3. FileStorage URL
4. Completed - DownloadedSize
5. Status - Start/Pause/Completed
6. MetaData - Name,Description,Created,LastUpdated,FileSize


------------------
With Chunks

1. DownloadID
2. DOwnloadURL
3. FileStorage URL
4. Completed - DownloadedSize
5. MainStatus - Start/Pause/Completed
6. MetaData - Name,Description,Created,LastUpdated,FileSize
7. List<Chunks> chunkId


---
Chunk
1. ChunkId
2. ChunkFileStorageURL - FileStorage 
3. ChunkSize
4. ChunkCompleted
5. ChunkStatus - Start/Pause/Completed
6. Chunk Bounds - startBound, endBound

--

Movie1 = 700 MB 
700/10 = 70 Mb each chunk 

---
Pause
Mark them as ChunkStatus,MainStatus Pause

Start
1. Find all the chunks Pause and not completed
2. Download on basis of Bounds


--------
Merging
1. ChunkFileStorageURL merge them FFMPEG with fomat , we can get from MEtadata


Corner Case :
if we have corupted Chunk 
 1. redownload
 2. still it's incorrect skip that chunk


