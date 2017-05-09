# Android Unsplash (Unofficial)
An unofficial Unsplash API library for Android

## Usage

### Get A List of Photos
~~~~~
Unsplash unsplash = new Unsplash(YOUR_CLIENT_ID);
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
Unsplash unsplash = new Unsplash(YOUR_CLIENT_ID);
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

## To-Do
+ Statistics
+ Actions that require user authentication
