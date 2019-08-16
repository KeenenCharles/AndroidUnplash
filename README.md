# Android Unsplash (Unofficial)
An unofficial Unsplash API library for Android

## Gradle
Add the line below to your build.gradle to use:
~~~
dependencies {
    implementation 'com.kc.androidunsplash:androidunsplash:1.0.5'
}
~~~

## Usage

### Initialize Unsplash Client
~~~~~
Unsplash unsplash = new Unsplash(YOUR_CLIENT_ID);
~~~~~
You can create an app for your project at <https://unsplash.com/developers>
You'll receive a Client ID and a Client Secret

### User Authentication
Unsplash uses OAuth2 for user authentication.

You can call the `authorize()` method to start the process with the scopes you require access to. Ensure those scopes have been turned on in the Unsplash project dashboard.

~~~~~
List<Scope> scopes = new ArrayList<>();
scopes.add(Scope.PUBLIC);
scopes.add(Scope.READ_USER);
scopes.add(Scope.WRITE_USER);
unsplash.authorize(MainActivity.this, "example://androidunsplash/callback", scopes);
~~~~~

If your app is mobile only you can create a `redirectURI` by [defining a URI scheme](https://developer.android.com/training/app-links/deep-linking) in your Manifest 

Once the user has been redirected to your app you can need to retrieve the `code` parameter provided in the Intent and call the `getToken()` method.

~~~~~
unsplash.getToken(CLIENT_SECRET, "example://androidunsplash/callback", code, new Unsplash.OnTokenLoadedListener() { ... });
~~~~~

Add the token you receive to your unsplash client to authenticate user-related requests.
~~~~~
unsplash.setToken(token.getAccessToken());
~~~~~

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

## Built With This Library
+ [Walldrobe](https://play.google.com/store/apps/details?id=walldrobe.coffecode.com)
+ [Love Diary](https://play.google.com/store/apps/details?id=com.kilic.tweetydiary)
+ [Advice](https://play.google.com/store/apps/details?id=my.sustento.apeaceofadvice)

# License
~~~
MIT License

Copyright (c) 2017 Keenen Charles

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

~~~
