# PagingDemo

## Concepts

### RemoteMediator

implementation helps load paged data from the network into the database, doesn’t load data directly into the ui 

1. When add data, The Paging Lib calls it’s `load()`；  This function typically fetches the new data from a network source and saves it to local storage. 
2. Load data from remote into PagingSource, may call  callback defined in RemoteMediator 

### PagingSource(single source of truth)
local source wrapper. handles loading cached data from the database into the UI.

1. Loads data and return  LoadResult.

### Pager:
  1.  Pass PagingSource to Pager  through the pagingSourceFactory parameter.

## Ref
1. https://developer.android.com/topic/libraries/architecture/paging/v3-paged-data
2. https://developer.android.com/jetpack/guide#truth
