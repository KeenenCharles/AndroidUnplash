# Android Unsplash (Unofficial)
An unofficial Unsplash API library for Android

## Usage

### Initialize Unsplash Client
~~~~~
Unsplash unsplash = new Unsplash(YOUR_CLIENT_ID);
~~~~~
You can sign up for a client id at <https://unsplash.com/developers>

### Get A List of Photos
~~~~~
unsplash.getPhotos(1, 10, Order.LATEST, new Unsplash.OnPhotosLoadedListener() {
    @Override
    public void onComplete(List<Photo> photos) {
        int photoCount = photos.size();
    }

    @Override
    public void onError(String error) {
        Log.v("Error", error);
    }
});
~~~~~

### Get A Photo By Id
~~~~~
unsplash.getPhoto(PHOTO_ID, new Unsplash.OnPhotoLoadedListener() {
    @Override
    public void onComplete(Photo photo) {
        String photoUrl = photo.getUrls().getRegular();
    }

    @Override
    public void onError(String error) {
        Log.v("Error", error);
    }
});
~~~~~

### Search
~~~~~
unsplash.searchPhotos(query, new Unsplash.OnSearchCompleteListener() {
    @Override
    public void onComplete(SearchResults results) {
        Log.d("Photos", "Total Results Found " + results.getTotal());
        List<Photo> photos = results.getResults();
    }

    @Override
    public void onError(String error) {
        Log.d("Unsplash", error);
    }
});
~~~~~

## Other Features
~~~~~
getCuratedPhotos()
getRandomPhoto()
getRandomPhotos()
getPhotoDownloadLink
getCollections()
getFeaturedCollections()
getCuratedCollections()
getRelatedCollections()
getCollection()
getCuratedCollection()
getCollectionPhotos()
getCuratedCollectionPhotos()
getStats()
~~~~~

Take a look at the API documentation for what each call does in detail <https://unsplash.com/documentation>

## To-Do
+ User Authentication
